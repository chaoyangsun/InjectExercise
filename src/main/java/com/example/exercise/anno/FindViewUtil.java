package com.example.exercise.anno;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;

public class FindViewUtil {
    public static void injectView(Activity activity) {
        Class<? extends Activity> aClass = activity.getClass();
        Field[] fields = aClass.getDeclaredFields();
        if (fields == null || fields.length == 0){
            return;
        }
        for (Field field : fields){
            if (field.isAnnotationPresent(FindView.class)){
                FindView inject = field.getAnnotation(FindView.class);
                int id = inject.value();
                View viewById = activity.findViewById(id);
                field.setAccessible(true);
                try {
                    field.set(activity, viewById);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
