import java.awt.*;
import javax.swing.*;

public class SnakeApp implements Runnable {
	private GameView gameView;
	private Grid grid;
	private GameController gameController;
	
	@Override
	public void run() {
		// ��ʼ��grid
		grid = new Grid(56, 40);
        // ������Ϸ����
        JFrame window = new JFrame("̰����");

		// ���ô��ڴ�С
		window.setPreferredSize(new Dimension(840, 630));
        // �������̺�̰����
        Container contentPane = window.getContentPane();
        
        // ����Grid��ʼ��gamaView
        gameView = new GameView(grid);
        gameView.init();
        
        gameController = new GameController(grid, gameView);
        
        // ����gameView��JPanel�Ĵ�С
        gameView.getCanvas().setPreferredSize(new Dimension(Settings.DEFAULT_GRID_WIDTH, Settings.DEFAULT_GRID_HEIGHT));
        
        // ��gameView��JPanel���뵽������
        contentPane.add(gameView.getCanvas(), BorderLayout.CENTER);

        // ��Ⱦ����
        window.pack();
        // ���ô���Ϊ��С���ɱ仯
        window.setResizable(false);
        // ���ڹرյ���Ϊ
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // ��ʾ����
        window.setVisible(true);
        
        //ע��GameController
        window.addKeyListener(gameController);
        
        //�����߳�
        new Thread(gameController).start();
    }


	public static void main(String[] args) {
		SwingUtilities.invokeLater(new SnakeApp());
    }
	
	
}
