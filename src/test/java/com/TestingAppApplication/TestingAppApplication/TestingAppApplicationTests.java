package com.TestingAppApplication.TestingAppApplication;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@Slf4j
class TestingAppApplicationTests {

	@BeforeEach
	void setUp() {
		log.info("Starting the method, setting up config");
	}

	@AfterEach
	void tearDown() {
		log.info("Tearing Down");
	}

	@BeforeAll
	static void setUpOnce() {
		log.info("Setup Once");
	}

	@AfterAll
	static void tearDownOnce() {
		log.info("Tear Down Once");
	}

	@Test
	//@Disabled
	void testNumberOne() {
        int a = 5;
		int b = 3;

		int result = addTwoNumbers(a,b);

//		Assertions.assertEquals(8, result); using junit
//		Assertions.

//		Assertions.assertThat(result) //using assert
//				.isEqualTo(7)
//				.isCloseTo(9, Offset.offset(1));

		assertThat("Apple")
				.isEqualTo("Apple")
				.startsWith("App")
				.endsWith("le")
				.hasSize(5);
	}

	@Test
	//@DisplayName("displayTestNameTwo")
	void testDivideTwoNumbers_whenDenominatorIsZero() {

		int a = 5;
		int b = 0;

		assertThatThrownBy(() -> divideTwoNumbers(a,b))
				.isInstanceOf(ArithmeticException.class)
				.hasMessage("Tried to divide by zero");
	}

	int addTwoNumbers(int a, int b) {
		return a+b;
	}

	double divideTwoNumbers(int a,int b) {
		try{
			return a/b;
		} catch(ArithmeticException e) {
			log.error("Arithmetic exception occured: "+e.getLocalizedMessage());
			throw new ArithmeticException("Tried to divide by zero");
		}
	}

}
