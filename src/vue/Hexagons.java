package wargame;

import java.awt.Container;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.function.*;

public class Hexagons extends JPanel {

    private static final long serialVersionUID = 1L;

    /** Height of an equilateral triangle with side length = 1 */
    private static final double H = Math.sqrt(3) / 2;

    static class Hexagon {
      final int row;
      final int col;
      final double sideLength;
      public Hexagon(int r, int c, double a) {
        this.row = r;
        this.col = c;
        this.sideLength = a;
      }

      double getCenterX() {
        return 2 * H * sideLength * (col + (row % 2) * 0.5);
      }

      double getCenterY() {
        return 3 * sideLength / 2  * row;
      }

      void foreachVertex(BiConsumer<Double, Double> f) {
        double cx = getCenterX();
        double cy = getCenterY();
        f.accept(cx + 0, cy + sideLength);
        f.accept(cx - H * sideLength, cy + 0.5 * sideLength);
        f.accept(cx - H * sideLength, cy - 0.5 * sideLength);
        f.accept(cx + 0, cy - sideLength);
        f.accept(cx + H * sideLength, cy - 0.5 * sideLength);
        f.accept(cx + H * sideLength, cy + 0.5 * sideLength);
      }}}
    

   
      