import java.util.LinkedList;

public class Snake {
	private LinkedList<Node> body = new LinkedList<>();
	public Node eat(Node food) {

        // 如果food与头部相邻，则将food这个Node加入到body中，返回food
        // 否则不做任何操作，返回null
        if (isNeighbor(body.getFirst(), food)) {
        	// 相邻情况下的处理
        	return food;
        }
        return null;
    }
	
    private boolean isNeighbor(Node a, Node b) {
        return Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY()) == 1;
    }

    public Node move(Direction direction) {
    	Node node;
        // 根据方向更新贪吃蛇的body
        // 返回移动之前的尾部Node
    	switch(direction){
    	case UP:
    		node = new Node(getHead().getX(), getHead().getY() - 1);
    		body.addFirst(node);
    		node=getBody().getLast();
    		body.removeLast();
    		return node;
    	case DOWN:
    		node = new Node(getHead().getX(), getHead().getY() + 1);
    		body.addFirst(node);
    		node=getBody().getLast();
    		body.removeLast();
    		return node;
    	case LEFT:
    		node = new Node(getHead().getX() - 1, getHead().getY());
    		body.addFirst(node);
    		node=getBody().getLast();
    		body.removeLast();
    		return node;
    	case RIGHT:
    		node = new Node(getHead().getX() + 1, getHead().getY());
    		body.addFirst(node);
    		node=getBody().getLast();
    		body.removeLast();
    		return node;
    	}
    	return null;
    }

    public Node getHead() {
        return body.getFirst();
    }

    public Node addTail(Node area) {
        this.body.addLast(area);
        return area;
    }

    public LinkedList<Node> getBody() {
        return body;
    }
    
    public boolean containNode(Node node) {
    	for(Node iter : body){
    		if(iter.getX() == node.getX() && iter.getY() == node.getY()){
    			return true;
    		}
    	}
    	return false;
    }

}
