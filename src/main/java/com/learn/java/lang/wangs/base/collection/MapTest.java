package com.learn.java.lang.wangs.base.collection;

import java.util.HashMap;

public class MapTest {

    static class MapNode{
        Integer value;
        MapNode next;

        public final Integer setValue(Integer newValue) {
            Integer oldValue = value;
            value = newValue;
            return oldValue;
        }

        public static void main(String[] args) {
            HashMap<String, String> map = new HashMap<>(16);
//            for (int i = 1; i < 100000; i++) {
//                map.put(String.valueOf(i), String.valueOf(i));
//            }

            // 容量为16的 然后slot等于1的数字 就是 table[1] 的链表桶
            //  1  12  23  34  45  56  67  78  89  100  111  122
//            for (int i = 1; i < 15; i++) {
//                map.put(String.valueOf(i), String.valueOf(i));
//            }
            for (int i = 0; i < 13; i++) {
                int key = i * 11 + 1;
                map.put(String.valueOf(key), String.valueOf(i));
            }

            //init();
        }

        public static void init(){
            MapNode node1 = new MapNode();
            MapNode node121 = new MapNode();
            MapNode node242 = new MapNode();
            MapNode node363 = new MapNode();
            node1.value = 1;
            node1.next = node121;

            node121.value = 121;
            node121.next = node242;

            node242.value = 242;
            node242.next = node363;

            node363.value = 363;
            node363.next = null;


            MapNode e = node1;

            MapNode loHead = null, loTail = null;
            MapNode hiHead = null, hiTail = null;
            MapNode next;

            do {
                next = e.next;
                if (e.value != 121) {
                    if (loTail == null)
                        loHead = e;
                    else
                        loTail.next = e;
                    loTail = e;
                }
                else {
                    if (hiTail == null)
                        hiHead = e;
                    else
                        hiTail.next = e;
                    hiTail = e;
                }
            } while ((e = next) != null);

            if (loTail != null) {
                loTail.next = null;
                //newTab[j] = loHead;
            }
            if (hiTail != null) {
                hiTail.next = null;
                //newTab[j + oldCap] = hiHead;
            }
        }
    }
}
