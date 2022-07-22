import com.sun.source.tree.Tree;

import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int[] zakres;
        System.out.println("Poczatek zakresu: ");
        int x = scanner.nextInt();
        System.out.println("Koniec zakresu: ");
        int y = scanner.nextInt();
        int size = y-x+1;
        List<Integer> list = new ArrayList<Integer>();
        while(y<x)
        {
            System.out.println("koniec zakresu musi byc wiekszy niz poczatek sprobuj ponownie.");
            System.out.println("Poczatek zakresu: ");
            x = scanner.nextInt();
            System.out.println("Koniec zakresu: ");
            y = scanner.nextInt();
        }

        TreeMap<Integer,ArrayList<int[]>> integerMap = new TreeMap<>();
        for (int i = x; i <= y; i++)
        {
            for (int j = i; j <= y; j++)
            {
                int tmp = i*j;
                int[] products = {i, j};
                if(!integerMap.keySet().contains(tmp))
                {
                    ArrayList<int[]> productsList = new ArrayList<int[]>();
                    productsList.add(products);
                    integerMap.put(tmp,productsList);
                }
                else if(integerMap.keySet().contains(tmp))
                    integerMap.get(tmp).add(products);




            }
        }
        String test = "blacipabla";
        int subIndex = test.indexOf('c');
        String sub = test.substring(0,subIndex);
        System.out.println(sub);



      ifPalindrom(integerMap);

      result(integerMap);



    }
    public static List<Integer> stringList= new ArrayList<Integer>();
    public static void result(TreeMap<Integer,ArrayList<int[]>> map) {
        int smallest = map.firstKey();
        ArrayList<int[]> smallestValue = map.get(smallest);
        int biggest = map.lastKey();
        ArrayList<int[]> biggestValue = map.get(biggest);
        System.out.println(smallest + " and its products: ");
        for (int[] printable : smallestValue) {
            System.out.println(Arrays.toString(printable));
        }
        System.out.println(biggest + " and its products: ");
        for (int[] printable : biggestValue) {
            System.out.println(Arrays.toString(printable));
        }
    }
    public static void ifPalindrom(Map<Integer,ArrayList<int[]>> map)
    {
        Iterator<Integer> it = map.keySet().iterator();
        while(it.hasNext())
        {
            int liczba = it.next();
            String number = String.valueOf(liczba);
            for (int i = 0; i < number.length(); i++)
            {
                if(!(number.charAt(i)==number.charAt(number.length()-1-i)))
                {
                    int key = Integer.parseInt(number);
                    if(map.containsKey(key))
                    it.remove();
                }
            }
        }
    }
}