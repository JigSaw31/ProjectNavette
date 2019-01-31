package com.formation.projetNavette;




import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(Application.class, args);
		
		    TimerTask repeatedTask = new TimerTask() {
		        public void run() {
		            System.out.println("Task performed on " + new Date());
		        }
		    };
		    Timer timer = new Timer("Timer");
		    
		    long delay = 1000L;
		    long period = 1000L * 60L * 60L * 24L;
		    timer.scheduleAtFixedRate(repeatedTask, delay, period);
		}

}



