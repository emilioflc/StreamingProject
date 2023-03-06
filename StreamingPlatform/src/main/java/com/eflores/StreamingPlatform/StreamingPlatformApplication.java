package com.eflores.StreamingPlatform;

// import java.time.LocalDate;
// import java.time.LocalDateTime;
import java.util.Arrays;

// import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

// import com.eflores.StreamingPlatform.model.Usuario;
// import com.eflores.StreamingPlatform.repo.UsuarioRepo;

@SpringBootApplication
public class StreamingPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(StreamingPlatformApplication.class, args);
	}

	// @Bean
	// CommandLineRunner run(UsuarioRepo usuarioRepo) {
	// 	return args -> {
	// 		usuarioRepo.save(new Usuario((Long) null, "Emilio", "Flores", LocalDate.of(2003,1,24),
	// 				"emilioandres003@gmail.com", "test", (Long) null, "path/to/pp", LocalDateTime.now(),
	// 				"emilioandres003@gmail.com", LocalDateTime.now(), "emilioandres003@gmail.com",
	// 				LocalDateTime.now()));
	// 	};
	// }

	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000", "http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Jwt-Token", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration
				.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Jwt-Token", "Authorization",
						"Access-Control-Allow-Origin", "Access-Control-Allow-Origin",
						"Access-Control-Allow-Credentials", "Filename"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}

}
