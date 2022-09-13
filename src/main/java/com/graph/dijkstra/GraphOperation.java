package com.graph.dijkstra;

import java.util.ListIterator;

public class GraphOperation {

	public static void main (String args[]) {
		Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        
        nodeA.addDestination(nodeB, 10);
        nodeA.addDestination(nodeC, 15);

        nodeB.addDestination(nodeD, 12);
        nodeB.addDestination(nodeF, 15);

        nodeC.addDestination(nodeE, 10);

        nodeD.addDestination(nodeE, 2);
        nodeD.addDestination(nodeF, 1);

        nodeF.addDestination(nodeE, 5);
        
        Graph graph = new Graph();

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);
        
        graph = Dijkstra.calculateShortestPathFromSource(graph, nodeA);
        for (Node node : graph.getNodes()) {
        	ListIterator<Node> iterator = (ListIterator<Node>) node.getShortestPath().iterator();
			while (iterator.hasNext()) {
				System.out.print(iterator.next().getName() + "");
				
			}
			System.out.print(node.getName() + "->");
			System.out.print(node.getDistance() + "");
			System.out.println();
        }
	}
}
