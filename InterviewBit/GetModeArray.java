public class Solution {
    
    // public static class XC {
    //     int f = 0;
    //     int val;
        
    //     public XC(int f, int val){
    //         this.f = f;
    //         this.val = val;
    //     }
    // }
    
    public ArrayList<Integer> getMode(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        
        ArrayList<Integer> res = new ArrayList<Integer>();
        int size = (int)Math.pow(10,8)+1;
        int[] freq = new int[size];
        Arrays.fill(freq, 0);
        
        // store orig freq.
        for(int i=0 ; i<A.size() ; i++){
            freq[A.get(i)]++;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(10, new Comparator<Integer>() {
            public int compare(Integer a, Integer b){
                if(freq[a] < freq[b]){
                    return 1;
                }
                if(freq[a] > freq[b]){
                    return -1;
                }
                if(freq[a] == freq[b]){
                    if(a > b)
                        return 1;
                    else
                        return -1;
                }
                return 0;
            }
        });
        
        
        for(int i=0 ; i<freq.length ; i++){
            // pq.add(new XC(A.get(i), freq[A.get(i)]));
            if(freq[i] > 0)
            pq.add(i);
        }
        
        for(int i=0 ; i<B.size() ; i++){
            int index = B.get(i).get(0)-1;
            int val =   B.get(i).get(1);
            
            // perform update
            
            freq[A.get(index)]--;
            freq[val]++;
            
            if(pq.contains(A.get(index)))
                pq.remove(A.get(index));
            if(pq.contains(val))
                pq.remove(val);
                
            if(freq[A.get(index)] > 0 )
                pq.add(A.get(index));
                pq.add(val);
                
            A.set(index, val);
            // fetch mode
            if(pq.size() == 1) {
                res.add(pq.peek());
            } else {
                int top = pq.poll();
                int next = pq.peek();
                if(freq[top] == freq[next]){
                    res.add(Math.min(top, next));
                } else {
                    res.add(top);
                }
                pq.add(top);
                
            }
        }
        return res;
        
    }
}
