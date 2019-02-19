package kr.re.kiro;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import kr.re.kiro.config.Properties;

/**
 * <pre>
 * kr.re.kiro
 * KiroDevApplication.java
 * </pre>
 *
 * @Author : Kim sungkeun
 * @Date   : 2019. 2. 18.
 * @Version: 
 */
@SpringBootApplication
@EnableAutoConfiguration
public class KiroDevApplication {

	private static final Logger logger = LoggerFactory.getLogger(KiroDevApplication.class);

	@Value("${file.rootdir}")
	private String fileRootDir;

	@Value("${file.per.directory}")
	private String filePerDirectory;
	
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(KiroDevApplication.class, args);
		Server server = context.getBean(Server.class);
		server.init();
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		logger.debug("Welcome Start KIRO-WEB ");
		return "index";
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public CommandLineRunner runner() {
		return (a) -> {
			Properties.FILE_ROOTDIR = fileRootDir;
			Properties.FILE_PER_DIRECTORY = filePerDirectory;
		};
	}
	
	@Bean
	Server server() {
		return new Server();
	}

	private static class Server {
		@PostConstruct
		public void start() {
//				System.out.println("");
//				System.out.println("");
//				System.out.println("====================================");
//				System.out.println(" :: WEB Service :: (v1.0.0.RELEASE)");
//				System.out.println("====================================");
//				System.out.println("");
//				System.out.println("");
		}

		public void init() {
			logger.info("======================================");
			logger.info("");
			logger.info("KIRO WEB Service v1.0.0 START !!");
			logger.info("");
			logger.info("======================================");
		}

		@PreDestroy
		public void stop() {
			logger.info("======================================");
			logger.info("");
			logger.info("KIRO WEB Service v1.0.0 STOP !!");
			logger.info("");
			logger.info("======================================");
		}
	}
}