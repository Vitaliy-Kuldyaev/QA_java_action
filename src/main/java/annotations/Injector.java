package annotations;

import Interfaces.ProjectConfig;
import com.google.common.collect.ImmutableCollection;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class Injector {
    public static void inject(Object inst) {
        Class<?>[] interfaces = inst.getClass().getInterfaces();


       // Field[] fields = inst.getClass().getInterfaces().getDeclaredFields();

        int sdf=0;
    }
}
