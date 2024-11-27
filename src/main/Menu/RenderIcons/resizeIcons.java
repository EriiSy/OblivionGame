package main.Menu.RenderIcons;

import javax.swing.ImageIcon;
import java.awt.Image;
import java.net.URL;

public class resizeIcons {
    
    public ImageIcon resizeIcon(String path, int width, int height) {
        URL resource = getClass().getResource(path);
        if (resource == null) {
            System.out.println("Resource not found: " + path);
            return null;
        }
        ImageIcon icon = new ImageIcon(resource);
        Image img = icon.getImage();
        Image resizedImg = img.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        System.out.println("Icon resized: " + path);
        return new ImageIcon(resizedImg);
    }

}
