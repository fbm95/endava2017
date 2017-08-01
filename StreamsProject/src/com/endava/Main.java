package com.endava;

import com.endava.enums.GuitarModel;
import com.endava.enums.GuitarType;
import com.endava.models.Guitar;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Main {

    public static List<Guitar> ex1(){
        Guitar guitar1 = new Guitar();
        guitar1.setName("Fender Mexican");
        guitar1.setModel(GuitarModel.STRATOCASTER);
        guitar1.setType(GuitarType.ELECTRIC);
        guitar1.setPrice(359.99);

        Guitar guitar2 = new Guitar();
        guitar2.setName("Gibson Standard");
        guitar2.setModel(GuitarModel.LES_PAUL);
        guitar2.setType(GuitarType.ELECTRIC);
        guitar2.setPrice(429.99);

        Guitar guitar3 = new Guitar();
        guitar3.setName("Fender Deluxe");
        guitar3.setModel(GuitarModel.WESTERN);
        guitar3.setType(GuitarType.ACOUSTIC);
        guitar3.setPrice(139.99);

        Guitar guitar4 = new Guitar();
        guitar4.setName("Ibanez Custom");
        guitar4.setModel(GuitarModel.SG);
        guitar4.setType(GuitarType.ELECTRIC);
        guitar4.setPrice(229.99);

        List<Guitar> guitars = new ArrayList<>();
        guitars.add(guitar1);
        guitars.add(guitar2);
        guitars.add(guitar3);
        guitars.add(guitar4);

        return  guitars;
    }

    public static void ex2(List<Guitar> guitars){
        System.out.println("--- Stream of electric guitars ---");
        guitars.stream()
                .filter(guitar -> guitar.getType() == GuitarType.ELECTRIC)
                .map(Guitar::toString)
                .forEach(System.out::println);
    }

    public static void ex3(List<Guitar> guitars) {
        System.out.println("--- Stream of guitar prices ---");
        //DoubleStream doubleStream = DoubleStream.of(guitars.get(0).getPrice(), guitars.get(1).getPrice(), guitars.get(2).getPrice(), guitars.get(3).getPrice());
        DoubleStream doubleStream = guitars.stream().mapToDouble(Guitar::getPrice);
        doubleStream.forEach(System.out::println);
    }

    public static void ex4(List<Guitar> guitars){
        System.out.println("--- List of cheap guitars ---");
        List<Guitar> cheapGuitars = guitars
                .stream()
                .filter(guitar -> guitar.getPrice()<250)
                .collect(Collectors.toList());
        System.out.println(cheapGuitars);
    }

    public static void ex4_1(List<Guitar> guitars) {
        System.out.println("--- List of most expensive guitars ---");
        Collector<Guitar, StringJoiner, String> guitarCollector = Collector.of(
                () -> new StringJoiner(" - "), // supplier
                (j, g) -> j.add(g.getName().toLowerCase()), // accumulator
                (j1, j2) -> j1.merge(j2), // combiner
                StringJoiner::toString); // finisher

        String names = guitars.stream().filter(guitar -> guitar.getPrice()>250).collect(guitarCollector);
        System.out.println(names + "\n");
    }

    public static void ex5(List<Guitar> guitars) {
        System.out.println("--- List of rounded prices ---");
        guitars.stream()
                .mapToDouble(Guitar::getPrice)
                .flatMap(n -> DoubleStream.of(Math.round(n)))
                .mapToInt(n-> ((int) n))
                .forEach(System.out::println);
    }

    public static void ex6(List<Guitar> guitars) {
        System.out.println("--- Most expensive guitar ---");
        guitars.stream()
                .reduce((g1, g2) -> g1.getPrice() > g2.getPrice() ? g1 : g2)
                .ifPresent(System.out::println);
    }

    public static void ex6_1(List<Guitar> guitars) {
        System.out.println("--- List of all guitars and total price ---");
        Guitar result = guitars.stream()
                .reduce(new Guitar("", 0), (g1, g2) -> {
                    g1.setPrice(g1.getPrice() + g2.getPrice());
                    g1.setName(g1.getName() + ", " + g2.getName());
                    return g1;
                });

        System.out.format("Name=%s; \nPrice=%s \n\n", result.getName(), result.getPrice());

        System.out.println("--- Sum of all rounded prices ---");
        Integer priceSum = guitars.stream()
                .reduce(0,
                        (sum, g) -> sum += (int) Math.round(g.getPrice()),
                        (sum1, sum2)
                                -> sum1 + sum2);
        System.out.println(priceSum);
    }

    public static void ex7(List<Guitar> guitars) {
        System.out.println("--- List of rounded prices (paralel) ---");
        guitars.parallelStream()
                .mapToDouble(Guitar::getPrice)
                .flatMap(n -> DoubleStream.of(Math.round(n)))
                .mapToInt(n-> ((int) n))
                .forEach(System.out::println);
    }

    public static String ex7_1() {
        List<Guitar> guitarsForTiming = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            guitarsForTiming.add(new Guitar("",i));
        }

        long start1 = System.currentTimeMillis();
        ex5(guitarsForTiming);
        long elapsedTime1 = System.currentTimeMillis() - start1;

        long start2 = System.currentTimeMillis();
        ex7(guitarsForTiming);
        long elapsedTime2 = System.currentTimeMillis() - start2;

        return "\nSimple stream time: " + elapsedTime1 + " ms" + "\nParallel stream time: " + elapsedTime2 + " ms";
    }



    public static void main(String[] args) {
	// write your code here
        List<Guitar> guitars = ex1();

//        ex2(guitars);
//        ex3(guitars);
//        ex4(guitars);
//        ex4_1(guitars);
//        ex5(guitars);
//        ex6(guitars);
//        ex6_1(guitars);
//        ex7(guitars);
        System.out.println(ex7_1());



    }
}
