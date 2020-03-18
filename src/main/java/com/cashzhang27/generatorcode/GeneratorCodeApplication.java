package com.cashzhang27.generatorcode;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is the generator code startup class.
 *
 * @author Cash Zhang
 * @version v1.0
 * @since 2020/03/18 21:47
 */
@EnableSwagger2Doc
@SpringBootApplication
public class GeneratorCodeApplication {

  /**
   * main function.
   *
   * @param args args
   */
  public static void main(String[] args) {
    SpringApplication.run(GeneratorCodeApplication.class);
  }
}
