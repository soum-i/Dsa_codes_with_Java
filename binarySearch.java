import java.util.Scanner;
public class binarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = {0, 2, 5, 88, 97, 202, 315};
        System.out.println("Enter target: ");
        int target = sc.nextInt();
        int result = search(arr, target);
        if(result != -1) {
            System.out.println("found at index: " + (result+1));
        }
        else
            System.out.println("not found");
    }

    static int search(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left )/2;
            if(arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                left = mid +1;
            }
            else {
                right = mid -1;
            }
        }
        return -1;
    }
}
