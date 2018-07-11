package com.sachin.slog.common.base;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T, ID extends Serializable> {

    /**
     * 保存对象
     * @param t
     * @return
     */
    T save(T t);

    /**
     * 批量保存
     * @param iterable
     * @return
     */
    int saveBach(Iterable<T> iterable);

    /**
     * 通过ID删除对象
     * @param id
     * @return
     */
    void delete(ID id);


    void delete(T t);

    void delete(Iterable<T> iterable);

    T findById(ID id);


    T update(T t);

    void updateBatch(Iterable<T> iterable);

    List<T> findAll();
}
