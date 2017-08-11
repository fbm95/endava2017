package com.github.unit_testing.ex.range;

import java.util.ArrayList;

/**
 * Task implement and test a Range that accepts a string representing a numeric range
 * that may have an inclusive or exclusive start and end range value
 *
 * 1) Input and validation of a range
 * 2) Return all the integer values in that range
 * 3) Check Range inclusion:
 *          * [3,5] contains [3,5)
 *          * [2,5) does not contain [3,6)
 * 4) Check if individual numbers are within the range
 * 5) Check if two ranges are equal
 * 6) Union and Intersection of two ranges
 */
public class Range {

    public String[] sampleInputs = {
      "[1,3]", "[2,5)", "(4,6]", "(0,9)"
    };

    int x;
    int y;

    public Range(){
    }

    public Range(String range){
        if(!range.matches("[(\\[][1-9][0-9]*[,][1-9][0-9]*[)\\]]"))
            throw new IllegalArgumentException("please insert a correct range: [1,3], [2,5), (4,6], (0,9)");

        String[] numbers = range.split("\\[|\\(|\\)|\\]|\\,");

        if(range.charAt(0)=='[')
            x=Integer.parseInt(numbers[1]);
        else
            x=Integer.parseInt(numbers[1])+1;

        if(range.charAt(range.length()-1)==']')
            y=Integer.parseInt(numbers[2]);
        else
            y=Integer.parseInt(numbers[2])-1;
    }

    public static ArrayList<Integer> returnAll(Range range){
        ArrayList<Integer> integerArrayList = new ArrayList<>();

        for(int i=range.x;i<=range.y;i++)
            integerArrayList.add(i);

        return integerArrayList;
    }

    public boolean includes(Range range){
        if(this.x <= range.y && range.y <= this.y)
            return true;
        else
            return false;
    }

    public static boolean checkNumber(int num, Range range){
        if(range.x <= num && num <= range.y)
            return true;
        else
            return false;
    }

    public static boolean checkRangesEquality(Range range1, Range range2){
        if(range1.x == range2.x && range1.y <= range2.y)
            return true;
        else
            return false;
    }

    public ArrayList<Integer> union(Range range){
        ArrayList<Integer> integerArrayList = new ArrayList<>();

        int first, last;
        if(this.x < range.x)
            first = this.x;
        else
            first = range.x;

        if(this.y > range.y)
            last = this.y;
        else
            last = range.y;

        for(int i=first;i<=last;i++)
            integerArrayList.add(i);

        return integerArrayList;
    }

    public ArrayList<Integer> intersect(Range range){
        ArrayList<Integer> integerArrayList = new ArrayList<>();

        int first, last;
        if(this.x < range.x)
            first = range.x;
        else
            first = this.x;

        if(this.y > range.y)
            last = range.y;
        else
            last = this.y;

        for(int i=first;i<=last;i++)
            integerArrayList.add(i);

        return integerArrayList;
    }



    public static void main(String[] args) {
        Range x = new Range("[2,13)");
        Range y = new Range("[4,7]");
        System.out.println("Return all x: " + returnAll(x));
        System.out.println("Return all y: " + returnAll(y));
        System.out.println("Inclusion: " + x.includes(y));
        System.out.println("Check number: " + checkNumber(14,x));
        System.out.println("Check ranges equality: " + checkRangesEquality(x, y));
        System.out.println("Union: " + x.union(y));
        System.out.println("Intersection: " + x.intersect(y));
    }

}
