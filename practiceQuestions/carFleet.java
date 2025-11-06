class Solution {
    public int carFleet(int target, int[] position, int[] speeds) {
        int[][] calc = new int[position.length][2];

        for(int i=0; i<calc.length; i++){
            calc[i][0] = position[i];
            calc[i][1] = speeds[i];
        }

        Arrays.sort(calc, (a,b) -> Integer.compare(b[0], a[0]));
        Stack<Double> st = new Stack<>();
        for(int i=0; i<calc.length; i++){
            int pos = calc[i][0];
            int speed = calc[i][1];

            double timeTaken= (double) (target-pos)/speed;

            if(st.isEmpty() || st.peek()<timeTaken){
                st.push(timeTaken);
            }
        }

        return st.size();
    }
}
