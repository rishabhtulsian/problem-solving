import java.util.TreeMap;

class Solution {

    public int oddEvenJumps(int[] A) {
        boolean[] validOdd = new boolean[A.length];
        boolean[] validEven = new boolean[A.length];
        int count = 1;

        validOdd[A.length-1] = true;
        validEven[A.length-1] = true;

        TreeMap<Integer, Integer> numbers = new TreeMap<>();
        numbers.put(A[A.length-1], A.length-1);

        for (int i = A.length-2; i >= 0; i--) {
            if (numbers.containsKey(A[i])) {
                validOdd[i] = validEven[numbers.get(A[i])];
                validEven[i] = validOdd[numbers.get(A[i])];
            } else {
                Integer higher = numbers.higherKey(A[i]);
                if (higher != null) {
                    validOdd[i] = validEven[numbers.get(higher)];
                }
                Integer lower = numbers.lowerKey(A[i]);
                if (lower != null) {
                    validEven[i] = validOdd[numbers.get(lower)];
                }
            }
            numbers.put(A[i], i);
            if (validOdd[i]) count++;
        }
        return count;
    }
}