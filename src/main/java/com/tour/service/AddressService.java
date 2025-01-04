package com.tour.service;

import java.util.List;
import java.util.Optional;

import com.tour.model.Address;

public interface AddressService {
	List<Address> addressList();
	
	Optional<Address> findOne(Long id);
	
	Address addAddress(Address address);
	
	String deleteAddress(Long id);
}
