package recipebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RecipeBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeBookApplication.class, args);
	}

//	private final Producer producer;
//
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
//						this.producer.sendMessage("1", "I love this recipe!");
//						this.producer.sendMessage("2", "There is a typo in the recipe name.");
//						this.producer.sendMessage("3", "Mmmmmmm banana bread");
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
