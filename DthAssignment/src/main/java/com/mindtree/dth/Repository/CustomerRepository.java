package com.mindtree.dth.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.dth.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
