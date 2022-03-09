package com.askme.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.askme.model.AccountDetails;
import com.askme.model.NormalUser;
import com.askme.model.Orders;
import com.askme.model.OtherIssues;
import com.askme.model.Payment;
import com.askme.model.Shopping;
import com.askme.repository.AccountDetailsRepository;
import com.askme.repository.NormalUserRepository;
import com.askme.repository.OrdersRepository;
import com.askme.repository.OtherIssuesRepository;
import com.askme.repository.PaymentRepository;
import com.askme.repository.ShoppingRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class Controller {
	// Showing all records for Shopping Model class
	@Autowired
	ShoppingRepository shoppingRepository;

	@GetMapping("/shopping")
	public List<Shopping> getAllShopping() {
		try {
			return shoppingRepository.findAll();
		} catch (Exception e) {
			System.out.println("Probably the database is empty!");
			return null;
		}
	}

	// Showing all details for Account Details Model Class
	@Autowired
	AccountDetailsRepository accountDetailsRepository;

	@GetMapping("/accountdetails")
	public List<AccountDetails> getAllAccountDetails() {
		try {
			return accountDetailsRepository.findAll();
		} catch (Exception e) {
			System.out.println("Probably the database is empty!");
			return null;
		}
	}

	// Showing all details for Orders Model Class
	@Autowired
	OrdersRepository ordersRepository;

	@GetMapping("/orders")
	public List<Orders> getAllOrders() {
		try {
			return ordersRepository.findAll();
		} catch (Exception e) {
			System.out.println("Probably the database is empty!");
			return null;
		}
	}

	// Showing all details for Payment Model Class
	@Autowired
	PaymentRepository paymentRepository;

	@GetMapping("/payment")
	public List<Payment> getAllPayment() {
		try {
			return paymentRepository.findAll();
		} catch (Exception e) {
			System.out.println("Probably the database is empty!");
			return null;
		}
	}

	// Showing all records for Other Issues Model Class
	@Autowired
	OtherIssuesRepository otherIssuesRepository;

	@GetMapping("/otherissues")
	public List<OtherIssues> getAllOtherIssues() {
		try {
			return otherIssuesRepository.findAll();
		} catch (Exception e) {
			System.out.println("Probably the database is empty!");
			return null;
		}
	}

	// Now Below are GET and POST request for NormalUser
	@Autowired
	NormalUserRepository normalUserRepository;

	@GetMapping("/normaluser")
	public List<NormalUser> getAllNormalUser() {
		try {
			return normalUserRepository.findAll();
		} catch (Exception e) {
			System.out.println("Probably the database is empty!");
			return null;
		}
	}

	@PostMapping("/signin")
	public Object getNormalUser(@RequestBody NormalUser normalUser) {
		try {
			NormalUser _normalUser = normalUserRepository.findUser(normalUser.getUserName());
			if ((_normalUser.getPassword()).equals(normalUser.getPassword())) {
				System.out.println(_normalUser.getPassword());
				System.out.println(normalUser.getPassword());
				return _normalUser;
			} else {
				return false;
			}
		} catch (Exception e) {
//			e.printStackTrace();
			return false;
		}
	}

	@PostMapping("/signup")
	public ResponseEntity<NormalUser> postAllUser(@RequestBody NormalUser normalUser) {
		try {
			NormalUser _normalUser = normalUserRepository
					.save(new NormalUser(normalUser.getEmailID(), normalUser.getPassword(), normalUser.getFirstName(),
							normalUser.getLastName(), normalUser.getUserName()));
			return new ResponseEntity<>(_normalUser, HttpStatus.CREATED);

		} catch (Exception e) {
			System.out.println("Probably the database is empty!");
			return null;
		}
	}

}
