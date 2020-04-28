package com.example.exercise.anno;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;

import java.lang.reflect.Field;

public class AutowiredUtils {
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
                String type = field.getGenericType().toString();
                if (("class java.lang.String").equals(type)) {
                    String value = intent.getStringExtra(element);
                    setFieldValue(activity, field, value);
                }
                if ("int".equals(type) || ("class java.lang.Integer").equals(type)) {
                    int value = intent.getIntExtra(element, 0);
                    setFieldValue(activity, field, value);
                }
                if ("double".equals(type) || ("class java.lang.Double").equals(type)) {
                    double value = intent.getDoubleExtra(element, 0);
                    setFieldValue(activity, field, value);
                }
                if ("short".equals(type) || ("class java.lang.Short").equals(type)) {
                    short value =  intent.getShortExtra(element, (short) 0);
                    setFieldValue(activity, field, value);
                }
                if ("long".equals(type) || ("class java.lang.Long").equals(type)) {
                    long value = intent.getLongExtra(element, 0);
                    setFieldValue(activity, field, value);
                }
                if ("float".equals(type) || ("class java.lang.Float").equals(type)) {
                    float value = intent.getFloatExtra(element, 0);
                    setFieldValue(activity, field, value);
                }
                if ("byte".equals(type) || ("class java.lang.Byte").equals(type)) {
                    byte value = intent.getByteExtra(element, (byte) 0);
                    setFieldValue(activity, field, value);
                }
                if ("boolean".equals(type) || ("class java.lang.Boolean").equals(type)) {
                    boolean value = intent.getBooleanExtra(element, false);
                    setFieldValue(activity, field, value);
                }
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
