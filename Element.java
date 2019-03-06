package PeriodicTable;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class Element implements Comparable<Element>  {
    String symbol, name;
    double weight;
    int number, group, period;

    public Element(int number, String symbol, String name, int group, int period, double weight) {
        this.number = number;
        this.group = group;
        this.period = period;
        this.symbol = symbol;
        this.name = name;
        this.weight = weight;
    }

    public static List<Element> readElements() {
        List<Element> elementList = new ArrayList<>();
        try {
            URL elements = new URL("https://raw.githubusercontent.com/gregorycave/periodic-table/master/elements.csv");
            try {
                Scanner scan = new Scanner(elements.openConnection().getInputStream());
                scan.nextLine();
                while (scan.hasNextLine()) {
                    String line = scan.nextLine();
                    String[] values = line.split(",");
                    int number = Integer.parseInt(values[0]);
                    String symbol = values[1];
                    String name = values[2];
                    int group = Integer.parseInt(values[3]);
                    int period = Integer.parseInt(values[4]);
                    double weight = Double.parseDouble(values[5]);
                    Element element = new Element(number, symbol, name, group, period, weight);
                    elementList.add(element);
                }
            } catch (IOException e) {
                System.out.println("Error - file could not be opened.");
            }
        } catch (MalformedURLException e) {
            System.out.println("Error - file could not be found.");
        }

        return elementList;
    }
    public static Map<Integer, Set<Element>> elementsByGroup(List<Element> elements) {
        Map<Integer, Set<Element>> groupElement = new HashMap<>();
        for (int each = 1; each < 19; each++) {
            Set<Element> set = new TreeSet<>();
            for (Element el : elements) {
                if (el.group == each) {
                    set.add(el);
                }
            }
            groupElement.put(each,set);
        }
        return groupElement;
    }
    @Override
    public int compareTo(Element el2) {
        if (this.number > el2.number) {
            return 1;
        } else if (this.number < el2.number) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return number + ", "+ symbol +", "+ name + ", " + group + ", " + period + ", " + weight;
    }
}