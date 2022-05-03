package Interfaces;

import java.util.HashMap;
import java.util.Map;

import static base.BaseTest.idThread;

public interface SaveData {
    Map<Long,HashMap<String,String>> save = new HashMap<>(new HashMap<>());
    static void save(Long aLong, String key, String value) {
        save.put(idThread.get(), new HashMap<>((Map.of(key,value))));
    }
    default String getValue(String key) {
        Map<String,String> map = save.get(idThread.get());
        return map.getOrDefault(key,"");
    }
}
