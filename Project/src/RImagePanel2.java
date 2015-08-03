import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class RImagePanel2 extends JPanel{

	private static final long serialVersionUID = 1L;
	
	BufferedImage myPicture=null;

	public RImagePanel2(){
		
	/* Adding Image */	
	try {
	myPicture = ImageIO.read(new File("/dbhome/product/11.2.0/dbhome_1/son/hw2_data/map.JPG"));
	}
	catch (IOException ex) {
        ex.getMessage();
        
    }

}
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    	g.drawImage(myPicture,0,0,820,580,this);
    	g.setColor(Color.yellow);

    	RangeQuery rq=new RangeQuery();
    	  ArrayList<String> s=rq.Count();
    	  
    	  for(int i=0;i<s.size();i++){
    	      String st=s.get(i);
    	  
    	    int[] x=null;  
        	int[] y=null;  
    	
			x=rq.xValues(st);
			y=rq.yValues(st);
			g.drawPolygon(x, y, x.length);
    	  }
        }
}

