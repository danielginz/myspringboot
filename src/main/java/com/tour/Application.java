package com.tour;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

//@EnableBatchProcessing - this annotation causes exception, it should be removed:
/*
 org.springframework.jdbc.BadSqlGrammarException: PreparedStatementCallback; bad SQL grammar [SELECT JOB_INSTANCE_ID, JOB_NAME
FROM BATCH_JOB_INSTANCE
WHERE JOB_NAME = ?
 and JOB_KEY = ?]] with root cause
 */


@SpringBootApplication
@EnableScheduling
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

//12, 15:00, check why new record with the same is is added and not edited