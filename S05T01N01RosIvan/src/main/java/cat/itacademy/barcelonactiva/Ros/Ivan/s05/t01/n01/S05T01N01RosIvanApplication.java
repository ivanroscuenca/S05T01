package cat.itacademy.barcelonactiva.Ros.Ivan.s05.t01.n01;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class S05T01N01RosIvanApplication {
	//ModelMapper put Bean
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(S05T01N01RosIvanApplication.class, args);
	}

}
