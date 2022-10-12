package dependencyInjection;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConstructorDependencyInjection {
    TestData testData;

    @Autowired
    public ConstructorDependencyInjection(TestData testData) {
        this.testData = testData;
    }
}
