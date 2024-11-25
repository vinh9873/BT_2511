package vn.ute.restcontroller;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

	private final List<Customer> customers = List.of(
			Customer.builder().id("001").name("Nguyễn Quốc Vinh").email("vinhnguyen@gmail.com").build(),
			Customer.builder().id("002").name("Quốc Vinh").email("quocvinh@gmail.com").build());

	@GetMapping("/hello")
	public ResponseEntity<String> hello() {
		return ResponseEntity.ok("Hello, Guest!");
	}

	@GetMapping("/customer/all")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<List<Customer>> getCustomerList() {
		return ResponseEntity.ok(this.customers);
	}

	@GetMapping("/customer/{id}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public ResponseEntity<?> getCustomerById(@PathVariable("id") String id) {
		List<Customer> filteredCustomers = this.customers.stream().filter(customer -> customer.getId().equals(id))
				.toList();

		if (filteredCustomers.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(filteredCustomers.get(0));
	}
}
