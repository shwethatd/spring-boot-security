package com.training.sample;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.BasicAuthentication;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootSecurityApplicationTests {

	@Test
	public void contextLoads() {
	}
	@Test
	public void authTest() {
		ResteasyClientBuilder clientBuilder = new ResteasyClientBuilder();
		
		clientBuilder.register( new BasicAuthentication( "shwetha", "shwetha123") );
		ResteasyClient client = clientBuilder.build();
		
		ResteasyWebTarget target = client
				.target("http://localhost:8080/hello/world");
		target.request().acceptEncoding("application/json");
		
		
		String inmessage="{ }";
		Response response = target.request().post(
				Entity.entity(inmessage,"application/json"));
		String message = response.readEntity(String.class);
		System.out.println("here : "+message);
	}
}
