package com.sachin.slog.common.base;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Transactional
public abstract class BaseServiceImpl<T, ID extends Serializable> implements BaseService<T, ID> {

    public abstract JpaRepository getDao();

    @Override
    public T save(T t) {
        return (T) getDao().save(t);
    }

    @Override
    public int saveBach(Iterable<T> iterable) {
        List<T> result = getDao().saveAll(iterable);
        return result.size();
    }

    @Override
    public void delete(ID id) {
        getDao().deleteById(id);
    }

    @Override
    public void delete(T t) {
        getDao().delete(t);
    }

    @Override
    public void delete(Iterable<T> iterable) {
        getDao().deleteInBatch(iterable);
    }

    @Override
    public T findById(ID id) {
        return (T) getDao().findById(id).orElse(null);
    }


    @Override
    public T update(T t) {
        return (T) getDao().saveAndFlush(t);
    }

    @Override
    public void updateBatch(Iterable<T> iterable) {
        iterable.forEach(t -> update(t));
    }

    @Override
    public List<T> findAll() {
        return getDao().findAll();
    }
}
