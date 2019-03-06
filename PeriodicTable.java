package PeriodicTable;

import java.util.*;

public class PeriodicTable {
    public static void partA() {
        Element oxygen = new Element(8, "O", "Oxygen", 16, 2, 15.999);
        System.out.println(oxygen + "\n");
    }
    public static void partB(){
        List<Element> elementList = Element.readElements();
        for (int each = 0; each < 20; each++){
            System.out.println(elementList.get(each));
        }
        System.out.println("\n");
    }

    public static void partC() {
        List<Element> elementList = Element.readElements();
        Collections.sort(elementList);
        System.out.println("\n");
        for (int each = 0; each < 20; each++) {
            System.out.println(elementList.get(each));
        }
        System.out.println("\n");
        Collections.sort(elementList, new Comparator<Element>()  {
            public int compare(Element el1, Element el2) {
                if (el1.group > el2.group) return 1;
                else if (el1.group <  el2.group){
                    return -1;
                }
                return 0;
            }
        });
        for (int other = 0; other < 20; other++) {
            System.out.println(elementList.get(other));
        }
    }

    public static void partD() {
        System.out.println("\n");
        List<Element> elementsList = Element.readElements();
        Map<Integer, Set<Element>> myMap = Element.elementsByGroup(elementsList);
        for (int i = 1; i < 19; i++) {
            int counter = 0;
            System.out.println("Group " + i + ":");
            for (Element el : myMap.get(i)) {
                counter++;
                System.out.println(el);
                if (counter == 3) {
                    break;
                }
            }
        }
    }
}