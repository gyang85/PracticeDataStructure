package com.graph.dijkstra;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Node {

	private String name;
	private Integer distance = Integer.MAX_VALUE;
	private Map<Node, Integer> adjacentNodes = new HashMap();
	private LinkedList<Node> shortestPath = new LinkedList();
	
	public void addDestination(Node destinationNode, int distance) {
		adjacentNodes.put(destinationNode, distance);
	}
	
	public Node (String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public Map<Node, Integer> getAdjacentNodes() {
		return adjacentNodes;
	}

	public void setAdjacentNodes(Map<Node, Integer> adjacentNodes) {
		this.adjacentNodes = adjacentNodes;
	}

	public LinkedList<Node> getShortestPath() {
		return shortestPath;
	}

	public void setShortestPath(LinkedList<Node> shortestPath) {
		this.shortestPath = shortestPath;
	}
	
	
}
