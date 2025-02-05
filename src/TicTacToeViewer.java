import javax.swing.*;
import java.awt.*;

public class TicTacToeViewer extends JFrame {
    // TODO: Complete this class
    private static final int WINDOW_HEIGHT = 500;
    private static final int WINDOW_WIDTH = 500;
    private static final int BOX_SIDE_LENGTH = 100;
    private static final int FIRST_X = 100;
    private static final int FIRST_Y = 100;
    private static final int TEXT_X = 40;
    private static final int TEXT_Y = 73;
    private TicTacToe back;

    public TicTacToeViewer(TicTacToe back) {
        this.back = back;

        this.setTitle("TicTacToe!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        g.setColor(Color.BLACK);
        g.drawRect(FIRST_X, FIRST_Y, BOX_SIDE_LENGTH*3, BOX_SIDE_LENGTH*3);
        for (int i = 0; i < 3; i++) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString(Integer.toString(i), TEXT_X + (i+1)*BOX_SIDE_LENGTH, TEXT_Y);
            g.drawString(Integer.toString(i), TEXT_X, TEXT_Y + (i+1)*BOX_SIDE_LENGTH);
            g.setColor(Color.BLACK);
            g.drawLine(FIRST_X + (i+1)*BOX_SIDE_LENGTH, FIRST_Y, FIRST_X + (i+1)*BOX_SIDE_LENGTH, FIRST_Y + BOX_SIDE_LENGTH*3);
            g.drawLine(FIRST_X, FIRST_Y + (i+1)*BOX_SIDE_LENGTH, FIRST_X + BOX_SIDE_LENGTH*3, FIRST_Y + (i+1)*BOX_SIDE_LENGTH);
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                back.getBoard()[i][j].draw(g);
            }
        }
    }
}
