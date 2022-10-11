package hello.core.beanDefinition;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanDefinitionTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 설정 메타 정보 확인")
    void name() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String definitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(definitionName);

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println("beanDefinitionName" + definitionName +
                        " beanDefinition = " + beanDefinition);
            }
        }
    }
}
