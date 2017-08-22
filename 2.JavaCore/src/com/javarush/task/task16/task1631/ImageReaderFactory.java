package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

/**
 * Created by drake on 21.05.17.
 */
public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes type) {
        if (type == ImageTypes.JPG)
            return new JpgReader();
        else if (type == ImageTypes.BMP)
            return new BmpReader();
        else if (type == ImageTypes.PNG)
            return new PngReader();
        else throw new IllegalArgumentException("Неизвестный тип картинки");
    }
}
