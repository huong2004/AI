package k21;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		Stack<Node> frontier = new Stack<Node>();
		List<Node> explored = new ArrayList<>();
		frontier.push(root);
		while (!frontier.isEmpty()) {
			Node node = frontier.pop();
			if (node.getChildren().equals(goal))
				return node;
			explored.add(node);
			List<Node> children = node.getChildrenNodes();
			for (int i = children.size() - 1; i >= 0; i--) {
				Node child = children.get(i);
				if (!frontier.contains(child) && !explored.contains(child)) {
					frontier.push(child);
				}
			}
			
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		Stack<Node> frontier = new Stack<Node>();
		List<Node> explored = new ArrayList<>();
		frontier.push(root);
		while (!frontier.isEmpty()) {
			Node node = frontier.pop();
			if (node.getChildren().equals(goal))
				return node;
			List<Node> children = node.getChildrenNodes();
			for (int i = children.size() - 1; i >= 0; i--) {
				Node child = children.get(i);
				if (!frontier.contains(child) && !explored.contains(child)) {
					frontier.push(child);
				}
			}
			
		}
		return null;
	}

}
