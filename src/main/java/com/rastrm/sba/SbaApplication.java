package com.rastrm.sba;

import com.rastrm.sba.entity.Customer;
import com.rastrm.sba.entity.Product;
import com.rastrm.sba.repository.CustomerRepository;
import com.rastrm.sba.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLException;

@SpringBootApplication
public class SbaApplication implements CommandLineRunner {
	private final CustomerRepository customerRepository;
	private final ProductRepository productRepository;

	public SbaApplication(CustomerRepository customerRepository, ProductRepository productRepository) {
		this.customerRepository = customerRepository;
		this.productRepository = productRepository;
	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		SpringApplication.run(SbaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			System.out.println("Введите ID покупателя (1-3)");
			Customer customer = customerRepository.findByID(Integer.parseInt(reader.readLine()));
			System.out.println(customer.toString() + " " + customer.getProductList());
			System.out.println("Введите ID продукта (1-4)");
			Product product = productRepository.findByID(Integer.parseInt(reader.readLine()));
			System.out.println(product.toString() + " " + product.getCustomersList());
		}
	}
}
