package com.cg.cars.services;

import java.util.List;

import com.cg.cars.models.Admin;

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

public interface IAdminService {
	
	public Admin addAdmin(Admin admin);
	public Admin removeAdmin(long userId);
	public Admin updateAdmin(long userId, Admin admin);
	public Admin getAdmin(long userId);
	public List<Admin> getAllAdmins(); 

}
