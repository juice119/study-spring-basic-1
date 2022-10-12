package dependencyInjection;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;


public class MainTest {
    @Test
    void autoDependencyInjection() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestAutoAppConfig.class);

        ConstructorDependencyInjection constructorDependencyInjection = ac.getBean(ConstructorDependencyInjection.class);
        assertThat(constructorDependencyInjection.testData).isInstanceOf(TestData.class);
    }
}
