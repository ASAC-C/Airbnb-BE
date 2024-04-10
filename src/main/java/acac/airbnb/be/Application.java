package acac.airbnb.be;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication //스프링 부트 애플리케이션을 구성하는 데 사용됩니다.
@EnableJpaAuditing //JPA Auditing 기능을 활성화합니다.
@ServletComponentScan //서블릿 관련 컴포넌트를 자동으로 스캔하여 등록합니다.
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
