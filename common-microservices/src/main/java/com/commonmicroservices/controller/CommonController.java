package com.commonmicroservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.commonmicroservices.exception.NotFoundException;
import com.commonmicroservices.service.ICommonService;


public class CommonController<E,S extends ICommonService<E>> {

    @Autowired
    protected S service;

    @GetMapping("/")
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) throws NotFoundException {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }
    
    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody E entity){
    	this.service.save(entity);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @PutMapping("/")
    public ResponseEntity<?> update(@RequestBody E entity) throws NotFoundException{
    	this.service.save(entity);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) throws NotFoundException{
    	this.service.deleteById(id); 
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
