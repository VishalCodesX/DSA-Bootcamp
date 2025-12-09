class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> s = new Stack<>();

        for (int i=0; i<n; i++){
            if(asteroids[i] > 0 || s.isEmpty()) {
                s.push(asteroids[i]);
            }else{
                while(!s.isEmpty() && s.peek() > 0
                    && s.peek() <Math.abs(asteroids[i])){
                        s.pop();
                    }

            if(!s.isEmpty() && s.peek() == Math.abs(asteroids[i])) {
                s.pop();
            }else{
                if(s.isEmpty() || s.peek()<0){
                    s.push(asteroids[i]);
                }
            }
            }
        }
        int[] result = new int[s.size()];
        for (int i = s.size() - 1; i>=0; i--){
            result[i] = s.pop();
        }
        return result;
    }
}
