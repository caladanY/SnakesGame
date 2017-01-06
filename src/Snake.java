import java.util.LinkedList;

public class Snake {
	private LinkedList<Node> body = new LinkedList<>();
	public Node eat(Node food) {

        // ���food��ͷ�����ڣ���food���Node���뵽body�У�����food
        // �������κβ���������null
        if (isNeighbor(body.getFirst(), food)) {
        	// ��������µĴ���
        	return food;
        }
        return null;
    }
	
    private boolean isNeighbor(Node a, Node b) {
        return Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY()) == 1;
    }

    public Node move(Direction direction) {
    	Node node;
        // ���ݷ������̰���ߵ�body
        // �����ƶ�֮ǰ��β��Node
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
