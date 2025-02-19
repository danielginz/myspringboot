package com.tour.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tour.model.Address;
import com.tour.model.User;
import com.tour.repository.AddressRepository;
import com.tour.repository.UserRepository;
import com.tour.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
	
	private AddressRepository addressRepository;
	private UserRepository userRepository;
	
	public AddressServiceImpl(AddressRepository addressRepository, UserRepository userRepository) {
		this.addressRepository = addressRepository;
		this.userRepository = userRepository;
	}

	@Override
	public List<Address> addressList() {
		return addressRepository.findAll();
	}

	@Override
	public Optional<Address> findOne(Long id) {
		return addressRepository.findById(id);
	}

	@Override
	public Address addAddress(Address address) {
		User user = userRepository.findById(address.getUser().getId()).get();
		address.setUser(user);
		return addressRepository.save(address);
	}

	@Override
	public String deleteAddress(Long id) {
		addressRepository.deleteById(id);
		return "Address deleted successfully";
	}
	
	
}
