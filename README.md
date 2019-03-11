# periodic-table
A basic Java program for mapping the periodic table of elements

The online CSV (https://en.wikipedia.org/wiki/Comma-separated_values) file contains data about 104 chemical elements. A copy of this file has been made within this repository. Apart from the initial header row, each row contains data about a chemical element in the following format:

| Atomic Number | Symbol        | Element name  | Group         | Period        | Atomic weight |
| ------------- | ------------- | ------------- | ------------- | ------------- | ------------- |
| 8             | 0             | Oxygen        | 16            | 2             | 15.999        |

In each row, the six fields are separated by commas. It can be assumed that there are no other commas in the CSV file.

## Part A

The main class Element represents the data for one element as in the file elements.csv. Each Element object has six fields corresponding to the columns in that file: 
* **number** (int)
* **symbol** (String)
* **name** (String)
* **group** (int)
* **period** (int)
* **weight** (double) 

The class also has: 
* a constructor with six arguments for initialising the six fields
* an instance method toString() which returns a string in the same format as a row in the CSV file. For example, in the case of Oxygen, the result should be:
```
8, O, Oxygen, 16, 2, 15.999
```

## Part B

In the class Element, there is a method:
```
public static List<Element> readElements()
```
The method reads the chemical element data from file elements.csv. It also skips the header row. For each row thereafter, it will create a corresponding Element object. The method will return a list containing these objects in the same order as they are in the file.

In the class Element, there is a method:
```
public static void partB()
```
This method will invoke readElements() and display the first 20 elements from that list. 

## Part C

In the class Element, there is a method:
```
public static void partC()
```

The method reads the data from file elements.csv into a list using method readElements(). It will then:
* sort the elements in that list by number in increasing order and print the first 20 elements of that list; and then
* perform another sorting of the list but this time order elements by their groups in increasing order. Elements in the same group are sorted by their number.

Sorting is performed using method Collections.sort
(https://docs.oracle.com/javase/8/docs/api/java/util/Collections.html#sort-java.util.List-)
with appropriate implementations of interfaces Comparable<Element> and or Comparator<Element>.

## Part C

In the class Element, there is a method:
```
public static Map<Integer, Set<Element>> elementsByGroup(List<Element> elements)
```

Given a list of Element objects, this method returns a map which associates each group with the set of elements in that group. The map is sorted according to the natural ordering of its keys. Each of the sets of chemical elements are sorted by element numbers. 

## Part D

In the class Element, there is a method:
```
public static Map<Integer, Set<Element>> elementsByGroup(List<Element> elements)
```

In the class Element, there is a method:
```
public static void partD()
```
This method reads the element data from file elements.csv into a list using method readElements(). It should invoke method elementsByGroup with that list. This method invocation returns a map. For each group that occurs as a key in that map, the program should display:
* The name of the group
* The first three elements of the set associated with the group in the map.

This will result in program output as follows:
```
Group 1:
1,Hydrogen,H,1,1,1.008
3,Lithium,Li,1,2,6.94
11,Sodium,Na,1,3,22.98976928
Group 2:
4,Beryllium,Be,2,2,9.0121831
12,Magnesium,Mg,2,3,24.305
20,Calcium,Ca,2,4,40.078
...
Group 18:
2,Helium,He,18,1,4.002602
10,Neon,Ne,18,2,20.1797
18,Argon,Ar,18,3,39.948
```
