package com.frostfire.budgetapp.dao;

import java.time.LocalDate;
import java.util.List;

public interface Dao<T> {
 void saveAll(List<T> objs);
 void delete(Long num);
 void add(T obj);
 List<T> getAll(LocalDate startDate, LocalDate endDate);

 boolean enityExist(Long id);
 void updateEnity(T obj);
}
