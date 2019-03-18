package com.saler.saler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.saler.saler.data.sample.SampleData;
import com.saler.saler.deal.repository.DealRepository;

/**
 * Saler application runner
 * @author Diego Andre Poli <diegoandrepoli@gmail.com>
 */
@SpringBootApplication
public class SalerApplication {

	/**
	 * Auto wired - start sample data on intial application
	 * @param deal repository
	 */
	@Autowired
	public SalerApplication(DealRepository dealRepository) {
		SampleData.generate(dealRepository);		
	}

	/**
	 * Main application
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(SalerApplication.class, args);
	}

}
