Note to remember :

1. @Cacheable(value = "ticketsCache", key = "#ticketId", unless="#result==null")
	- This is used for caching data into memory based on the key
	-Sometime if caching data is null then also it will maintain the cache. To avoid this problem
	 we will use 'unless' condition i.e here if result is null then it avoids the caching data.


2. @CacheEvict(value = "ticketsCache", key = "#ticketId")
	- This is used for deleting the cache from the memory based on the key


3. @CachePut(value = "ticketsCache", key = "#ticketId")
	- Update the cache based on the key. Make sure that method should return proper
	  value because this value only updated in the cache based on key
	 
	 
4. we can use simple cache configuration in two ways in Spring boot  
    
    i. We can declare a bean in main as given below
			@Bean
			public CacheManager cacheManager() {
				GuavaCacheManager guavaCacheManager = new GuavaCacheManager();
				guavaCacheManager.setCacheBuilder(CacheBuilder.newBuilder().expireAfterWrite(24, TimeUnit.HOURS));
				return new ConcurrentMapCacheManager("ticketsCache");
			}
	ii. Or We can declare the below properties in property file
	    	spring.cache.cache-names=ticketsCache
			spring.cache.guava.spec=maximumSize=500,expireAfterAccess=600s
			spring.cache.type=guava
			
			
5. Dependencies needed
 		
 		<!-- Spring boot cache dependency -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-cache</artifactId>
		</dependency>


		<!-- https://mvnrepository.com/artifact/com.google.guava/guava -->
		<dependency>
			<groupId>com.google.guava</groupId>
			<artifactId>guava</artifactId>
			<version>19.0</version>
		</dependency>
 
	  
	  
	  
