package com.commonmicroservices.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.commonmicroservices.exception.NotFoundException;

import java.util.Optional;

@Service
public class CommonServiceImpl<E,R extends CrudRepository<E,Long>> implements ICommonService<E>{

    @Autowired
    protected R repository;

    @Override
    @Transactional(readOnly=true)
    public Iterable<E> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public Optional<E> findById(Long id) throws NotFoundException{
        Optional<E> optionalStudent = repository.findById(id);
        if(optionalStudent.isEmpty()){
           throw new NotFoundException("Entity not found");
        }
        return optionalStudent;
    }

    @Override
    @Transactional
    public void save(E entity) {
    	repository.save(entity);
    }

    @Override
    @Transactional
    public void deleteById(Long id) throws NotFoundException {
    	Optional<E> optionalStudent = this.repository.findById(id);
        if(optionalStudent.isEmpty()) {
        	throw new NotFoundException("Student not found");
        }
        this.repository.deleteById(id);
    }
}
