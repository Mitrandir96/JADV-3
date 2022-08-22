package ru.netology;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    static final int Length_3 = 3;
    static final int Length_4 = 4;
    static final int Length_5 = 5;

    static AtomicInteger count3 = new AtomicInteger();
    static AtomicInteger count4 = new AtomicInteger();
    static AtomicInteger count5 = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {



        Random random = new Random();
        String[] texts = new String[100_000];
        for (int i = 0; i < texts.length; i++) {
            texts[i] = generateText("abc", 3 + random.nextInt(3));
        }

        Runnable logic1 = () -> {
            for (String text : texts) {
                if (text.length() == Length_3) {
                    if (text.equals(new StringBuilder(text).reverse().toString())) {
                        count3.incrementAndGet();
                    }
                }
                if (text.length() == Length_4) {
                    if (text.equals(new StringBuilder(text).reverse().toString())) {
                        count4.incrementAndGet();
                    }
                }
                if (text.length() == Length_5) {
                    if (text.equals(new StringBuilder(text).reverse().toString())) {
                        count5.incrementAndGet();
                    }
                }
            }
        };

        Runnable logic2 = () -> {
            for (String text : texts) {
                if (text.length() == Length_3) {
                    boolean str = true;
                    for (int i = 1; i < text.length(); i++) {
                        if (text.charAt(i - 1) != text.charAt(i)) {
                            str = false;
                            break;
                        }
                    }
                    if (str) {
                        count3.incrementAndGet();
                    }
                }
                if (text.length() == Length_4) {
                    boolean str = true;
                    for (int i = 1; i < text.length(); i++) {
                        if (text.charAt(i - 1) != text.charAt(i)) {
                            str = false;
                            break;
                        }
                    }
                    if (str) {
                        count4.incrementAndGet();
                    }
                }
                if (text.length() == Length_5) {
                    boolean str = true;
                    for (int i = 1; i < text.length(); i++) {
                        if (text.charAt(i - 1) != text.charAt(i)) {
                            str = false;
                            break;
                        }
                    }
                    if (str) {
                        count5.incrementAndGet();
                    }
                }
            }
        };

        Runnable logic3 = () -> {
            for (String text : texts) {
                if (text.length() == Length_3) {
                    boolean str = true;
                    for (int i = 1; i < text.length(); i++) {
                        if (text.charAt(i - 1) > text.charAt(i)) {
                            str = false;
                            break;
                        }
                    }
                    if (str) {
                        count3.incrementAndGet();
                    }
                }
                if (text.length() == Length_4) {
                    boolean str = true;
                    for (int i = 1; i < text.length(); i++) {
                        if (text.charAt(i - 1) > text.charAt(i)) {
                            str = false;
                            break;
                        }
                    }
                    if (str) {
                        count4.incrementAndGet();
                    }
                }
                if (text.length() == Length_5) {
                    boolean str = true;
                    for (int i = 1; i < text.length(); i++) {
                        if (text.charAt(i - 1) > text.charAt(i)) {
                            str = false;
                            break;
                        }
                    }
                    if (str) {
                        count5.incrementAndGet();
                    }
                }
            }
        };

        Thread thread1 = new Thread(logic1);
        Thread thread2 = new Thread(logic2);
        Thread thread3 = new Thread(logic3);

        List<Thread> threads = new ArrayList<>();

        thread1.start();
        thread2.start();
        thread3.start();

        threads.add(thread1);
        threads.add(thread2);
        threads.add(thread3);

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Красивых слов с длиной 3: " + count3);
        System.out.println("Красивых слов с длиной 4: " + count4);
        System.out.println("Красивых слов с длиной 5: " + count5);


    }

    public static String generateText(String letters, int length) {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(letters.charAt(random.nextInt(letters.length())));
        }
        return text.toString();
    }
}