public class dijkstra{
int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {

        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(p -> p.distance));

        int[] dis = new int[V];

        for (int i = 0; i < V; i++) {
            dis[i] = Integer.MAX_VALUE;
        }

        dis[S] = 0;

        queue.add(new Pair(S, 0));

        while (!queue.isEmpty()){
            Pair pair = queue.poll();
            int distance = pair.distance;
            int node = pair.node;


            for (ArrayList<Integer> arr : adj.get(node)) {
                if(distance + arr.get(1) < dis[arr.get(0)]){
                    dis[arr.get(0)] = Math.min(dis[arr.get(0)], distance + arr.get(1));
                    queue.add(new Pair(arr.get(0), arr.get(1) + distance));
                }

            }
        }
        return dis;
    }

    private class Pair{
        int node;
        int distance;

        public Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
}
