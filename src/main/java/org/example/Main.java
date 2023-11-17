package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Demo of binarySearch()");

        Student[] students = new Student[4];
        students[0] = new Student("Zoe",21,1.78);
        students[1] = new Student("Jack", 20,1.80);
        students[2] = new Student("Alex",19,1.85);
        students[3] = new Student("Fred",21,1.74);

        // Case 1 - search based on Natural Ordering
        // Elements must be sorted in ascending order based on Natural Ordering
        // - as defined by compareTo() - before binarySearch can be used.
        // In this example, the student name is used for the natural ordering.
        //
        Arrays.sort(students);

        // Initialise a key value to search for.  As the natural ordering
        // involves only the student name, that is the only field that we
        // need to set.  We are searching for a Student object with the name "Zoe".
        //
        Student key = new Student("Zoe",0,0.0);

        int index = Arrays.binarySearch( students, key );

        if(index < 0)
            System.out.println("Key value not found in array.");
        else
            System.out.println("Found key " + students[index].toString() + " at index " + index);

        // Note that if there are duplicates (e.g. two Zoes) then we will
        // find one of them, but we won't know which one (first, or second, or...)

    // Case 2 - Using binarySearch with a Comparator
        // If we wish to search based on some other field - other than name - then
        // we need to sort() using a Comparator and then search using the same Comparator.
        // If we fail to apply a consistent sort() followed by binarySearch(), then
        // we will get unreliable results.

            Arrays.sort(students, new StudentAgeComparator());  // sort before binary search

            // searching for a student's age this time
            Student keyWithAge = new Student("", 21, 0.0);

            index = Arrays.binarySearch(students, keyWithAge, new StudentAgeComparator());

            if (index < 0)
                System.out.println("Key value not found in array.");
            else
                System.out.println("Found key " + students[index].toString()+ " at index: " + index);
        }

        // Note that we could have found student "Fred" as he is 21 also.
        // Ase we said earlier, we don't know which one we will get back,
        // so don't assume that it will be the first one in the list.

}