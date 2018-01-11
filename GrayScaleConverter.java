
/**
 * Covert batch images to greyscale and save copy of each
 * 
 * @Roxana Moldovan
 * @1.0 7/15/2017
 */
import edu.duke.*;
import java.io.*;

public class GrayScaleConverter {
public ImageResource makeGray(ImageResource inImage){
    ImageResource outImage = new ImageResource (inImage.getWidth(), inImage.getHeight());
    
    for (Pixel pixel:outImage.pixels()){
    Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
    int average = (pixel.getRed()+pixel.getGreen()+pixel.getBlue())/3;
    pixel.setRed(average);
    pixel.setGreen(average);
    pixel.setBlue(average); 
}
     return outImage;  
       

}
public void testGray(){
    ImageResource ir = new ImageResource();
    ImageResource gray = makeGray(ir);
    gray.draw();

}
}

