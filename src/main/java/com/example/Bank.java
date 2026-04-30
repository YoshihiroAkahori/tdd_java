package com.example;

import java.util.Map;
import java.util.HashMap;

class Bank {
    // HashMapとしてratesを保持できるように、空のHashMapを宣言
    private Map<Pair, Integer> rates = new HashMap<>();
    Money reduce(Expression source, String to) {
        return source.reduce(this, to);
    }
    // Bankオブジェクトにrateを注入するメソッド
    void addRate(String from, String to, int rate) {
        rates.put(new Pair(from, to), rate); // Pairをキーとしてrateを持つobjectを定義
    }
    // rateを聞かれたらratesから対応するrateを取り出すメソッド
    int rate(String from, String to) {
        if (from.equals(to)) return 1; // 同一通貨の場合はrate 1
        return rates.get(new Pair(from, to));
    }
}