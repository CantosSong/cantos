package top.cantos.autoconfigure.swagger;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ConditionalOnClass(Docket.class)
@ConditionalOnExpression("'${support.swagger2.enabled}'=='true'")
@EnableConfigurationProperties(Swagger2Properties.class)
public class Swagger2AutoConfiguration {
	@Autowired(required = false)
	private List<Parameter> parameterList;

	@Bean
	@ConditionalOnMissingBean(Docket.class)
	public Docket createRestApi(Swagger2Properties properties) {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(properties.build())
				.globalOperationParameters(parameterList).select()
				.apis(RequestHandlerSelectors.basePackage(properties.getBasePackage())).paths(PathSelectors.any())
				.build();
	}

}
