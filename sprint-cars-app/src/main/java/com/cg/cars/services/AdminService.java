package com.cg.cars.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cars.exceptions.AdminNotFoundException;
import com.cg.cars.exceptions.CustomerNotFoundException;
import com.cg.cars.models.Admin;
import com.cg.cars.models.Customer;
import com.cg.cars.repositories.IAdminRepository;

@Service
public class AdminService implements IAdminService {

	@Autowired
	IAdminRepository adminRepository;

	@Override
	public Admin addAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	@Override
	public Admin removeAdmin(long UserId) {
		Admin admin = getAdmin(UserId);
		adminRepository.deleteById(UserId);
		return admin;
	}

	@Override
	public Admin updateAdmin(long userId, Admin admin) {
		return adminRepository.save(admin);
	}

	@Override
	public Admin getAdmin(long userId) {
		return adminRepository.findById(userId)
				.orElseThrow(() -> new AdminNotFoundException("Admin details not found!"));
	}

	@Override
	public List<Admin> getAllAdmins() {
		List<Admin> admins = new ArrayList<>();
		adminRepository.findAll().forEach(c -> admins.add(c));
		return admins;
	}
}
