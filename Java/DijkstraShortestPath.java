import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraShortestPath {

	public static int dijkstra(int N, List<List<Node>> adjList, int source, int dest) {

		int[] dist = new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE);

		boolean[] visited = new boolean[N];

		var pq = new PriorityQueue<Node>();
		dist[source] = 0;
		pq.add(new Node(source, dist[source])); // start with source node

		while (!pq.isEmpty()) {
			Node u = pq.remove();

			visited[u.node] = true;
			var neighbours = adjList.get(u.node);

			for (var v : neighbours) {
				if (!visited[v.node]) {
					var newNeigCost = dist[u.node] + v.cost;

					if (newNeigCost < dist[v.node]) {
						dist[v.node] = newNeigCost;
						// it is possible to have duplicate nodes in the queue but it is ok
						pq.add(new Node(v.node, dist[v.node]));
					}
				}
			}
		}
		
		return dist[dest];
	}

	public static void main(String[] args) {
		int V = 5;
		int source = 0;

		// Adjacency list representation of the
		// connected edges
		List<List<Node>> adj = new ArrayList<List<Node>>();

		// Initialize list for every node
		for (int i = 0; i < V; i++) {
			List<Node> item = new ArrayList<Node>();
			adj.add(item);
		}

		adj.get(0).add(new Node(1, 9));
		adj.get(0).add(new Node(2, 6));
		adj.get(0).add(new Node(3, 5));
		adj.get(0).add(new Node(4, 3));

		adj.get(2).add(new Node(1, 2));
		adj.get(2).add(new Node(3, 4));

		int dest = 3;

		// Calculate the single source shortest path
		int res = dijkstra(V, adj, source, dest);

		System.out.println("Shortest distance from " + source + " to " + dest + "=" + res);
		System.out.println("Shortest distance from " + source + " to " + dest + "=" + res);
	}

	static class Node implements Comparable<Node> {
		public int node;
		public int cost;

		public Node() {
		}

		public Node(int node, int cost) {
			this.node = node;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node node2) {
			if (this.cost < node2.cost)
				return -1;
			if (this.cost > node2.cost)
				return 1;
			return 0;
		}
	}
}
