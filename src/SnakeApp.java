import java.awt.*;
import javax.swing.*;

public class SnakeApp implements Runnable {
	private GameView gameView;
	private Grid grid;
	private GameController gameController;
	
	@Override
	public void run() {
		// 初始化grid
		grid = new Grid(56, 40);
        // 创建游戏窗体
        JFrame window = new JFrame("贪吃蛇");

		// 设置窗口大小
		window.setPreferredSize(new Dimension(840, 630));
        // 画出棋盘和贪吃蛇
        Container contentPane = window.getContentPane();
        
        // 基于Grid初始化gamaView
        gameView = new GameView(grid);
        gameView.init();
        
        gameController = new GameController(grid, gameView);
        
        // 设置gameView中JPanel的大小
        gameView.getCanvas().setPreferredSize(new Dimension(Settings.DEFAULT_GRID_WIDTH, Settings.DEFAULT_GRID_HEIGHT));
        
        // 将gameView中JPanel加入到窗口中
        contentPane.add(gameView.getCanvas(), BorderLayout.CENTER);

        // 渲染窗口
        window.pack();
        // 设置窗口为大小不可变化
        window.setResizable(false);
        // 窗口关闭的行为
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 显示窗口
        window.setVisible(true);
        
        //注册GameController
        window.addKeyListener(gameController);
        
        //启动线程
        new Thread(gameController).start();
    }


	public static void main(String[] args) {
		SwingUtilities.invokeLater(new SnakeApp());
    }
	
	
}
