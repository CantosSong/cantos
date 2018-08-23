package top.cantos.config;

import java.net.UnknownHostException;
import java.util.Properties;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.github.pagehelper.PageInterceptor;

/**
 * 项目配置
 *
 * @author Cantos Song
 */
@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class WebConfig {

	@Bean
	@ConditionalOnExpression("'${spring.profiles.active}'=='local'")
	public CorsFilter corsFilter() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		final CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.setMaxAge(18000L);
		config.addAllowedMethod("*");
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}

	@Bean
	@ConditionalOnMissingBean(name = "redisTemplate")
	public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory)
			throws UnknownHostException {
		RedisTemplate<Object, Object> template = new RedisTemplate<Object, Object>();
		template.setConnectionFactory(redisConnectionFactory);
		RedisSerializer<String> stringSerializer = new StringRedisSerializer();
		template.setKeySerializer(stringSerializer);
		template.setValueSerializer(stringSerializer);
		template.setHashKeySerializer(stringSerializer);
		template.setHashValueSerializer(stringSerializer);
		return template;
	}

	/**
	 * 分页插件配置
	 *
	 * @return
	 */
	@Bean
	public PageInterceptor pageInterceptor() {
		PageInterceptor interceptor = new PageInterceptor();
		Properties properties = new Properties();
		properties.put("helperDialect", "mysql");
		properties.put("reasonable", "true");
		properties.put("supportMethodsArguments", "true");
		properties.put("params", "count=countSql");
		interceptor.setProperties(properties);
		return interceptor;
	}

}
