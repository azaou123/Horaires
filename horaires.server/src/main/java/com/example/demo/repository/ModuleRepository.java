package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Modules;

@Repository
public interface ModuleRepository extends JpaRepository<Modules,Long>{

}
