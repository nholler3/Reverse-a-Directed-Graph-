import java.util.*;
import java.util.Queue;
import java.util.LinkedList;

public class FlipGraph{
    private int[][] adjacencyMatrix;
    private int totalNodes;
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        
        System.out.println("Enter the total number of nodes:");
        int totalNodes=input.nextInt();
        FlipGraph graph= new FlipGraph(totalNodes);

        System.out.println("Enter the edges: (i.e. 2 3 ) enter -1 -1 when you are finished");
        int from=input.nextInt();
        int to=input.nextInt();
        while(from != -1 && to != -1){
            graph.addEdge(from, to);
            from=input.nextInt();
            to=input.nextInt();
        }

        graph.reverseGraph();
        graph.countInDegree();
        graph.countOutDegree();

        input.close();
    }

    public void reverseGraph() {
        int[][] reversedMatrix = new int[totalNodes][totalNodes];
        for (int i = 0; i < this.totalNodes; i++) {
            for (int j = 0; j < this.totalNodes; j++) {
                reversedMatrix[i][j]=this.adjacencyMatrix[j][i];
            }
        }
        this.adjacencyMatrix = reversedMatrix;
    }

    public void countInDegree(){ 
        int max = 0;
		Queue<Integer> holder=new LinkedList<>();
		
		for(int i = 0; i < totalNodes; i++) {
            int count = 0;
			for(int j = 0; j < totalNodes; j++) {
				if(this.adjacencyMatrix[j][i] == 1) {count ++;}}
				if (count == max) {holder.add(i);}
				else if (count > max) {
					max = count;
					holder.clear();
					holder.add(i);
				}
        }
        while (!holder.isEmpty()) {
            System.out.println("Node " + holder.poll() + " has the maximum in-degree of " + max);
        }
       
    }

    public void countOutDegree(){ 
        int max = 0;
		Queue<Integer> holder=new LinkedList<>();

        for(int i = 0; i <this.totalNodes; i++) {
            int count = 0;
			for(int j = 0; j < this.totalNodes; j++) {
                if(this.adjacencyMatrix[i][j] == 1){count++;}}
                if(count==max){holder.add(i);}
                else if(count>max){
                    max=count;
                    holder.clear();
                    holder.add(i);
                }
        }
        while (!holder.isEmpty()) {
            System.out.println("Node " + holder.poll() + " has the maximum out-degree of " + max);
        }
    }

    public void addEdge(int from, int to){adjacencyMatrix[from][to]=1;}

    public FlipGraph(int totalNodes){
        this.totalNodes = totalNodes;
        this.adjacencyMatrix = new int[totalNodes][totalNodes];
    }
}