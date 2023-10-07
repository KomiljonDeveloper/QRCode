package com.example.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class QRCode {
    public static void main(String[] args) {

        int width= 500;
        int height = 500;
        String qrCodeText = "Komiljon";
        String fileType = "png";

        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(qrCodeText, BarcodeFormat.QR_CODE,
                    width, height);

            BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

            for (int x = 0; x <width; x++) {
                for (int y = 0; y < height; y++) {
                    bufferedImage.setRGB(x, y, bitMatrix.get(x, y)? Color.BLACK.getRGB(): Color.WHITE.getRGB());
                }
            }

            File qrCodeFile = new File( "QRCode." + fileType);
            ImageIO.write(bufferedImage, fileType, qrCodeFile);

            System.out.println("QR kod muvaffaqiyatli yaratildi: " + qrCodeFile.getAbsolutePath());

        } catch (Exception e) {

            System.out.println("QR kod yaratishda xatolik yuz berdi: " + e.getMessage());

        }
    }
}
