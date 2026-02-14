package LeetcodeSearchingAndSorting;

public class AllocateBooks {
    public static void main(String[] args) {
        int[] arr={12, 34, 67, 90};
        int k= 2;
        System.out.println(findPages(arr,k));
    }

    public static int findPages(int[] arr, int k) {
        // code here
        int n = arr.length;
        if(k>n){
            return -1;
        }

        int low =0,high =0;
        for(int x:arr){
            low=Math.max(low,x);
            high+=x;
        }

        while(low <= high){
            int mid = low+(high-low)/2;
            int student = countStudent(arr,mid);
            if(student > k){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        return low;
    }

    public static int countStudent(int[] arr, int pages) {
        int student =1;
        int pagesStudent=0;

        for(int i=0;i<arr.length;i++){
            if(pagesStudent+arr[i] <= pages){
                pagesStudent+=arr[i];
            }else{
                student+=1;
                pagesStudent=arr[i];
            }
        }

        return student;
    }
}
