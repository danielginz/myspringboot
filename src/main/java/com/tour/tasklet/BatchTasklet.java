package com.tour.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tour.service.UserService;

@Service
public class BatchTasklet implements Tasklet {

	@Autowired 
	private UserService userService;
	
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext context) throws Exception {
		System.out.println(context.getStepContext().getJobParameters().get("jobName").toString());
		userService.userList();
		Thread.sleep(1000);
		return RepeatStatus.FINISHED;
	}

}
