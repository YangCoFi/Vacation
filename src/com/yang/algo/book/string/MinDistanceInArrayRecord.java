package com.yang.algo.book.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MinDistanceInArrayRecord
 * @Description Use Record to limit the time complexity to O(1) of every search
 * @Author YangC
 * @Date 2019/7/17 10:20
 **/
public class MinDistanceInArrayRecord {
    private HashMap<String, HashMap<String, Integer>> record;

    public MinDistanceInArrayRecord(String[] strs){
        record = new HashMap<String, HashMap<String, Integer>>();
        HashMap<String, Integer> indexMap = new HashMap<>();
        for (int i = 0; i != strs.length; i ++){
            String curStr = strs[i];
            update(indexMap, curStr, i);
            indexMap.put(curStr, i); //value可以重复，key也不能说不允许重复，只是重复了覆盖而已
        }
    }

    private void update(HashMap<String, Integer> indexMap, String curStr, int i) {
        if (!record.containsKey(curStr)){
            record.put(curStr, new HashMap<String, Integer>());
        }
        HashMap<String, Integer> strMap = record.get(curStr);
        for (Map.Entry<String, Integer> lastEntry: strMap.entrySet()){
            String key = lastEntry.getKey();
            int minDistance = lastEntry.getValue();
            if (!key.equals(curStr)){
                HashMap<String, Integer> lastMap = record.get(key);
                int curMin = i - minDistance;
                if (strMap.containsKey(key)){

                }
            }
        }
    }

}
