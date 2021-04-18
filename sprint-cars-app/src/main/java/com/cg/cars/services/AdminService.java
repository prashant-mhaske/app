package com.cg.cars.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cars.exceptions.AdminNotFoundException;
import com.cg.cars.models.Admin;
import com.cg.cars.repositories.IAdminRepository;

/**
*
* @author TEAM 2
* MEMBERS:	Abhishek Sen
* 			Prashant Mhaske
*			Rishabh Gupta
* 			Akshay Talekar
*			Nikhil Nichit
*
*/

@Service
public class AdminService implements IAdminService {

	@Autowired
	IAdminRepository adminRepository;

	/**
	 * Add admin to the database
	 */
	
	@Override
	public Admin addAdmin(Admin admin) {
		return adminRepository.save(admin);
	}
	
	/**
	 * Remove admin from the database
	 */
	
	@Override
	public Admin removeAdmin(long UserId) {
		Admin admin = getAdmin(UserId);
		adminRepository.deleteById(UserId);
		return admin;
	}

	/**
	 * Update admin to the database
	 */
	
	@Override
	public Admin updateAdmin(long userId, Admin admin) {
		return adminRepository.save(admin);
	}

	/**
	 * Get admin from the database
	 */
	
	@Override
	public Admin getAdmin(long userId) {
		return adminRepository.findById(userId)
				.orElseThrow(() -> new AdminNotFoundException("Admin details not found!"));
	}

	/**
	 * Get all admins from the database
	 */
	
	@Override
	public List<Admin> getAllAdmins() {
		List<Admin> admins = new ArrayList<>();
		adminRepository.findAll().forEach(c -> admins.add(c));
		return admins;
	}
}
