import javax.swing.*;
import java.awt.*;

public class GameView {
	private final Grid grid;
	private JPanel canvas;


    public GameView(Grid grid) {
        this.grid = grid;
    }

    public void draw(Graphics graphics) {
        drawGridBackground(graphics);
        drawSnake(graphics, grid.getSnake());
        drawFood(graphics, grid.getFood());
    }

    public void drawSnake(Graphics graphics, Snake snake) {
    	for(Node iter : snake.getBody()){
    		drawSquare(graphics, iter, Color.WHITE);
    	}
    }

    public void drawFood(Graphics graphics, Node squareArea) {
    	drawCircle(graphics, squareArea, Color.BLUE);
    }

    public void drawGridBackground(Graphics graphics) {
    	graphics.setColor(Color.BLACK);
    	graphics.fillRect(0, 0, Settings.DEFAULT_GRID_WIDTH - 1, Settings.DEFAULT_GRID_HEIGHT - 1);
    }
    
    private void drawSquare(Graphics graphics, Node squareArea, Color color) {
        graphics.setColor(color);
        int size = Settings.DEFAULT_NODE_SIZE;
        graphics.fillRect(squareArea.getX() * size, squareArea.getY() * size, size - 1, size - 1);
    }


    private void drawCircle(Graphics graphics, Node squareArea, Color color) {
        graphics.setColor(color);
        int size = Settings.DEFAULT_NODE_SIZE;
        graphics.fillOval(squareArea.getX() * size, squareArea.getY() * size, size, size);
    }
    
    public void init() {
        canvas = new JPanel() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            public void paintComponent(Graphics graphics) {
                drawGridBackground(graphics);
                drawSnake(graphics, grid.getSnake());
                drawFood(graphics, grid.getFood());
            }
        };
    }

    public void draw() {
        canvas.repaint();
    }
    
    public JPanel getCanvas() {
        return canvas;
    }
    
    public void showGameOverMessage() {
        JOptionPane.showMessageDialog(null, "游戏结束", "游戏结束", JOptionPane.INFORMATION_MESSAGE);
    }
}
