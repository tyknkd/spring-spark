package com.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.broadcast.Broadcast;

public class SparkBroadcast {
    public static class SomeClass implements Serializable {
        private final int[] a;
        private final int b;
        public SomeClass(int[] a, int b) {
            this.a = a;
            this.b = b;
        }
        public int[] getA() {
            return a;
        }
        public int getB() {
            return b;
        }
    }

    public static List<Integer> javaBroadcast() {
        List<Integer> result = new ArrayList<>();
        try (JavaSparkContext sparkContext = new JavaSparkContext("local", "JavaBroadcast")) {
            Broadcast<SomeClass> broadcastVariable = sparkContext.broadcast(new SomeClass(new int[]{5, 6}, 3));
            JavaRDD<Integer> rdd = sparkContext.parallelize(List.of(1, 2, 3, 4, 5));
            List<Integer> resultList = rdd.map(i -> i + broadcastVariable.value().getA()[0]).collect();
            result.addAll(resultList);
            System.out.println(result);
        }
        return result;
    }
}