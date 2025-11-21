class LFUCache {
    PriorityQueue<Pair> pq = new PriorityQueue<>(
        (a,b) -> a.freq!=b.freq?a.freq-b.freq:a.time-b.time
    );
    Map<Integer, Pair> mp = new HashMap<>();
    int c;
    int time=0;
    public LFUCache(int capacity) {
        c=capacity;
    }
    
    public int get(int key) {
      if(mp.containsKey(key)){
        Pair p = mp.get(key);
        pq.remove(p);
        p.freq++;
        p.time = time++;
        pq.offer(p);
        mp.put(key, p);
        return p.val;
      }else{
        return -1;
      }
    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key)){
            Pair p = mp.get(key);
            pq.remove(p);
            p.val = value;
            p.freq++;
            p.time = time++;
            mp.put(key, p);
            pq.offer(p);
        }else{
            if(mp.size() == c){
                Pair p = pq.poll();
                mp.remove(p.key);
            }
            Pair p = new Pair(1, ++time, value, key);
            pq.offer(p);
            mp.put(key, p);
        }
    }
}

class Pair{
    int freq;
    int time;
    int val;
    int key;

    public Pair(int _f, int _t, int _v, int k){
        key=k;
        freq = _f;
        time = _t;
        val = _v;
    }
}
