// Demonstrate a multithreading example to split some image processing task over multiple threads

// Multithreading can be achieved by two ways in java 
// 1 By implementing Runnable interface
// 2 By extending Thread class

// Let each of the 4 threads work on a different quarter of the image
public class Parallel extends Thread{//implements Runnable{

    private String threadName;
    private BufferedImage myImage; // Calling it "my" image because each thread will have its own unique quarter of the image to work on
    private int width, height; // Image params
    
    Parallel(String name, BufferedImage image){
    threadName = name;
    System.out.println("Creating "+ threadName);
    myImage = image;
    width = myImage.getWidth();
    height = myImage.getHeight();
    
    }
    
    public void run(){
    System.out.println("Running " + threadName);
    
    // Pixel by pixel (for our quarter of the image)
    for (int j = 0; j < height; j++){
        for (int i = 0; i < width; i++){
    
            // Traversing the image and converting the RGB values (doing the same thing as the sequential code but on a smaller scale)
            Color c = new Color(myImage.getRGB(i,j));
    
            int red = (int)(c.getRed() * 0.299);
            int green = (int)(c.getGreen() * 0.587);
            int blue  = (int)(c.getBlue() * 0.114);
    
            Color newColor = new Color(red + green + blue, red + green + blue, red + green + blue);
    
            myImage.setRGB(i,j,newColor.getRGB()); // Write the new value for that pixel
    
    
        }
    }
    
    File output = new File("src/pixelsmanipulation/"+threadName+"grayscale.jpg"); // Put it in a "lower level" folder so we can see it in the project view
    try {
        ImageIO.write(newImage, "jpg", output);
    } catch (IOException ex) {
        Logger.getLogger(Parallel.class.getName()).log(Level.SEVERE, null, ex);
    }
    System.out.println("Thread " + threadName + " exiting. ---");
    }
}