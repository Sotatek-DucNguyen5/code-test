package com.example.codingtest.service;


import java.util.List;

public interface IBaseService<T> {
    List<T> findAll();

    T save(T t);
}
