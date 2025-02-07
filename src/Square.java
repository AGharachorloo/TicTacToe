import javax.swing.*;
import java.awt.*;

/**
 * A class written to support the TicTacToe Game.
 *
 * Each Square object is one position of the TicTacToe
 * board. It maintains information on the marker, its
 * location on the board, and whether it is part
 * of the winning set.
 *
 * @author: Nandhini Namasivayam
 * @version: Jan 2023
 */

public class Square {

    private String marker;
    private Image imageX, imageO;
    private int row, col;
    private boolean isWinningSquare;
    private TicTacToeViewer front;
    private static final int BOX_SIDE_LENGTH = 100;
    private static final int FIRST_X = 100;
    private static final int FIRST_Y = 100;

    /**
     * Constructor to initialize one Square of the
     * TicTacToe board
     * @param row the row the square is in
     * @param col the column the square is in
     */
    public Square(int row, int col, TicTacToeViewer front) {
        // Initialize the reference to the frontend
        this.front = front;
        this.row = row;
        this.col = col;

        this.marker = TicTacToe.BLANK;
        this.isWinningSquare = false;
        // Initialize the images
        imageX = new ImageIcon("Resources/X.png").getImage();
        imageO = new ImageIcon("Resources/O.png").getImage();
    }

    /******************** Getters and Setters ********************/
    public String getMarker() {
        return this.marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public void setWinningSquare() {
        this.isWinningSquare = true;
    }

    /**
     * Checks if the square has the BLANK marker
     * @return True if the square is empty, False otherwise
     */
    public boolean isEmpty() {
        return this.marker.equals(TicTacToe.BLANK);
    }

    /**
     * @return the marker for the square
     */
    public String toString() {
        return this.marker;
    }

    public void draw(Graphics g) {
        // If the square being drawn is one of the winning squares fill the box green
        if (this.isWinningSquare){
            g.setColor(Color.GREEN);
            g.fillRect(col * BOX_SIDE_LENGTH + FIRST_X, row * BOX_SIDE_LENGTH + FIRST_Y, 100, 100);
        }
        // Draw the image that corresponds to the marker of the square (X or O)
        if (marker.equals("X")) {
            g.drawImage(imageX,(col+1)*100, (row+1)*100, 100, 100, front);
        }
        else if (marker.equals("O")) {
            g.drawImage(imageO, (col+1)*100, (row+1)*100, 100, 100, front);
        }
    }
}
