
layui.use('jquery', function (exports) {

    var $ = layui.$;
    var tree;

    var setting = {
        async : {
            enable : true, // 是否开启异步加载模式
            url : basePath + "admin/menu/getTree",
            autoParam : ['id'] // 异步加载时，自动提交父节点属性的参数
        },
        data : {
            simpleData : {
                enable : true,
                idKey : 'id', // id编号命名
                pIdKey : 'pid',
                rootPId : 0 // 用于
            }
        },
        view: {
            showIcon: false,
            selectedMulti: false,
            addHoverDom: addHoverHandler,		//显示添加按钮
            removeHoverDom: removeHoverHandler	//隐藏添加按钮
        },
        edit: {
            enable: true,
            showRemoveBtn: showRemoveBtn,		//显示删除按钮
            removeTitle: "删除",
            showRenameBtn: showEditBtn,			//显示编辑按钮
            renameTitle: "编辑"
        },
        callback: {
            beforeRemove: beforeRemoveHandler,	//删除处理
            beforeEditName: beforeEditHandler	//编辑处理
        }
    };

    $.ajax({
        url : basePath + "admin/menu/getTree",
        type : 'Get',
        data : {pid : 0},
        dataType : 'json',
        success : function (result) {
            data = result.data;
            $.fn.zTree.init($("#menuTree"), setting, data);
            tree = $.fn.zTree.getZTreeObj("menuTree");
        }
    });

    /**
     * 显示添加按钮
     */
    function addHoverHandler(treeId, treeNode) {
        var nodes = tree.getSelectedNodes();
        if(nodes!=null && nodes.length>0){
            var selectNode = nodes[0];
            if(selectNode.id != treeNode.id){
                removeHoverHandler(treeId, selectNode);
            }
        }

//	if(treeNode.nodeType != 0)
//		return;	//非分公司节点不能添加子节点
        if(treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0)
            return;

        var sObj = $("#" + treeNode.tId + "_span");
        var addStr = "<span class='button add' id='addBtn_"+treeNode.tId+"' title='添加子节点' onfocus='this.blur();'></span>";
        sObj.after(addStr);
        var btn = $("#addBtn_"+treeNode.tId);
        if (btn) btn.bind("click", function(){
            //添加处理
            tree.selectNode(treeNode);
            showModal('add','editDiv');
            return false;
        });
    }

    //隐藏添加按钮
    function removeHoverHandler(treeId, treeNode){
        $("#addBtn_"+treeNode.tId).unbind().remove();
        $("#"+treeNode.tId+"_edit").unbind().remove();
        $("#"+treeNode.tId+"_remove").unbind().remove();
    }

    //显示删除按钮
    function showRemoveBtn(treeId, treeNode){
        if(!treeNode.parentId || treeNode.id == "44010028")
            return false;
        else
            return true;
    }

    //显示编辑按钮
    function showEditBtn(treeId, treeNode){
        return true;
    }

    //双击编辑
    function dbClickHandler(event, treeId, treeNode) {
        showModal('edit','editDiv');
    }

    function beforeRemoveHandler(treeId, treeNode){
        confirm("确认删除'"+treeNode.name+"'吗？",function(){
            $.ajax({
                type : "POST",
                url : basePath + "/organization/ajax/deleteOrgan",
                async: false,
                dataType : "text",
                data : {
                    id: treeNode.id
                },
                success : function(data) {
                    if (data == 1) {
                        tree.removeNode(treeNode, false);
                        alert("删除成功");
                    } else if(data == 2) {
                        alert("该机构下存在子机构，无法删除");
                    } else if(data == 3) {
                        alert("该机构下存在账号，无法删除");
                    } else {
                        alert("删除失败");
                    }
                }
            });
        });
        return false;
    }

    function beforeEditHandler(treeId, treeNode){
        tree.selectNode(treeNode);
        showModal('edit','editDiv');
        return false;
    }
});