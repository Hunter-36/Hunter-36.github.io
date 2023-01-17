import java.util.*;
import java.lang.*;

class Edge {
    // compare edge by weight
    class Edges implements Comparable<Edges> {
        int node1, node2, weight;
        public int compareTo(Edges compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }
    // help union and find element
    class subset {
        int parent, rank;
    }
    int V, E;
    Edges edge[];
    // creates a graph with vert and edge
    Edge(int v, int e) {
        V = v;
        E = e;
        edge = new Edges[E];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edges();
    }
    // to find set of element
    int findElement(subset subsets[], int i) {
        if (subsets[i].parent != i)
            subsets[i].parent
                    = findElement(subsets, subsets[i].parent);
        return subsets[i].parent;
    }
    // gets union of two sets
    void Union(subset subsets[], int x, int y) {
        int xroot = findElement(subsets, x);
        int yroot = findElement(subsets, y);
        if (subsets[xroot].rank
                < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank
                > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }
    // main using kruskal algorithm to get the mst
    void mainK() {
        Edges result[] = new Edges[V];
        int e = 0;
        int i = 0;
        for (i = 0; i < V; ++i)
            result[i] = new Edges();
        Arrays.sort(edge);
        subset subsets[] = new subset[V];
        for (i = 0; i < V; ++i)
            subsets[i] = new subset();
        for (int v = 0; v < V; ++v) {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }
        i = 0;
        while (e < V - 1) {
            Edges next_edge = edge[i++];
            int x = findElement(subsets, next_edge.node1);
            int y = findElement(subsets, next_edge.node2);
            if (x != y) {
                result[e++] = next_edge;
                Union(subsets, x, y);
            }
        }
        // print out the answer
        System.out.println("The set of edges in the MST is: ");
        int minimumCost = 0;
        for (i = 0; i < e; ++i) {
            System.out.println("[" + result[i].node1 + ","
                    + result[i].node2
                    + "] weight: " + result[i].weight);
            minimumCost += result[i].weight;
        }
        System.out.println("Minimum Cost Spanning Tree "
                + minimumCost);
    }
    // Scanning code
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>( );
        Scanner scnr = new Scanner(System.in);
        // type -1 when done entering all values then return
        while (scnr.hasNext()) {
            int value = scnr.nextInt();
            if (value == -1) {
                break;
            }
            input.add(value);
        }

        int V = 6;
        int E = 5;
        Edge object = new Edge(V, E);
        // made for star5.txt testing
        // add more for more testing
        object.edge[0].node1 = input.get(0);
        object.edge[0].node2 = input.get(1);
        object.edge[0].weight = input.get(2);

        object.edge[1].node1 = input.get(3);
        object.edge[1].node2 = input.get(4);
        object.edge[1].weight = input.get(5);

        object.edge[2].node1 = input.get(6);
        object.edge[2].node2 = input.get(7);
        object.edge[2].weight = input.get(8);

        object.edge[3].node1 = input.get(9);
        object.edge[3].node2 = input.get(10);
        object.edge[3].weight = input.get(11);

        object.edge[4].node1 = input.get(12);
        object.edge[4].node2 = input.get(13);
        object.edge[4].weight = input.get(14);

        object.mainK();
    }
}