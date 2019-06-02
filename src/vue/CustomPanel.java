package vue;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class CustomPanel extends JPanel {
	private static final long serialVersionUID = -4608335470555981006L;
	private Image image = null;
	private int width;
	private int height;

	public CustomPanel(Image image) {
		this.image = image;
		this.width = image.getWidth(this) / 2;
		this.height = image.getHeight(this) / 2;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (image != null) {
			int x = this.getParent().getWidth() / 2 - width;
			int y = this.getParent().getHeight() / 2 - height;
			g.drawImage(image, x, y, this);
		}
	}
}
