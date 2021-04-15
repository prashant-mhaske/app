package com.cg.cars.repositories;

import org.springframework.data.repository.CrudRepository;

import com.cg.cars.models.Admin;

public interface IAdminRepository extends CrudRepository<Admin, Long> {

}
