package com.graph.dijkstra;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

public class Dijkstra {

	public static Graph calculateShortestPathFromSource(Graph graph, Node source) {
		// setting distance 0 to first node
		source.setDistance(0);
		
		Set<Node> settledNodes = new HashSet();
		Set<Node> unsettledNodes = new HashSet();
		
		// set first node to unsettled node
		
		unsettledNodes.add(source);
		
		// Now iterate from source until it's 0
		
		while (unsettledNodes.size()!=0) {
			// Fetch lowest distance node
			Node currentNode = getLowestDistanceNode(unsettledNodes);
			unsettledNodes.remove(currentNode);
			
			// Now fetch all the neighbor node
			
			for (Entry<Node, Integer> adjacentPair : currentNode.getAdjacentNodes().entrySet()) {
				Node adjacentNode = adjacentPair.getKey();
				Integer edgeWeight = adjacentPair.getValue();
				
				// check if adjacentNode is not present in settledNode
				if (!settledNodes.contains(adjacentNode)) {
					// calculate minimum distance
					calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
					unsettledNodes.add(adjacentNode);
				}
			}
			settledNodes.add(currentNode);
		}
		return graph;
		
	}
	
	/** 
	 * Calculate minimum distance between
	 * @param evaluationNode
	 * @param edgeWeight
	 * @param sourceNode
	 */
	public static void calculateMinimumDistance(Node evaluationNode, Integer edgeWeight, Node sourceNode) {
		Integer sourceDistance = sourceNode.getDistance();
		if ((sourceDistance + edgeWeight) < evaluationNode.getDistance()) {
			evaluationNode.setDistance(sourceDistance + edgeWeight);
			LinkedList<Node> shortestPath = new LinkedList<Node>(sourceNode.getShortestPath());
			shortestPath.add(sourceNode);
			evaluationNode.setShortestPath(shortestPath);
		}
		
	}
	public static Node getLowestDistanceNode(Set<Node> unsettledNodes) {
		// initialize with null and iterate
		Node lowestDistanceNode = null;
		// configure lowest distance with maximum value as we don't know
		int lowestDistance = Integer.MAX_VALUE;
		
		for (Node node : unsettledNodes) {
			int nodeDistance = node.getDistance();
			if (nodeDistance < lowestDistance) {
				lowestDistance = nodeDistance;
				lowestDistanceNode = node;
			}
		}
		return lowestDistanceNode;
		
	}
}
