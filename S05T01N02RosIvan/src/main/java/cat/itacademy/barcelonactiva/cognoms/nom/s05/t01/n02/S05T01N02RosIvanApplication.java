package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(title = "API Flowers", version = "1.0.0"),
		servers = {@Server(url = "http://localhost:9001")},
		tags = {@Tag(name = "Flower API", description = "This is an API CRUD to Manage Flowers in MySQL")}

)

public class S05T01N02RosIvanApplication {
		@Bean
		public ModelMapper modelMapper() {
			return new ModelMapper();
		}

	public static void main(String[] args) {
		SpringApplication.run(S05T01N02RosIvanApplication.class, args);
	}

}
