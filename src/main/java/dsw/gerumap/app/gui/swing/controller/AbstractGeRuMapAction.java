package dsw.gerumap.app.gui.swing.controller;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;

public abstract class AbstractGeRuMapAction extends AbstractAction {

    public Icon loadIcon(String fileName){

        URL imageURL = getClass().getResource(fileName);
        Icon icon = null;

        if (imageURL != null) {
            icon = new ImageIcon(imageURL){
                @Override
                public int getIconHeight() {
                    return 30;
                }

                @Override
                public int getIconWidth() {
                    return 30;
                }

                @Override
                public synchronized void paintIcon(Component c, Graphics g, int x, int y) {
                    g.drawImage(getImage(), x, y, 30, 30, null);
                }
            };
            // Image image = ((ImageIcon)icon).getImage();
            // Image newImage = image.getScaledInstance(30, 30, Image.SCALE_FAST);
            // icon = new ImageIcon(newImage);
        }
        else {
            System.err.println("Resource not found: " + fileName);
        }
        return icon;
    }

}
