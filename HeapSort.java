public class HeapSort{
    public static void main(String args[])
    {
        int arr[] = {23,34,1,2,34,21,1000,-6,5};

        heapSort(arr);
        System.out.println("Пирамидальная сортировка: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void heapSort(int[] arr){
        int n = arr.length;

        for(int i = n/2 - 1; i >= 0; i--) heapify(arr, i, n);

        for(int i = n - 1; i >= 0; i--){
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            heapify(arr, 0, i);
        }
    }

    private static void heapify(int[] arr, int i, int n){
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int largest = i;

        if (left < n && arr[left] > arr[largest]) largest = left;
        if (right < n && arr[right] > arr[largest]) largest = right;

        if (i != largest){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, largest, n);
        }
    }
}