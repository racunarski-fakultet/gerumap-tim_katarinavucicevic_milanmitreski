package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.AppCore;
import dsw.gerumap.app.message.MessageType;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public abstract class AbstractGeRuMapAction extends AbstractAction {

    public Icon loadIcon(String fileName){

        URL imageURL = getClass().getResource(fileName);
        Icon icon = null;

        if (imageURL != null) {
            icon = new ImageIcon(imageURL){
                @Override
                public int getIconHeight() {
                    return 25;
                }

                @Override
                public int getIconWidth() {
                    return 25;
                }

                @Override
                public synchronized void paintIcon(Component c, Graphics g, int x, int y) {
                    g.drawImage(getImage(), x, y, 25, 25, null);
                }
            };
        }
        else {
            AppCore.getInstance().getMessageGenerator().getMessage("Resource " + fileName + "not found", MessageType.RESOURCE_NOT_FOUND);
        }
        return icon;
    }

}
