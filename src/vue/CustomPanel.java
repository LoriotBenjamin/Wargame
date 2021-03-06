package vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

/**
 * CustomPanel est un classe fille de JPanel pour pouvoir mettre un fond au Menu.
 * @author Stefano
 *
 */
public class CustomPanel extends JPanel {
    /**
     * serialversionUID.
     */
    private static final long serialVersionUID = -4608335470555981006L;
    /**
     * Image de fond du Menu.
     */
    private Image image = null;
    /**
     * Largeur de l'image de fond.
     */
    private int width;
    /**
     * Hauteur de l'image de fond.
     */
    private int height;

    /**
     * Constructeur de la la classe CustomPanel.
     * @param image image de fond.
     */
    public CustomPanel(final Image image) {
        this.image = image;
        this.width = image.getWidth(this) / 2;
        this.height = image.getHeight(this) / 2;
    }

    @Override
    /**
     * PaintComponent est une fonction qui est appelée automatiquement lors de la
     * création de l'objet.
     */
    public void paintComponent(final Graphics g) {
        super.paintComponent(g);
        setBackground(new Color(0, 128, 128));
        if (image != null) {
            int x = this.getParent().getWidth() / 2 - width;
            int y = this.getParent().getHeight() / 2 - height;
            g.drawImage(image, x, y, this);
        }
    }
}
