package db.table;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class DB extends DataSupport {
    public static <T> T find(Class<T> modelClass, String... strings) {
        T t = null;
        if (strings.length == 0)
            t = DataSupport.findFirst(modelClass);
        else
            t = DataSupport.where(strings).find(modelClass).size() > 0 ? DataSupport.where(strings).find(modelClass).get(0) : null;

        return t;
    }

    public static <T> List<T> finds(Class<T> modelClass, String... strings) {
        List<T> list = new ArrayList<T>();
        if (strings.length == 0)
            list = DataSupport.findAll(modelClass);
        else if (strings.length >= 2)
            list = DataSupport.where(strings).find(modelClass);

        return list;
    }
}
