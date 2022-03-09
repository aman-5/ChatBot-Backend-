package com.askme.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.askme.model.AccountDetails;
import com.askme.model.Orders;
import com.askme.model.OtherIssues;
import com.askme.model.Payment;
import com.askme.model.Shopping;
import com.askme.repository.AccountDetailsRepository;
import com.askme.repository.OrdersRepository;
import com.askme.repository.OtherIssuesRepository;
import com.askme.repository.PaymentRepository;
import com.askme.repository.ShoppingRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")

public class AdminController {

	// SHOPPING ALL ADMIN CONTROLS
	@Autowired
	ShoppingRepository shoppingRepository;

	@PostMapping("/shopping")
	public ResponseEntity<Shopping> getAllShopping(@RequestBody Shopping shopping) {
		try {
			Shopping _shopping = shoppingRepository.save(new Shopping(shopping.getQueryName(), shopping.getQueryDescription()));
			return new ResponseEntity<>(_shopping, HttpStatus.CREATED);

		} catch (Exception e) {
			System.out.println("Probably the database is empty!");
			return null;
		}
	}

	@PutMapping("/shopping/{id}")
	public ResponseEntity<Shopping> updateShopping(@PathVariable("id") String id, @RequestBody Shopping shopping) {
		Optional<Shopping> shoppingData = shoppingRepository.findById(id);

		if (shoppingData.isPresent()) {
			Shopping _shopping = shoppingData.get();
			_shopping.setQueryName(shopping.getQueryName());
			_shopping.setQueryDescription(shopping.getQueryDescription());
			return new ResponseEntity<>(shoppingRepository.save(_shopping), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/shopping/{id}")
	public ResponseEntity<HttpStatus> deleteOtherShopping(@PathVariable("id") String id) {
		try {
			shoppingRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	// AccountDetails ALL ADMIN CONTROLS
	@Autowired
	AccountDetailsRepository accountDetailsRepository;

	@PostMapping("/accountdetails")
	public ResponseEntity<AccountDetails> getAllAccountDetails(@RequestBody AccountDetails accountDetails) {
		try {
			AccountDetails _accountDetails = accountDetailsRepository
					.save(new AccountDetails(accountDetails.getQueryName(), accountDetails.getQueryDescription()));
			return new ResponseEntity<>(_accountDetails, HttpStatus.CREATED);

		} catch (Exception e) {
			System.out.println("Probably the database is empty!");
			return null;
		}
	}

	@PutMapping("/accountdetails/{id}")
	public ResponseEntity<AccountDetails> updateAccountDetails(@PathVariable("id") String id,
			@RequestBody AccountDetails accountDetails) {
		Optional<AccountDetails> accountDetailsData = accountDetailsRepository.findById(id);

		if (accountDetailsData.isPresent()) {
			AccountDetails _accountDetails = accountDetailsData.get();
			_accountDetails.setQueryName(accountDetails.getQueryName());
			_accountDetails.setQueryDescription(accountDetails.getQueryDescription());
			return new ResponseEntity<>(accountDetailsRepository.save(_accountDetails), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/accountdetails/{id}")
	public ResponseEntity<HttpStatus> deleteOtherAccountDetails(@PathVariable("id") String id) {
		try {
			accountDetailsRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	// Orders ALL ADMIN CONTROLS
	@Autowired
	OrdersRepository ordersRepository;

	@PostMapping("/orders")
	public ResponseEntity<Orders> getAllOrders(@RequestBody Orders orders) {
		try {
			Orders _orders = ordersRepository
					.save(new Orders(orders.getQueryName(), orders.getQueryDescription()));
			return new ResponseEntity<>(_orders, HttpStatus.CREATED);

		} catch (Exception e) {
			System.out.println("Probably the database is empty!");
			return null;
		}
	}

	@PutMapping("/orders/{id}")
	public ResponseEntity<Orders> updateOrders(@PathVariable("id") String id,@RequestBody Orders orders) {
		Optional<Orders> ordersData = ordersRepository.findById(id);

		if (ordersData.isPresent()) {
			Orders _orders = ordersData.get();
			_orders.setQueryName(orders.getQueryName());
			_orders.setQueryDescription(orders.getQueryDescription());
			return new ResponseEntity<>(ordersRepository.save(_orders), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/orders/{id}")
	public ResponseEntity<HttpStatus> deleteOtherOrders(@PathVariable("id") String id) {
		try {
			ordersRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
	// Payment ALL ADMIN CONTROLS
	@Autowired
	PaymentRepository paymentRepository;

	@PostMapping("/payment")
	public ResponseEntity<Payment> getAllOrders(@RequestBody Payment payment) {
		try {
			Payment _payment = paymentRepository.save(new Payment(payment.getQueryName(), payment.getQueryDescription()));
			return new ResponseEntity<>(_payment, HttpStatus.CREATED);

		} catch (Exception e) {
			System.out.println("Probably the database is empty!");
			return null;
		}
	}

	@PutMapping("/payment/{id}")
	public ResponseEntity<Payment> updatePayment(@PathVariable("id") String id,@RequestBody Payment payment) {
		Optional<Payment> paymentData = paymentRepository.findById(id);

		if (paymentData.isPresent()) {
			Payment _payment = paymentData.get();
			_payment.setQueryName(payment.getQueryName());
			_payment.setQueryDescription(payment.getQueryDescription());
			return new ResponseEntity<>(paymentRepository.save(_payment), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/payment/{id}")
	public ResponseEntity<HttpStatus> deleteOtherPayment(@PathVariable("id") String id) {
		try {
			paymentRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// OTHER ISSUES ALL ADMIN CONTROLS
	@Autowired
	OtherIssuesRepository otherIssuesRepository;

	@PostMapping("/otherissues")
	public ResponseEntity<OtherIssues> getAllOtherIssues(@RequestBody OtherIssues otherIssues) {
		try {
			OtherIssues _otherIssues = otherIssuesRepository
					.save(new OtherIssues(otherIssues.getQueryName(), otherIssues.getQueryDescription()));
			return new ResponseEntity<>(_otherIssues, HttpStatus.CREATED);

		} catch (Exception e) {
			System.out.println("Probably the database is empty!");
			return null;
		}
	}

	@PutMapping("/otherissues/{id}")
	public ResponseEntity<OtherIssues> updateOtherIssues(@PathVariable("id") String id,
			@RequestBody OtherIssues otherIssues) {
		Optional<OtherIssues> otherIssuesData = otherIssuesRepository.findById(id);

		if (otherIssuesData.isPresent()) {
			OtherIssues _otherIssues = otherIssuesData.get();
			_otherIssues.setQueryName(otherIssues.getQueryName());
			_otherIssues.setQueryDescription(otherIssues.getQueryDescription());
			return new ResponseEntity<>(otherIssuesRepository.save(_otherIssues), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/otherissues/{id}")
	public ResponseEntity<HttpStatus> deleteOtherIssues(@PathVariable("id") String id) {
		try {
			otherIssuesRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
