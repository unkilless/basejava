package com.base_java.webapp;

import com.base_java.webapp.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Resume r = new Resume("Test", 1);
        Field field = r.getClass().getDeclaredFields()[0];
        field.setAccessible(true);
        for (Field any : r.getClass().getDeclaredFields()) {
            System.out.println(any.getName());
        }
        System.out.println(field.get(r));
        field.set(r, 23);
        Method predatorMethod = Resume.class.getMethod("toString");
        System.out.println(predatorMethod.invoke(r));

        Field[] fields = r.getClass().getDeclaredFields();
        for (Field f: fields){
            f.setAccessible(true);
            System.out.println(f.get(r));
        }
    }

}
