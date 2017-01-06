import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameController implements KeyListener, Runnable{
	private Grid grid;
	private GameView gameView; 
	
	private boolean running;
	@Override  
    public void keyPressed(KeyEvent e) {  
        int keyCode = e.getKeyCode();  
        if (keyCode == KeyEvent.VK_UP) {
        	grid.changeDirection(Direction.UP); 
        } else if (keyCode == KeyEvent.VK_DOWN) {  
        	grid.changeDirection(Direction.DOWN);  
        } else if (keyCode == KeyEvent.VK_LEFT) {  
        	grid.changeDirection(Direction.LEFT);
        } else if (keyCode == KeyEvent.VK_RIGHT) {  
        	grid.changeDirection(Direction.RIGHT);
        }  
        
        //repaint
        
    }  
	
    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    
    public GameController(Grid grid, GameView gameView) {
		// TODO Auto-generated constructor stub
    	this.grid = grid;
    	this.gameView = gameView;
    	running = true;
	}
    
    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(Settings.DEFAULT_MOVE_INTERVAL);
            } catch (InterruptedException e) {
                break;
            }
            // 进入游戏下一步
               running = grid.nextRound();
            	gameView.draw();
            // 如果结束，则退出游戏
            // 如果继续，则绘制新的游戏页面
        }
        gameView.showGameOverMessage();
        running = false;
    }
}
