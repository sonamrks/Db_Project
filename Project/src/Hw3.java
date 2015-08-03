import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Hw3{
JFrame mainframe;
private final ButtonGroup buttonGroup = new ButtonGroup();
static ImagePanel ImPanel;
static ImagePanel2 ImPanel2;
static ImagePanel3 ImPanel3;
static ImagePanel4 ImPanel4;
static RImagePanel2 RImPanel2;
public static int x,y;
static JTextPane txtpnXy;
private final ButtonGroup buttonGroup_1 = new ButtonGroup();

public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
    	  new Hw3();
      }
  });
}

public Hw3() {
    mainframe = new JFrame();
    mainframe.setTitle("Kamala Sonam Rudraraju (W1079642)");
    mainframe.setBounds(1070,820,1070,820);
    mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainframe.setVisible(true); 
    
    ImPanel=new ImagePanel();
    JPanel buttonPanel=new JPanel();
    
    /* Adding Text */	
	final JTextArea textArea=new JTextArea("Your submitted query should be displayed here");
	textArea.setRows(4);
	textArea.setEditable ( false );
	JScrollPane textscroll = new JScrollPane (textArea);
    textscroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
    
    mainframe.getContentPane().add(textscroll, BorderLayout.SOUTH);
    
    buttonPanel.setPreferredSize(new Dimension(250,200));

  	JTextPane txtpnActiveFeatureType = new JTextPane();
	txtpnActiveFeatureType.setBackground(Color.LIGHT_GRAY);
	txtpnActiveFeatureType.setFont(new Font("Dialog", Font.BOLD, 18));
	txtpnActiveFeatureType.setText("Active Feature Type");
	    
    final JCheckBox chckbxNewCheckBox = new JCheckBox("Building");
    buttonGroup_1.add(chckbxNewCheckBox);
    chckbxNewCheckBox.setFont(new Font("Dialog", Font.BOLD, 16));
    
       
    final JCheckBox chckbxPhoto = new JCheckBox("Photo");
    buttonGroup_1.add(chckbxPhoto);
    chckbxPhoto.setFont(new Font("Dialog", Font.BOLD, 16));
    
    final JCheckBox chckbxPhotographer = new JCheckBox("Photographer");
    buttonGroup_1.add(chckbxPhotographer);
    chckbxPhotographer.setFont(new Font("Dialog", Font.BOLD, 16));
    
    JTextPane txtpnQuery = new JTextPane();
    txtpnQuery.setFont(new Font("Dialog", Font.BOLD, 18));
    txtpnQuery.setBackground(Color.LIGHT_GRAY);
    txtpnQuery.setText("Query");
    
	final JRadioButton rdbtnWholeQuery = new JRadioButton("Whole Region", false);
	buttonGroup.add(rdbtnWholeQuery);
	rdbtnWholeQuery.setFont(new Font("Dialog", Font.BOLD, 16));

	   ItemListener itemListener0 = new ItemListener() {
		      public void itemStateChanged(ItemEvent e) {
		    	  if (e.getStateChange() == ItemEvent.SELECTED) {
		    		  
					   ItemListener itemListener1 = new ItemListener() {
						      public void itemStateChanged(ItemEvent e) {
						    	  if (e.getStateChange() == ItemEvent.SELECTED) {
						        textArea.setText("SELECT b.shape.Get_WKT() FROM buildings b;");
						    	   ImPanel2=new ImagePanel2();
						    	   mainframe.getContentPane().remove(ImPanel);
						    	   mainframe.getContentPane().add(ImPanel2, BorderLayout.CENTER);
						    	   mainframe.validate();
						    	   mainframe.repaint();
						    	  }
						    	  else if (e.getStateChange() == ItemEvent.DESELECTED) {
								        textArea.setText("Your submitted query should be displayed here");
								    	   mainframe.getContentPane().remove(ImPanel2);
								    	   mainframe.getContentPane().add(ImPanel, BorderLayout.CENTER);
								    	   mainframe.validate();
								    	   mainframe.repaint();
								    	  }
						      }
						    };
						    chckbxNewCheckBox.addItemListener(itemListener1);
		    		  
	   ItemListener itemListener2 = new ItemListener() {
		      public void itemStateChanged(ItemEvent e) {
		    	  if (e.getStateChange() == ItemEvent.SELECTED) {
		        textArea.setText("SELECT p.shape.Get_WKT() FROM photos p;");
		    	   ImPanel3=new ImagePanel3();
		    	   mainframe.getContentPane().remove(ImPanel);
		    	   mainframe.getContentPane().add(ImPanel3, BorderLayout.CENTER);
		    	   mainframe.validate();
		    	   mainframe.repaint();
		    	  }
		    	  else if (e.getStateChange() == ItemEvent.DESELECTED) {
				        textArea.setText("Your submitted query should be displayed here");
				    	   mainframe.getContentPane().remove(ImPanel3);
				    	   mainframe.getContentPane().add(ImPanel, BorderLayout.CENTER);
				    	   mainframe.validate();
				    	   mainframe.repaint();
				    	  }
		      }
		    };
		    chckbxPhoto.addItemListener(itemListener2);
		    
			    
					   ItemListener itemListener3 = new ItemListener() {
						      public void itemStateChanged(ItemEvent e) {
						    	  if (e.getStateChange() == ItemEvent.SELECTED) {
						        textArea.setText("SELECT pg.shape.Get_WKT() FROM photographers pg;");
						    	   ImPanel4=new ImagePanel4();
						    	   mainframe.getContentPane().remove(ImPanel);
						    	   mainframe.getContentPane().add(ImPanel4, BorderLayout.CENTER);
						    	   mainframe.validate();
						    	   mainframe.repaint();
						    	  }
						    	  else if (e.getStateChange() == ItemEvent.DESELECTED) {
								        textArea.setText("Your submitted query should be displayed here");
								    	   mainframe.getContentPane().remove(ImPanel4);
								    	   mainframe.getContentPane().add(ImPanel, BorderLayout.CENTER);
								    	   mainframe.validate();
								    	   mainframe.repaint();
								    	  }
						      }
						    };
						    chckbxPhotographer.addItemListener(itemListener3);    
		    	  }
      }
    };
    rdbtnWholeQuery.addItemListener(itemListener0);
    

    final JRadioButton rdbtnRangeQuery = new JRadioButton("Range Query");
    buttonGroup.add(rdbtnRangeQuery);
    rdbtnRangeQuery.setFont(new Font("Dialog", Font.BOLD, 16));
    
	   ItemListener itemListener4 = new ItemListener() {
		      public void itemStateChanged(ItemEvent e) {
		    	  if (e.getStateChange() == ItemEvent.SELECTED) {
		    			    		  
		    						   ItemListener itemListener5 = new ItemListener() {
		    							      public void itemStateChanged(ItemEvent e) {
		    							    	  if (e.getStateChange() == ItemEvent.SELECTED) {
		    							        textArea.setText("SELECT b.shape.Get_WKT() from buildings b WHERE SDO_RELATE(b.shape,SDO_GEOMETRY(2003,NULL,NULL,SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY(469,157,325,269,381,445,540,370,551,151,469,157)),'mask=anyinteract')='TRUE';");
		    							    	   RImPanel2=new RImagePanel2();
		    							    	   mainframe.getContentPane().remove(ImPanel);
		    							    	   mainframe.getContentPane().add(RImPanel2, BorderLayout.CENTER);
		    							    	   mainframe.validate();
		    							    	   mainframe.repaint();
		    							    	  }
		    							      }
		    						    };	    							    	  
		    						    chckbxNewCheckBox.addItemListener(itemListener5);    		  
		    	  }
		      }
    };
    rdbtnRangeQuery.addItemListener(itemListener4);
    
    JRadioButton rdbtnPointquery = new JRadioButton("Point Query");
    buttonGroup.add(rdbtnPointquery);
    rdbtnPointquery.setFont(new Font("Dialog", Font.BOLD, 16));
    
    JRadioButton rdbtnFindPhotos = new JRadioButton("Find Photos");
    buttonGroup.add(rdbtnFindPhotos);
    rdbtnFindPhotos.setFont(new Font("Dialog", Font.BOLD, 16));
    
    JRadioButton rdbtnFindPhotographers = new JRadioButton("Find Photographers");
    buttonGroup.add(rdbtnFindPhotographers);
    rdbtnFindPhotographers.setFont(new Font("Dialog", Font.BOLD, 16));
    
    JButton btnSubmitt = new JButton("Submit");
    btnSubmitt.setFont(new Font("Dialog", Font.BOLD, 16));
    
    JButton btnQuery = new JButton("Query");
    btnQuery.setFont(new Font("Dialog", Font.BOLD, 16));
    
    JTextPane txtpnCoordinates = new JTextPane();
    txtpnCoordinates.setBackground(Color.LIGHT_GRAY);
    txtpnCoordinates.setFont(new Font("Dialog", Font.BOLD, 14));
    txtpnCoordinates.setText("Coordinates");
    
    txtpnXy = new JTextPane();
    txtpnXy.setFont(new Font("Dialog", Font.PLAIN, 16));
    txtpnXy.setBackground(Color.CYAN);
    GroupLayout gl_buttonPanel = new GroupLayout(buttonPanel);
    gl_buttonPanel.setHorizontalGroup(
    	gl_buttonPanel.createParallelGroup(Alignment.LEADING)
    		.addGroup(gl_buttonPanel.createSequentialGroup()
    			.addGroup(gl_buttonPanel.createParallelGroup(Alignment.LEADING)
    				.addGroup(gl_buttonPanel.createSequentialGroup()
    					.addContainerGap()
    					.addComponent(chckbxPhoto)
    					.addGap(4)
    					.addComponent(chckbxPhotographer))
    				.addGroup(gl_buttonPanel.createSequentialGroup()
    					.addGap(20)
    					.addGroup(gl_buttonPanel.createParallelGroup(Alignment.LEADING)
    						.addGroup(gl_buttonPanel.createSequentialGroup()
    							.addGap(12)
    							.addComponent(txtpnXy, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
    						.addComponent(txtpnCoordinates, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
    						.addComponent(txtpnActiveFeatureType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
    				.addGroup(gl_buttonPanel.createSequentialGroup()
    					.addContainerGap()
    					.addComponent(btnSubmitt)
    					.addGap(18)
    					.addComponent(btnQuery))
    				.addGroup(gl_buttonPanel.createSequentialGroup()
    					.addContainerGap()
    					.addComponent(rdbtnFindPhotos))
    				.addGroup(gl_buttonPanel.createSequentialGroup()
    					.addContainerGap()
    					.addComponent(rdbtnPointquery))
    				.addGroup(gl_buttonPanel.createSequentialGroup()
    					.addContainerGap()
    					.addComponent(rdbtnRangeQuery))
    				.addGroup(gl_buttonPanel.createSequentialGroup()
    					.addContainerGap()
    					.addComponent(rdbtnFindPhotographers))
    				.addGroup(gl_buttonPanel.createSequentialGroup()
    					.addContainerGap()
    					.addComponent(rdbtnWholeQuery))
    				.addGroup(gl_buttonPanel.createSequentialGroup()
    					.addGap(31)
    					.addComponent(txtpnQuery, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
    				.addGroup(gl_buttonPanel.createSequentialGroup()
    					.addContainerGap()
    					.addComponent(chckbxNewCheckBox)))
    			.addContainerGap(9, Short.MAX_VALUE))
    );
    gl_buttonPanel.setVerticalGroup(
    	gl_buttonPanel.createParallelGroup(Alignment.LEADING)
    		.addGroup(gl_buttonPanel.createSequentialGroup()
    			.addGap(7)
    			.addComponent(txtpnCoordinates, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
    			.addPreferredGap(ComponentPlacement.UNRELATED)
    			.addComponent(txtpnXy, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
    			.addGap(46)
    			.addComponent(txtpnActiveFeatureType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
    			.addGap(18)
    			.addComponent(chckbxNewCheckBox)
    			.addPreferredGap(ComponentPlacement.UNRELATED)
    			.addGroup(gl_buttonPanel.createParallelGroup(Alignment.LEADING)
    				.addComponent(chckbxPhotographer)
    				.addComponent(chckbxPhoto))
    			.addGap(29)
    			.addComponent(txtpnQuery, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
    			.addGap(18)
    			.addComponent(rdbtnWholeQuery)
    			.addPreferredGap(ComponentPlacement.UNRELATED)
    			.addComponent(rdbtnRangeQuery)
    			.addPreferredGap(ComponentPlacement.UNRELATED)
    			.addComponent(rdbtnPointquery)
    			.addGap(4)
    			.addComponent(rdbtnFindPhotos)
    			.addPreferredGap(ComponentPlacement.UNRELATED)
    			.addComponent(rdbtnFindPhotographers)
    			.addGap(26)
    			.addGroup(gl_buttonPanel.createParallelGroup(Alignment.BASELINE)
    				.addComponent(btnSubmitt)
    				.addComponent(btnQuery))
    			.addContainerGap())
    );
    buttonPanel.setLayout(gl_buttonPanel);
    
    mainframe.getContentPane().add(buttonPanel, BorderLayout.EAST);
    mainframe.getContentPane().add(ImPanel, BorderLayout.CENTER);

    ImPanel.addMouseMotionListener(new MouseMotionAdapter(){
    	public void mouseMoved(MouseEvent e){
    		x=e.getX();
    		y=e.getY();
    	    txtpnXy.setText("x=" + x + " y=" + y);
    	}
    });
}
}