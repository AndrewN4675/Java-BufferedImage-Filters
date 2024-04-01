package effects_pkg;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

abstract class Effect {

    //VARIABLES
    protected String newPath;//saves the file location
    protected BufferedImage outputImage;
    protected File file;

    //FUNCTIONS
    public abstract BufferedImage process(BufferedImage inputImage, boolean newFile);
    public abstract BufferedImage process(boolean newFile);

    protected static void setUIStyle(){
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");//will make the JFileChooser look like Windows 11 or 10
        } catch (Exception e) {// handle exception
        }
    }

    protected File getFile() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) { //shows the file finder that allows you to go through files
            return fileChooser.getSelectedFile();
        }
        return null;
    }

    protected void createNewPng()  {
        try {
            ImageIO.write(this.outputImage, "png", new File(newPath)); //work on it creating a new file with the
            //name of the file + dithered and in the same folder that the original one was in. png or jpg
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}