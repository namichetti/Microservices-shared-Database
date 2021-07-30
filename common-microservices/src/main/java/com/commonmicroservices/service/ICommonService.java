package com.commonmicroservices.service;


import java.util.Optional;

import com.commonmicroservices.exception.NotFoundException;

public interface ICommonService<E> {
   public Iterable<E> findAll();
   public Optional<E> findById(Long id) throws NotFoundException;
   public void save(E entity);
   public void deleteById(Long id) throws NotFoundException;

}
