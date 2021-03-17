import javafx.application.Application;
import org.cfuentes.scrumapp.service.api.EquipoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ScrumAppStarter.class)
public class JsfTest {
    @Autowired
    EquipoService equipoService;

    @Test
    public void testing(){
        equipoService.findById(new Long(0));
    }
}
