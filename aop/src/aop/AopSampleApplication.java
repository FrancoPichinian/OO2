package aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AopSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopSampleApplication.class, args);
	}
}
