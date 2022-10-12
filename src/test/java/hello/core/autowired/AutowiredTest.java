package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }


    static class TestBean {
        @Autowired(required = false)
        public void setNoBea1(Member noBea1) {
            System.out.println("noBean1 = " + noBea1);
        }


        @Autowired
        public void setNoBean2(@Nullable Member noBea1) {
            System.out.println("noBean2 = " + noBea1);
        }

        @Autowired
        public void setNoBean3(Optional<Member> noBea1) {
            System.out.println("noBean3 = " + noBea1);
        }
    }
}
