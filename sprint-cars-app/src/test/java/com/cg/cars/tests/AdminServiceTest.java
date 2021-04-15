package com.cg.cars.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.cars.exceptions.AdminNotFoundException;
import com.cg.cars.exceptions.CustomerNotFoundException;
import com.cg.cars.models.Address;
import com.cg.cars.models.Admin;
import com.cg.cars.models.Customer;
import com.cg.cars.repositories.IAdminRepository;
import com.cg.cars.services.IAdminService;
import com.cg.cars.services.ICustomerService;

@SpringBootTest
public class AdminServiceTest {
	
	@Autowired
	IAdminService adminService;
	
	@MockBean
	IAdminRepository adminRepository;
	
	Admin admin;
	
	@BeforeEach
	public void init() {
		admin = new Admin(567, "passw");
	}
	
	@Test
	public void addAdminTest() {
		when(adminRepository.save(admin)).thenReturn(admin);
		assertEquals(admin, adminService.addAdmin(admin));
		verify(adminRepository,times(1)).save(admin);
	}
	
	@Test
	public void removeAdminbyIdTest() {
		when(adminRepository.findById(567L)).thenReturn(Optional.of(admin));
		when(adminRepository.existsById(567L)).thenReturn(false);
		adminService.removeAdmin(567L);
		verify(adminRepository,times(1)).deleteById(567L);
		assertFalse(adminRepository.existsById(567L));
	}
	
	@Test
	public void updateAdminTest() {
		when(adminRepository.save(admin)).thenReturn(admin);
		assertEquals(admin, adminService.updateAdmin(1L,admin));
		verify(adminRepository,times(1)).save(admin);
	}
	
	@Test
	public void getAdminByIdTest() {
		when(adminRepository.findById(567L)).thenReturn(Optional.of(admin));
		assertEquals(admin, adminService.getAdmin(567L));
		verify(adminRepository,times(1)).findById(567L);
	}
	
	@Test
	public void getAdminByIdNegativetest() {
		
		when(adminRepository.findById(568L)).thenThrow(AdminNotFoundException.class);
		assertThrows(AdminNotFoundException.class, () ->adminService.getAdmin(568L));
		verify(adminRepository, times(1)).findById(568L);
	}
	
	@Test
	public void getAllAdminTest() {
		 
		Admin admin2 = new Admin(6809 , "loc");
		Admin admin3 = new Admin(9087 , "god");
		
		List<Admin> admins=new ArrayList<>();
		admins.add(admin);
		admins.add(admin2);
		admins.add(admin3);
		when(adminRepository.findAll()).thenReturn(Stream
				.of(admin,admin2,admin3).collect(Collectors.toList()));
		assertEquals(admins, adminService.getAllAdmins());
		verify(adminRepository,times(1)).findAll();
	}
	
	@AfterEach
	public void tearDown() {
		admin = null;
	}


}
