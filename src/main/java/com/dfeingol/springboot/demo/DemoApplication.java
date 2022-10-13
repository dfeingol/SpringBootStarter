package com.dfeingol.springboot.demo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// cool feature testit ou
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  // in this method you can put any pre-inialization
  @Override
  public void run(String... arg0) throws Exception {
    logger.info("Startup -> {}");
  }
}
