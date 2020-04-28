package com.example.exercise.anno;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import java.lang.reflect.Field;

public class AutowiredUtils2 {
    public static void inject(Activity activity) {
        Class<? extends Activity> aClass = activity.getClass();
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields){
            if (field.isAnnotationPresent(Autowired.class)){
                Autowired autowired = field.getAnnotation(Autowired.class);
                String element = autowired.value();
                Intent intent = activity.getIntent();
                if (intent == null){
                    return;
                }
                if (TextUtils.isEmpty(element)){
                    element = field.getName();
                }
                Bundle bundle = intent.getExtras();
                Object value = bundle.get(element);
                setFieldValue(activity, field, value);
            }
        }
    }

    private static void setFieldValue(Activity activity, Field field, Object stringExtra) {
        field.setAccessible(true);
        try {
            field.set(activity, stringExtra);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
