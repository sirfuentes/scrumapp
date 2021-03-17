import org.cfuentes.scrumapp.service.api.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"org.cfuentes.scrumapp.*"})
@EntityScan(basePackages = {"org.cfuentes.scrumapp.*"})
@EnableJpaRepositories(basePackages = {"org.cfuentes.scrumapp.*"})
public class ScrumAppStarter {
    @Autowired
    private EquipoService equpoService;
    public static void main(String[] args) {
        SpringApplication.run(ScrumAppStarter.class, args);
    }


}
