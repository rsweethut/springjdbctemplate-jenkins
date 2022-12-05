package com.java2blog.SpringBootJDBCExample;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.arpit.java2blog.SpringBootJdbcExampleApplication;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = SpringBootJdbcExampleApplication.class)
class SpringBootJdbcExampleApplicationTests {

	public static Logger LOGGER = LoggerFactory.getLogger(SpringBootJdbcExampleApplicationTests.class);
	
	@Test
	public void contextLoads() {
		
		LOGGER.info("Test Started");
		assertEquals(true,true);
	}

}
