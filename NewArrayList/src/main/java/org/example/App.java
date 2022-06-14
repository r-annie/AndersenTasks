package org.example;

public class App 
{
    public static void main( String[] args )
    {
        ArrayListOfMine<Integer> test = new ArrayListOfMine<>();
        for (int i = 0; i < 10; i++) {
            int randomNum = (int)((Math.random()+1) * 10);
            test.add(randomNum);
        }
        for (int i = 0; i < test.size(); i++) {
            System.out.print(test.get(i) + " ");
        }
        test.quickSort();
        System.out.println();
        for (int i = 0; i < test.size(); i++) {
            System.out.print(test.get(i) + " ");
        }
    }
}
