package pl.kuglin.arrayalghoritms;

public class MaxSubarray {

    private MaxSubarray() {
    }

    public static Result findMaximumSubarray(Double[] array, int low, int high) {
        if (high == low)
            return new Result(low, high, array[low]);
        else {
            int mid = (low + high) / 2;
            Result leftValue = findMaximumSubarray(array, low, mid);
            Result rightValue = findMaximumSubarray(array, mid + 1, high);
            Result crossValue = findMaxCrossingSubarray(array, low, mid, high);

            if (leftValue.sum > rightValue.sum && leftValue.sum > crossValue.sum)
                return leftValue;
            else if (rightValue.sum > leftValue.sum && rightValue.sum > crossValue.sum)
                return rightValue;
            else
                return crossValue;
        }
    }

    private static Result findMaxCrossingSubarray(Double[] array, int low, int mid, int high) {
        int maxLeft = 0;
        int maxRight = 0;


        double leftSum;
        double sum;

        sum = array[mid];
        leftSum = sum;

        for (int i = mid - 1; i >= low; i--) {
            sum = sum + array[i];
            if (sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }

        double rightSum;

        sum = array[mid + 1];
        rightSum = sum;

        for (int i = mid + 2; i <= high; i++) {
            sum = sum + array[i];
            if (sum > rightSum) {
                rightSum = sum;
                maxRight = i;
            }
        }

        return new Result(maxLeft, maxRight, leftSum + rightSum);
    }

    public static class Result {
        private int low;
        private int high;
        private double sum;

        Result(int low, int high, double sum) {
            this.low = low;
            this.high = high;
            this.sum = sum;
        }

        public int getLow() {
            return low;
        }

        public int getHigh() {
            return high;
        }

        public double getSum() {
            return sum;
        }
    }
}
