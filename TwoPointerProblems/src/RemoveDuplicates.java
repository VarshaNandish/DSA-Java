public class RemoveDuplicates {

    public static int removeDups(int[] nums){

        if (nums.length==0)
        return 0;

        int i = 0;
        for (int j=1; j< nums.length; j++){
            if (nums[j]!=nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        int[] nums ={0,0,1,1,1,2,2,3,3,4};
        int k= removeDups(nums);

        System.out.println("unique count:"+k);
        System.out.print("Modified array:");
        for (int i=0; i<k;i++) {
            System.out.print(nums[i]+"");
        }
    }
}
