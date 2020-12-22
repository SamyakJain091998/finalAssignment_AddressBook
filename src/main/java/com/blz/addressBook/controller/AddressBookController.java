package com.blz.addressBook.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blz.addressBook.exception.ResourceNotFoundException;
import com.blz.addressBook.model.Address;
import com.blz.addressBook.repository.AddressRepository;

@RestController
@RequestMapping("/api/v1/")
public class AddressBookController {

	@Autowired
	private AddressRepository addressRepository;

	@GetMapping("/addresses")
	public List<Address> getAllAddresses() {
		return addressRepository.findAll();
	}

	@PostMapping("/addresses")
	public Address createAddress(@RequestBody Address address) {
		return addressRepository.save(address);
	}

	@GetMapping("/addresses/{id}")
	public ResponseEntity<Address> getAddressById(@PathVariable long id) {
		Address address = addressRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
				"-----------Address with id: " + id + " doesn't exist!!-----------"));
		return ResponseEntity.ok(address);
	}

	@PutMapping("/addresses/{id}")
	public ResponseEntity<Address> updateAddress(@PathVariable long id, @RequestBody Address updatedAddress) {
		Address address = addressRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
				"-----------Address with id: " + id + " doesn't exist!!-----------"));
		address.setName(updatedAddress.getName());
		address.setPhoneNumber(updatedAddress.getPhoneNumber());
		address.setAddress(updatedAddress.getAddress());
		address.setCity(updatedAddress.getCity());
		address.setState(updatedAddress.getState());
		address.setZip(updatedAddress.getZip());

		Address updatedAddressDetails = addressRepository.save(address);
		return ResponseEntity.ok(updatedAddressDetails);
	}

	@DeleteMapping("/addresses/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteAddress(@PathVariable Long id) {
		Address address = addressRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
				"-----------Address with id: " + id + " doesn't exist!!-----------"));

		addressRepository.delete(address);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
