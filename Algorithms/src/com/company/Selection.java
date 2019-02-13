package com.company;

/**
 * @author Anderkaisa
 */
public class Selection implements Example {

    public static void main(String[] args) {
        String[] a=In.readStrings();
        Selection test=new Selection();
        test.sort(a);
        assert test.isSorted(a);
        test.show(a);
    }

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    exch(a, i, min);
                }
            }
        }
    }

    @Override
    public boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    @Override
    public void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
            StdOut.println();
        }
    }

    @Override
    public boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
