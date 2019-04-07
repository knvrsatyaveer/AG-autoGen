package com.join.autogeneral.repository;

import com.join.autogeneral.entity.AutoGen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by satyaveerkrovvidi on 6/4/19.
 */
@Repository

public interface AutoGenRepository extends JpaRepository<AutoGen,Integer> {

}

