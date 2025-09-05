import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<List<Integer>> getTargetPair(List<Integer> lists, int target) {
        List<Integer> elementsWithAPair = new ArrayList<>(); // variable that stores the list of elements that has already found its pair
        List<List<Integer>> listsOfPairs = new ArrayList<>(); // variable that stores list of pairs matching with the target
        int requiredElement;  // element which sums needs to be matched with the target to find the pair

        for (int element: lists) {
            if (!elementsWithAPair.contains(element)){ // skip the iteration if the element from the previous pair repeats
                requiredElement = target - element;
                if (lists.contains(requiredElement)) {
                    listsOfPairs.add(Arrays.asList(element, requiredElement));
                    elementsWithAPair.add(requiredElement);
                }
            }
        }

        return listsOfPairs;
    }

    public static void main(String[] args) {
        System.out.print("Enter the length of array you want to enter: ");
        Scanner sc = new Scanner(System.in);

        int length = sc.nextInt();

        List<Integer> listOfArray = new ArrayList<>();

        for (int i = 0; i < length; i ++) {
            System.out.print("Array[" + i + "] :");
            listOfArray.add(sc.nextInt());
        }

        System.out.print("Enter the target: ");
        int target = sc.nextInt();

        List<List<Integer>> pairs = getTargetPair(listOfArray, target);

        System.out.println("Here are the pairs matching with the target: ");
        System.out.println(pairs);
    }
}
