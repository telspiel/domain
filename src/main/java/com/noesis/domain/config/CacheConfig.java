package com.noesis.domain.config;

import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.noesis.domain.persistence.NgMisMessage;

import redis.clients.jedis.JedisPoolConfig;


@Configuration
@EnableCaching
public class CacheConfig extends CachingConfigurerSupport {

	//private static final Logger logger = LogManager.getLogger(CacheConfig.class);
	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Value("${spring.redis.host}")
	private String redisHost;

	@Value("${spring.redis.port}")
	private String redisPort;
	
	@Value("${spring.redis.password}")
	private String redisPassword;

	@Value("${spring.redis.max.total.con}")
	private String redisMaxTotalConnection;

	@Value("${spring.redis.min.idle.con}")
	private String redisMinIdleCon;
	
	@Value("${spring.redis.max.idle.con}")
	private String redisMaxIdleCon;

	/*@Value("${spring.redis.database.index}")
	private String redisDatabaseIndex;*/

	@Bean 
	@Primary
	public JedisConnectionFactory redisConnectionFactory() {
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxTotal(Integer.parseInt(redisMaxTotalConnection));
		poolConfig.setMinIdle(Integer.parseInt(redisMinIdleCon));
		poolConfig.setMaxIdle(Integer.parseInt(redisMaxIdleCon));
		
		JedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory(poolConfig);
		redisConnectionFactory.setHostName(redisHost);
		redisConnectionFactory.setPort(Integer.parseInt(redisPort));
		redisConnectionFactory.setPassword(redisPassword);
		redisConnectionFactory.setPassword("1nAw5@aam"); // //checking for new development
		//redisConnectionFactory.setDatabase(Integer.parseInt(redisDatabaseIndex));
		return redisConnectionFactory;
	}
// start cache for black list
//	 @Bean
//	    public RedisTemplate<String, Set<String>> redisTemplateForUserBlackList(RedisConnectionFactory cf) {
//	        RedisTemplate<String, Set<String>> redisTemplateForUserBlackList = new RedisTemplate<>();
//	        redisTemplateForUserBlackList.setConnectionFactory(cf);
//	        redisTemplateForUserBlackList.setKeySerializer(new StringRedisSerializer());
//	        redisTemplateForUserBlackList.setValueSerializer(new GenericJackson2JsonRedisSerializer());
//	        return redisTemplateForUserBlackList;
//	    }
//	// end
	@Bean
	@Primary
	public Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer() {
		final Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(
				Object.class);
		final ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json().build();
		objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
		return jackson2JsonRedisSerializer;
	}
//
//	@Bean
//    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
//        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(connectionFactory);
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
//        return redisTemplate;
//    }
	//
	@Bean
	public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory cf) {
		RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
		redisTemplate.setConnectionFactory(cf);
		 //redisTemplate.setKeySerializer(new StringRedisSerializer());
		 // new
		// redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		 // new end
		// redisTemplate.setValueSerializer(jackson2JsonRedisSerializer());
		// redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		// redisTemplate.setEnableDefaultSerializer(false);
		// redisTemplate.setDefaultSerializer(new StringRedisSerializer());
		// redisTemplate.setHashValueSerializer(new HashValueRedisObjectSerializer());
		return redisTemplate;
	}

	@Bean
	public RedisTemplate<String, String> redisTemplateForPlatformErrorCodesAndDesc(RedisConnectionFactory cf) {
		RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
		redisTemplate.setConnectionFactory(cf);
		// redisTemplate.setKeySerializer(new StringRedisSerializer());
		// redisTemplate.setValueSerializer(jackson2JsonRedisSerializer());
		// redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		// redisTemplate.setEnableDefaultSerializer(false);
		// redisTemplate.setDefaultSerializer(new StringRedisSerializer());
		// redisTemplate.setHashValueSerializer(new HashValueRedisObjectSerializer());
		return redisTemplate;
	}
	
	
	 @Bean(name = "redisUserTemplate")
	    public RedisTemplate<String, String> redisTemplateUser(RedisConnectionFactory connectionFactory) {
	        RedisTemplate<String, String> template = new RedisTemplate<>();
	        template.setConnectionFactory(connectionFactory);
	        template.setDefaultSerializer(new GenericJackson2JsonRedisSerializer());
	        template.setKeySerializer(new StringRedisSerializer());
	        template.setHashKeySerializer(new GenericJackson2JsonRedisSerializer());
	        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
	        return template;
	    }
	 
	@Bean
	public CacheManager cacheManager(RedisTemplate redisTemplate) {
		RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
		cacheManager.setDefaultExpiration(300);
		HashMap<String, Long> expires = new HashMap<>();
		expires.put("DELIVERED_DLR_MESSAGE_PART_COUNT_MAP", new Long(1000));
		expires.put("FAILED_DLR_MESSAGE_PART_COUNT_MAP", new Long(1000));
		cacheManager.setExpires(expires);
		cacheManager.setUsePrefix(true);

		return cacheManager;
	}

	@Bean
	public KeyGenerator customKeyGenerator() {
		return new KeyGenerator() {
			@Override
			public Object generate(Object o, Method method, Object... objects) {
				StringBuilder sb = new StringBuilder();
				sb.append(o.getClass().getName());
				sb.append(method.getName());
				for (Object obj : objects) {
					sb.append(obj.getClass().getName());
				}
				logger.info("Final Key is: " + sb.toString());
				return sb.toString();
			}
		};
	}

	@Bean
	@Autowired
	public RedisTemplate<String, Set<String>> redisTemplateList(final JedisConnectionFactory connectionFactory) {
		final RedisTemplate<String, Set<String>> template = new RedisTemplate<String, Set<String>>();
		template.setConnectionFactory(connectionFactory);
		return template;
	}
	
	@Bean
	@Autowired
	public RedisTemplate<String, HashMap<String, String>> redisTemplateMap(final JedisConnectionFactory connectionFactory) {
		final RedisTemplate<String, HashMap<String, String>> template = new RedisTemplate<String, HashMap<String, String>>();
		template.setConnectionFactory(connectionFactory);
		return template;
	}
	
	@Bean
	@Autowired
	public RedisTemplate<String, String[]> redisTemplateArray(final JedisConnectionFactory connectionFactory) {
		final RedisTemplate<String, String[]> template = new RedisTemplate<String, String[]>();
		template.setConnectionFactory(connectionFactory);
		return template;
	}
	
	@Bean
	@Autowired
	public RedisTemplate<String, NgMisMessage> redisTemplateForMis(final JedisConnectionFactory connectionFactory) {
		final RedisTemplate<String, NgMisMessage> template = new RedisTemplate<String, NgMisMessage>();
		template.setConnectionFactory(connectionFactory);
		return template;
	}
	
	@Bean
	@Autowired
	@Primary
	public RedisTemplate<String, Integer> redisTemplateForCreditMap(final JedisConnectionFactory connectionFactory) {
		final RedisTemplate<String, Integer> template = new RedisTemplate<String, Integer>();
		template.setConnectionFactory(connectionFactory);
		return template;
	}
	
	@Bean(name = "redisTemplateForSummaryManager")
	@Autowired
	public RedisTemplate<String, Integer> redisTemplateForSummaryManager(final JedisConnectionFactory connectionFactory) {
		final RedisTemplate<String, Integer> temp = new RedisTemplate<String, Integer>();
		temp.setKeySerializer(new StringRedisSerializer());
		temp.setValueSerializer(new StringRedisSerializer());
		// add this
		temp.setHashKeySerializer(new StringRedisSerializer(Charset.forName("UTF-8")));
		temp.setHashValueSerializer(new StringRedisSerializer(Charset.forName("UTF-8")));
		temp.setConnectionFactory(connectionFactory);
		return temp;
	}
	
	@Bean
	@Autowired
	public RedisTemplate<String, String> newRedisTemplateForCreditMap(final JedisConnectionFactory connectionFactory) {
		RedisTemplate<String, String> temp = new RedisTemplate<String, String>();
		temp.setConnectionFactory(connectionFactory);
		temp.setKeySerializer(new StringRedisSerializer());
		temp.setValueSerializer(new StringRedisSerializer());
		// add this
		temp.setHashKeySerializer(new StringRedisSerializer(Charset.forName("UTF-8")));
		temp.setHashValueSerializer(new StringRedisSerializer(Charset.forName("UTF-8")));
		temp.afterPropertiesSet();
		return temp;
	}
	
	@Bean
	@Autowired
	public RedisTemplate<String, Map<String,String>> redisTemplateForShortUrlMap(final JedisConnectionFactory connectionFactory) {
		final RedisTemplate<String, Map<String,String>> template = new RedisTemplate<String, Map<String,String>>();
		template.setConnectionFactory(connectionFactory);
		return template;
	}
	
	@Bean
	StringRedisTemplate template(RedisConnectionFactory connectionFactory) {
		return new StringRedisTemplate(connectionFactory);
	}
}
