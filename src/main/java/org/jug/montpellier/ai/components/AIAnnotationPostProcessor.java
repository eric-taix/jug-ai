package org.jug.montpellier.ai.components;

import ai.api.model.AIResponse;
import ai.api.model.Fulfillment;
import org.jug.montpellier.ai.annotations.AIAction;
import org.jug.montpellier.ai.annotations.AIController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class AIAnnotationPostProcessor implements BeanPostProcessor {

    private static final Logger LOG = LoggerFactory.getLogger(AIAnnotationPostProcessor.class);
    private final AIRouter router;

    public AIAnnotationPostProcessor(AIRouter router) {
        this.router = router;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return scan(bean);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    protected Object scan(Object bean) {
        if (bean.getClass().isAnnotationPresent(AIController.class)) {
            String baseAction = "";
            if (bean.getClass().isAnnotationPresent(AIAction.class)) {
                AIAction aiAction = bean.getClass().getAnnotation(AIAction.class);
                baseAction = aiAction.value();
            }
            LOG.info("Found AI controller '{}' with base action '{}'", bean.getClass(), baseAction);
            scanActions(bean, baseAction);
        }
        return bean;
    }

    protected void scanActions(Object bean, String baseAction) {
        for (Method method : bean.getClass().getMethods()) {
            if (method.isAnnotationPresent(AIAction.class)) {
                if (method.getParameterCount() == 1 && method.getParameterTypes()[0].equals(AIResponse.class) && method.getReturnType().equals(Fulfillment.class)) {
                    String action = baseAction + "." + method.getAnnotation(AIAction.class).value();
                    LOG.info("Registering AI action '{}' on method '{}'", action, bean.getClass().getSimpleName() + "#" + method.getName());
                    router.register(action, new AIRoute(bean, method));
                }
            }
        }
    }

}
