import java.util.Scanner;
public class linearSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int arr[] = {1, 4, 5, 76, 99};
        System.out.println("Enter taget: ");
        int target = sc.nextInt();

        int result = Search(arr, target);

        if(result != -1) {
            System.out.println("Found at index: " + result+1);
        }
        else{
            System.out.println("not found");
        }

    }

    static int Search (int [] arr, int target) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == target)
                return i;
        }
        return -1;
    }
}

