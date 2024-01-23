package recipebook;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//import recipebook.entity.RecipeComment;
//import recipebook.service.Producer;

@SpringBootApplication
public class RecipeBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeBookApplication.class, args);
	}

//	private final Producer producer;

//	public static void main(String[] args) {
//		SpringApplication application = new SpringApplication(RecipeBookApplication.class);
//		application.setWebApplicationType(WebApplicationType.NONE);
//		application.run(args);
//	}
//
//	@Bean
//	public CommandLineRunner CommandLineRunnerBean() {
//		return (args) -> {
//			for (String arg : args) {
//				switch (arg) {
//					case "--producer":
//						this.producer.sendMessage("1", new RecipeComment());
//						break;
//					default:
//						break;
//				}
//			}
//		};
//	}
//
//	@Autowired
//	RecipeBookApplication(Producer producer) {
//		this.producer = producer;
//	}

}
