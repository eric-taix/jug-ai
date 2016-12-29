package org.jug.montpellier.ai.components;

import ai.api.model.AIResponse;
import ai.api.model.Fulfillment;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AIRoute {

    private Object bean;
    private Method method;

    public AIRoute(Object bean, Method method) {
        this.bean = bean;
        this.method = method;
    }

    public Fulfillment execute(AIResponse response) throws InvocationTargetException, IllegalAccessException {
        return (Fulfillment) method.invoke(bean, response);
    }
}
