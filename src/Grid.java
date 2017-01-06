import java.util.Random;

public class Grid {
	 private final int width;
	 private final int height;
	 public final boolean status[][];
	 
	 private Snake snake;
	 private Node food;
	 
	 private Direction snakeDirection = Direction.RIGHT;
	 
	 public Grid(int width, int height) {
	      this.width = width;
	      this.height = height;
	      status = new boolean[width][height];
	      initSnake();
	      createFood();
	 }
	 
	 private Snake initSnake() {
	      snake = new Snake();
	      Node node;
	      // ����Snake��Body
	      // �������̸���״̬
	      for(int i = width / 3; i >= 0; i--){
	    	  node = new Node(i, height / 2); 
	    	  snake.addTail(node);
	    	  status[i][height / 2] = true;
	      }
	      return snake;
	 }
	    
	 public Node createFood() {
		    int x, y;

		    // ʹ��Random����x��y
		    do {
		    Random random = new Random();
		    x = (int)random.nextInt(width-1);
		    y = (int)random.nextInt(height-1);
		    food = new Node(x, y);
		    }while(status[x][y]);
		    return food;
		}
	 
	 public boolean nextRound() {

		   Node moveReturn;
		    //����ǰ�����ƶ�̰����
		    //��������״̬��������Ϸ�Ƿ�����ı�־
		   moveReturn = snake.move(this.snakeDirection);

		    if (headValid()) {
		        if (headIsFood()) {
		        	//��moveɾ���Ŀո�ӻ���
		            snake.addTail(moveReturn);
		            //����һ���µ�ʳ��
		            food = createFood();
		            status[snake.getHead().getX()][snake.getHead().getY()] = true;
		        } else{
		        	status[snake.getHead().getX()][snake.getHead().getY()] = true;
		        	status[moveReturn.getX()][moveReturn.getY()] = false;
		        }
		        return true;
			}else{
				System.out.println("Game over");
				return false;
			}
		}
	 
	 public void changeDirection(Direction newDirection) {
		    if (!snakeDirection.compatibleWith(newDirection)) {
		    	if(Math.abs(snakeDirection.directionCode()-newDirection.directionCode()) != 2)
		        snakeDirection = newDirection;
		    }
		}
	 
	 public Snake getSnake(){
		 return this.snake;
	 }
	 
	 public Node getFood(){
		 return this.food;
	 }
	 private boolean headValid(){
		 if(snake.getHead().getX() < width && snake.getHead().getY() < height && snake.getHead().getX() >= 0 && snake.getHead().getY() >= 0 && !status[snake.getHead().getX()][snake.getHead().getY()]){
			 return true;
		 }
		 else{
			 return false;
		 }
	 }
	 
	 private boolean headIsFood(){
		 if(snake.getHead().getX() == food.getX() && snake.getHead().getY() == food.getY()){
			 return true;
		 }else{
			 return false;
		 }
	 }
	 
}
