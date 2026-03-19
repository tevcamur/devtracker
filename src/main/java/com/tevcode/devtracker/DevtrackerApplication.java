package com.tevcode.devtracker;

import com.tevcode.devtracker.model.Priority;
import com.tevcode.devtracker.model.Status;
import com.tevcode.devtracker.model.Task;
import com.tevcode.devtracker.model.TaskType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DevtrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevtrackerApplication.class, args);}
}
