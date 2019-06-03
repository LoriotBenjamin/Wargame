package vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * PaintImage est une classe qui peint une image de l'unité sélectionnée.
 * @author Stefano
 *
 */
public class PaintImage extends JPanel {
    /**
     * Numéro de serial Version.
     */
    private static final long serialVersionUID = -395107005457886722L;
    /**
     * Image que l'on veut peindre.
     */
    private static BufferedImage image;

    /**
     * Image que l'on veut peindre.
     * @param path chemin de l'image.
     */
    public PaintImage(final String path) {
        super();
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lit l'image du fichier.
     * @param path Chemin de l'image.
     */
    public void setImage(final String path) {
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    /**
     * Fonction appelée automatiquement à la création de l'objet.
     */
    public void paintComponent(final Graphics g) {
        Color coul = new Color(255, 255, 255);
        g.drawImage(image, 0, 0, coul, null);
        repaint();
    }

}
