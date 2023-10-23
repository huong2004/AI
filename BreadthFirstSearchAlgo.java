package k21;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BreadthFirstSearchAlgo implements ISearchAlgo {
	@Override
	public Node execute(Node root, String goal) {
		Queue<Node> frontier = new LinkedList<Node>(); // hàng đợi để duyệt các nút trong cây hoặc đồ thị
		List <Node> explored= new ArrayList<>(); // Danh sách để lưu trữ các nút đã duyệt qua
		// TODO Auto-generated method stub
	frontier.add(root); 
	while (!frontier.isEmpty() ) { 
		Node node = frontier.poll(); // lấy nút đầu tiên
		if (node.getLabel().equals(goal))
			return node;
		explored.add(node);
		List<Node> children= node.getChildrenNodes(); //lấy ds nút con của nút hiện tại để kiểm tra hoặc thêm vào hàng đợi nếu chưa duyệt
		
		for (Node child : children) { //duyệt qua các nút con
			if (!frontier.contains(child) && !explored.contains(child))
				frontier.add(child);
			child.setParent(node);
		}
	}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		Queue<Node> frontier = new LinkedList<Node>();
		List<Node> explored = new ArrayList<>();
		frontier.add(root);
		while (!frontier.isEmpty()) {
			Node node = frontier.poll();
			if (node.getLabel() == goal)
				return node;
			else {
				List<Node> children = node.getChildrenNodes();
				for (int i = children.size() - 1; i >= 0; i--) {
					Node child = children.get(i);
					if (!frontier.contains(child) && !explored.contains(child)) {
						frontier.add(child);
						child.setParent(node);
						

					}

				}
			}
		}
		
		return null;
	}

}
