package org.example.lesson13;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;

import javax.inject.Named;

//@Component
@Named // Java EE Specs
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CollaborativeFilter implements Filter {
    @Override
    public String[] getRecommendations(String movie) {
        return new String[]{"Finding Dory", "Ice Age"};
    }
}
