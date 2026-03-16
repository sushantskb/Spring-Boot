package com.rahulgudu2003.tutorial.LearningSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearningSpringBootApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LearningSpringBootApplication.class, args);
	}

//	private RazorpayPaymentService paymentService = new RazorpayPaymentService();

//	@Autowired // field dependency injection
//	private RazorpayPaymentService paymentService; // final cannot be used.

	// constructor dependency injection
//	private final RazorpayPaymentService paymentService;
//	public LearningSpringBootApplication(RazorpayPaymentService paymentService) {
//		this.paymentService = paymentService;
//	} // most prefered beacuse here we are specifing which we want as dependency

	private final PaymentService paymentService;

	public LearningSpringBootApplication(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	@Override
	public void run(String... args) throws Exception {
		String payment = paymentService.pay();
		System.out.println("Payment Done: " + payment);
	}
}
