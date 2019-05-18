package wargame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import wargame.Menu;
import wargame.Hexagons.Hexagon;

public class AfficheGrid {

	public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		//Interface I =new Interface();
	}*/


		  final int width = 50;
	        final int height = 50;
	        final Hexagon[][] grid = new Hexagon[height][width];
	        for(int row = 0; row < height; row++) {
	            for(int col = 0; col < width; col++) {
	                grid[row][col] = new Hexagon(row, col, 50);
	            }
	        }

	        JFrame f = new JFrame("Hexagons");
	        f.getContentPane().setLayout(new GridLayout());
	        f.getContentPane().add(new JComponent() {
	          @Override public void paint(Graphics g) {
	            g.setColor(new Color(0xFF, 0xFF, 0xFF));
	            g.fillRect(0,0,getWidth(),getHeight());
	            g.setColor(new Color(0,0,0));
	            final int[] xs = new int[6];
	            final int[] ys = new int[6];
	            for (Hexagon[] row : grid) {
	              for (Hexagon h: row) {
	                final int[] i = {0};
	                h.foreachVertex((x, y) -> {
	                  xs[i[0]] = (int)((double)x);
	                  ys[i[0]] = (int)((double)y);
	                  i[0]++;
	                });
	                g.drawPolygon(xs, ys, 6);

	              
	              }
	            }
	          }
	        });
	        f.setBounds(0, 0, 500, 500);
	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        f.setVisible(true);
	        try {
	            Thread.sleep(100);
	        } catch (Throwable e) {

	        } finally {
	            f.repaint();
	        }
	    }
	}