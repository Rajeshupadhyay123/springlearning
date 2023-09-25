package com.springlearning.rajesh.dependencyinjection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
 * Component scanner, always search in the base package and sub-package, if you wish you
 * call from different package then need to different your package into "scaneBasePackage"
 */

//@SpringBootApplication(
//	scanBasePackages= {
//			"com.springlearning.rajesh.common",
//			"com.springlearning.rajesh.dependencyinjection.rest"
//	}
//)

@SpringBootApplication
public class DependencyinjectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(DependencyinjectionApplication.class, args);
	}

}
