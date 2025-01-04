package com.tour.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import com.tour.tasklet.BatchTasklet;

@Component
public class BatchConfiguration {
	private AutowireCapableBeanFactory beanFactory;
	
	@Autowired
	public BatchConfiguration(AutowireCapableBeanFactory beanFactory) {
		this.beanFactory = beanFactory;
	}
	
	 @Bean
	 public Job executeBatchJob(JobRepository jobRepository, Step step) {
	     return new JobBuilder("manualjob", jobRepository)
	           .start(step)
	           .incrementer(new RunIdIncrementer())
	           .build();
	 }
	 
	 @Bean
	 public Step step(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager){
	    return new StepBuilder("step", jobRepository)
	        .tasklet(configTasklet(), platformTransactionManager)
	        //.allowStartIfComplete(true)
	        .build();
	    }
	 
	
	 public BatchTasklet configTasklet() {
		BatchTasklet batchTasklet = new BatchTasklet();
		beanFactory.autowireBean(batchTasklet);
		return batchTasklet;
	 }
}