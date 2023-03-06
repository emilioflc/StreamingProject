package com.eflores.StreamingPlatform;

// import java.time.LocalDate;

// import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.Bean;

// import com.eflores.StreamingPlatform.model.Usuario;
// import com.eflores.StreamingPlatform.repo.UsuarioRepo;

@SpringBootApplication
public class StreamingPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(StreamingPlatformApplication.class, args);
	}

	// @Bean
	// CommandLineRunner run(UsuarioRepo usuarioRepo){
	// 	return args -> {
	// 		usuarioRepo.save(new Usuario(null, "Emilio", "Flores", LocalDate.of(24, 1, 2003), 
	// 		"emilioandres003@gmail.com", "test", null, null, null,
	// 		null, null, null, null));
	// 	};
	// }

}
