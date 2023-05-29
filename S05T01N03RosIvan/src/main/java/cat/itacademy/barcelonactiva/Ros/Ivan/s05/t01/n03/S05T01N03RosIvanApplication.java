package cat.itacademy.barcelonactiva.Ros.Ivan.s05.t01.n03;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(title = "API Flowers2 Call to API Flowers", version = "1.0.0"),
		servers = {@Server(url = "http://localhost:9002")},
		tags = {@Tag(name = "Flower API To Another API", description = "This is an API CRUD to Manage Flowers to call Another API")}

)
public class S05T01N03RosIvanApplication {


	public static void main(String[] args) {
		SpringApplication.run(S05T01N03RosIvanApplication.class, args);
	}

}
