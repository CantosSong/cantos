package top.cantos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;

import top.cantos.utils.SpringUtil;

@SpringBootApplication
@EnableCaching
public class MemberMain {

	public static void main(String[] args) throws Exception {
		SpringApplication springApplication = new SpringApplication(MemberMain.class);
		ConfigurableApplicationContext applicationContext = springApplication.run(args);
		SpringUtil.setContent(applicationContext);
	}

}
