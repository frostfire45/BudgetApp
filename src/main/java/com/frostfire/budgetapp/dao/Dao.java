package com.frostfire.budgetapp.dao;

import java.util.List;

public interface Dao<T> {
 void saveAll(List<T> objs);
 void delete(Long num);
 void add(T obj);
 List<T> getAll();

 boolean enityExist();
}
