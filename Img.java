package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

public class Img {
    public static Image loadImage() {
        String URL = "http://www.google.ru/intl/en_com/images/logo_plain.png";
        try {
            String fileName = "google.png";
            BufferedImage img = ImageIO.read(new URL(URL));
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            ImageIO.write(img, "png", file);
            return img;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
