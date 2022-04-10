package com.nq.month2.exer1;

import java.util.*;

/**
 * @Author Nq
 * @Data 2021-02-23-22:15
 */
public class DAO<T> {

    private Map<String,T> map = new HashMap<>();

    /*
    保存 T 类型的对象到 Map 成员变量中
     */
    public void save(String id,T entity){
        map.put(id, entity);
    }

    /*
    从map中获取id对应的对象
     */
    public T get(String id){
//        T t = map.get(id);
//        return t;
        return map.get(id);
    }

    /*
    替换map中 key 为 id 的内容，改为 entity 对象
     */
    public void update(String id,T entity){
        if(map.containsKey(id)) {
            map.put(id,entity);
        }
    }

    /*
    返回 map 中存放的所有 T 对象
     */
    public List<T> list(){
        List<T> list = new ArrayList<>();
        Collection<T> values = map.values();
        Iterator<T> iterator = values.iterator();
        while (iterator.hasNext()){
            T next = iterator.next();
            list.add(next);
        }
        return list;
//        Collection<T> values = map.values();
//        return new ArrayList<>(values); 2步可以完成
    }

    /*
    删除指定 id 对象
     */
    public void delete(String id){
        map.remove(id);
    }
}
