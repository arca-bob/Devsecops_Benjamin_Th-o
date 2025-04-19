package com.example.devsecops;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DevsecopsApplicationTests {

	@Test
	void contextLoads() {
		Carfeature car = new Carfeature("Ferrari", 999, "11AA22");
		String brand = car.getBrand();
		assertEquals(brand,"Ferrari");
	}

}
