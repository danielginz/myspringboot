package com.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tour.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
