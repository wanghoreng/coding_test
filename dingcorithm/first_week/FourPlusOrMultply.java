package dingcorithm.first_week;

public class FourPlusOrMultply {
    public static void main(String[] args) {

        System.out.println(findMaxPlusOrMultiply(new int[]{0,3,5,6,1,2,4}));
        System.out.println(findMaxPlusOrMultiply(new int[]{3,2,1,5,9,7,4}));
        System.out.println(findMaxPlusOrMultiply(new int[]{1,1,1,3,3,2,5}));
    }

    private static int findMaxPlusOrMultiply(int[] array) {

        // 0 또는 1 일 땐 + 하기
        // 아니면 * 하기
        int sum = 0;

        for(int num : array) {
            if(num <= 1 || sum <= 1) {
                sum += num;
            } else {
                sum *= num;
            }
        }
        return sum;
    }
}
