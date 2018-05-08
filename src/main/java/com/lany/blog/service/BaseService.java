package com.lany.blog.service;

public interface BaseService<T, ID> {
    T findById(ID id);
}
