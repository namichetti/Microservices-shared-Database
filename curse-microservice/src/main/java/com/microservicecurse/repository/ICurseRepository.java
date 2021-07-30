package com.microservicecurse.repository;

import org.springframework.data.repository.CrudRepository;

import com.microservicecurse.model.Curse;

public interface ICurseRepository extends CrudRepository<Curse, Long>{

}
