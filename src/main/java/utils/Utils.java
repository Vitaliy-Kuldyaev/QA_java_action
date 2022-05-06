package utils;


import base.BaseTest;
import io.qameta.allure.Step;
import stands.Stands;
import utils.saveData.SaveDataInThread;

import java.util.List;
import java.util.Map;

public class Utils extends BaseTest {
    public static void execQuery(String query, Object... params) {
        DB.connect(Stands.getActiveStand()).setAutoCommit(true);
        DB.exec(query, params);
        DB.disconnect();
    }

    public static List<Map> doSelect(String query) {
        DB.connect(Stands.getActiveStand()).setAutoCommit(true);
        List<Map> result = DB.findAll(query);
        DB.disconnect();
        return result;
    }

    @Step("Получение промежуточных данных по ключу \"{key}\"")
    public static String getSave(String key) {
        return SaveDataInThread.getSaveValue(key);
    }
}
