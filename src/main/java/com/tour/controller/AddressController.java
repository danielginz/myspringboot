package com.tour.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tour.model.Address;
import com.tour.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	private AddressService addressService;

	@RequestMapping("/delete/{id}")
	public String deleteAddress(@PathVariable Long id) {
		return addressService.deleteAddress(id);
	}
	
	@Autowired
	public AddressController(AddressService addressService) {
		this.addressService = addressService;
	}
	
	@RequestMapping("/add")
	public Address addAddress(@RequestBody Address address) {
		return addressService.addAddress(address);
	}
	
	@RequestMapping("/list/{id}")
	public Optional<Address> findOne(@PathVariable Long id) {
		return addressService.findOne(id);
	}
	
	@RequestMapping("/list")
	public List<Address> addressList() {
		return addressService.addressList();
	}
}
