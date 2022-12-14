package com.hui.utils;
import org.springframework.cglib.beans.BeanMap;
import java.util.HashMap;
import java.util.Map;
/* Bean转为Map */
public class BeanMapUtils {
    public static <T> Map<String, Object> beanToMap(T bean) {
        Map<String, Object> map = new HashMap();
        if (bean != null) {
            BeanMap beanMap = BeanMap.create(bean);
            for (Object key : beanMap.keySet()) {
                map.put(key+"", beanMap.get(key));
            }
        }
        return map;
    }
    //处理更新---多加的update
    public static <T> Map<String, Object> beanToMapForUpdate(T bean) {
        Map<String, Object> map = new HashMap();
        if (bean != null) {
            BeanMap beanMap = BeanMap.create(bean);
            for (Object key : beanMap.keySet()) {
                map.put("update"+upperFirstLatter(key+""),beanMap.get(key));
            }
        }
        return map;
    }
    //大小写转换
    public static String upperFirstLatter(String letter){
        char[] chars = letter.toCharArray();
        if(chars[0]>='a' && chars[0]<='z'){
            chars[0] = (char) (chars[0]-32);
        }
        return new String(chars);
    }
}
