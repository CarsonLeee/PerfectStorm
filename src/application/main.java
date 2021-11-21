package important;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.*;

public class main {
    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
    
    public static void addComponentsToPane(Container pane) throws Exception {
    	

        ImageIcon timerjpg = new ImageIcon(new ImageIcon("src/resources/timer.jpg").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        ImageIcon playjpg = new ImageIcon(new ImageIcon("src/resources/play.jpg").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        ImageIcon resetjpg = new ImageIcon(new ImageIcon("src/resources/reset.jpg").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));

        ImageIcon rainjpg = new ImageIcon(new ImageIcon("src/resources/rain.jpg").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        ImageIcon windjpg = new ImageIcon(new ImageIcon("src/resources/wind.jpg").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        ImageIcon birdsjpg = new ImageIcon(new ImageIcon("src/resources/birds.jpg").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        ImageIcon thunderjpg = new ImageIcon(new ImageIcon("src/resources/thunder.jpg").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        ImageIcon cicadajpg = new ImageIcon(new ImageIcon("src/resources/cicada.jpg").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        ImageIcon staticjpg = new ImageIcon(new ImageIcon("src/resources/static.jpg").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        ImageIcon fireplacejpg = new ImageIcon(new ImageIcon("src/resources/fireplace.jpg").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));       
        ImageIcon frogsjpg = new ImageIcon(new ImageIcon("src/resources/frog.jpg").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        
        Sound rainwav = new Sound();
        Sound frogswav = new Sound();
        Sound fireplacewav = new Sound();
        Sound windwav = new Sound();
        Sound thunderwav = new Sound();
        Sound staticwav = new Sound();
        Sound birdswav = new Sound();
        Sound cicadaswav = new Sound();
        
        
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
	
	//play button
	JButton play = new JButton(playjpg);
	
	play.setActionCommand("pressed");
	play.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String action = e.getActionCommand();
			if (action.equals("pressed")) {
				
				rainwav.setFile("src/resources/rain.wav");
				windwav.setFile("src/resources/wind.wav");
				frogswav.setFile("src/resources/frogs.wav");
				fireplacewav.setFile("src/resources/fireplace.wav");
				staticwav.setFile("src/resources/static.wav");
				birdswav.setFile("src/resources/birds.wav");
				thunderwav.setFile("src/resources/thunder.wav");
				cicadaswav.setFile("src/resources/cicada.wav");

				rainwav.play();
				frogswav.play();
				fireplacewav.play();
				windwav.play();
				birdswav.play();
				staticwav.play();
				thunderwav.play();
				cicadaswav.play();

				rainwav.loop();
				frogswav.loop();
				fireplacewav.loop();
				windwav.loop();
				birdswav.loop();
				staticwav.loop();
				thunderwav.loop();
				cicadaswav.loop();
		
			}
		}
	});
	
	play.setBackground(Color.black);
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 2;
	c.gridy = 0;
	pane.add(play,c);
		
		
	//timer button
	JButton timer = new JButton(timerjpg);
	timer.setBackground(Color.gray);
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 0;
	c.gridy = 0;
	pane.add(timer,c);
	

	//rain
	JSlider rainS = new JSlider(JSlider.VERTICAL,-40,6,-40);
	rainS.setBackground(Color.LIGHT_GRAY);
	c.fill = GridBagConstraints.HORIZONTAL;
	c.weightx = 0.5;
	c.gridx = 0;
	c.gridy = 1;
	pane.add(rainS, c);

	rainS.addChangeListener(new ChangeListener() {
		public void stateChanged(ChangeEvent e) {
			rainwav.currentVolume = rainS.getValue();
			if(rainwav.currentVolume == -40) {
				rainwav.currentVolume = -80;
			}
			rainwav.fc.setValue(rainwav.currentVolume);
		}
	});
	
	JButton rainb = new JButton(rainjpg);
	
	rainb.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			rainwav.volumeMute(rainS);
		}
	});
	
	rainb.setBackground(Color.black);
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 0;
	c.gridy = 2;
	pane.add(rainb,c);
	
	
	//wind
	JSlider windS = new JSlider(JSlider.VERTICAL, -40, 6, -40);
	windS.setBackground(Color.LIGHT_GRAY);
	c.fill = GridBagConstraints.HORIZONTAL;
	c.weightx = 0.5;
	c.gridx = 1;
	c.gridy = 1;
	pane.add(windS, c);
	
	windS.addChangeListener(new ChangeListener() {
		public void stateChanged(ChangeEvent e) {
			windwav.currentVolume = windS.getValue();
			if(windwav.currentVolume == -40) {
				windwav.currentVolume = -80;
			}
			windwav.fc.setValue(windwav.currentVolume);
		}
	});
	
	JButton windb = new JButton(windjpg);
	
	windb.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			windwav.volumeMute(windS);
		}
	});
	
	windb.setBackground(Color.black);
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 1;
	c.gridy = 2;
	pane.add(windb,c);
	
	
	//birds
	JSlider birdS = new JSlider(JSlider.VERTICAL, -40, 6, -40);
	birdS.setBackground(Color.LIGHT_GRAY);
	c.fill = GridBagConstraints.HORIZONTAL;
	c.weightx = 0.5;
	c.gridx = 3;
	c.gridy = 1;
	pane.add(birdS, c);
	
	birdS.addChangeListener(new ChangeListener() {
		public void stateChanged(ChangeEvent e) {
			birdswav.currentVolume = birdS.getValue();
			if(birdswav.currentVolume == -40) {
				birdswav.currentVolume = -80;
			}
			birdswav.fc.setValue(birdswav.currentVolume);
		}
	});
	
	JButton birdb = new JButton(birdsjpg);
	
	birdb.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			birdswav.volumeMute(birdS);
		}
	});
	
	birdb.setBackground(Color.black);
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 3;
	c.gridy = 2;
	pane.add(birdb,c);
	
	
	//static
	JSlider staticS = new JSlider(JSlider.VERTICAL,-40,6,-40);
	staticS.setBackground(Color.LIGHT_GRAY);
	c.fill = GridBagConstraints.HORIZONTAL;
	c.weightx = 0.5;
	c.gridx = 4;
	c.gridy = 1;
	pane.add(staticS, c);

	staticS.addChangeListener(new ChangeListener() {
		public void stateChanged(ChangeEvent e) {
			staticwav.currentVolume = staticS.getValue();
			if(staticwav.currentVolume == -40) {
				staticwav.currentVolume = -80;
			}
			staticwav.fc.setValue(staticwav.currentVolume);
		}
	});
	
	JButton staticb = new JButton(staticjpg);
	
	staticb.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			staticwav.volumeMute(staticS);
		}
	});
	
	staticb.setBackground(Color.black);
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 4;
	c.gridy = 2;
	pane.add(staticb,c);
	
	
	//thunder
	JSlider thunderS = new JSlider(JSlider.VERTICAL, -40, 6, -40);
	thunderS.setBackground(Color.LIGHT_GRAY);
	c.fill = GridBagConstraints.HORIZONTAL;
	c.weightx = 0.5;
	c.gridx = 1;
	c.gridy = 3;
	pane.add(thunderS, c);
	
	thunderS.addChangeListener(new ChangeListener() {
		public void stateChanged(ChangeEvent e) {
			thunderwav.currentVolume = thunderS.getValue();
			if(thunderwav.currentVolume == -40) {
				thunderwav.currentVolume = -80;
			}
			thunderwav.fc.setValue(thunderwav.currentVolume);
		}
	});
	
	JButton thunderb = new JButton(thunderjpg);
	
	thunderb.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			thunderwav.volumeMute(thunderS);
		}
	});
	
	thunderb.setBackground(Color.black);
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 1;
	c.gridy = 4;
	pane.add(thunderb,c);
	
	
	//frog
    JSlider frogsS = new JSlider(JSlider.VERTICAL, -40, 6, -40);
    frogsS.setBackground(Color.LIGHT_GRAY);
    c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 0.5;
    c.gridx = 3;
    c.gridy = 3;
    pane.add(frogsS,c);
    
    frogsS.addChangeListener(new ChangeListener() {
		public void stateChanged(ChangeEvent e) {
			frogswav.currentVolume = frogsS.getValue();
			if(frogswav.currentVolume == -40) {
				frogswav.currentVolume = -80;
			}
			frogswav.fc.setValue(frogswav.currentVolume);
		}
	});
    
	JButton frogsb = new JButton(frogsjpg);
	
	frogsb.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			frogswav.volumeMute(frogsS);
		}
	});
	
	frogsb.setBackground(Color.black);
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 3;
	c.gridy = 4;
	pane.add(frogsb,c);
	
	
	//fireplace
	JSlider fireplaceS = new JSlider(JSlider.VERTICAL,-40,6,-40);
	fireplaceS.setBackground(Color.LIGHT_GRAY);
	c.fill = GridBagConstraints.HORIZONTAL;
	c.weightx = 0.5;
	c.gridx = 0;
	c.gridy = 3;
	pane.add(fireplaceS, c);

	fireplaceS.addChangeListener(new ChangeListener() {
		public void stateChanged(ChangeEvent e) {
			fireplacewav.currentVolume = fireplaceS.getValue();
			if(fireplacewav.currentVolume == -40) {
				fireplacewav.currentVolume = -80;
			}
			fireplacewav.fc.setValue(fireplacewav.currentVolume);
		}
	});
	
	JButton fireplaceb = new JButton(fireplacejpg);
	
	fireplaceb.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			fireplacewav.volumeMute(fireplaceS);
		}
	});
	
	fireplaceb.setBackground(Color.black);
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 0;
	c.gridy = 4;
	pane.add(fireplaceb,c);
	
	
	//cicada
	JSlider cicadaS = new JSlider(JSlider.VERTICAL,-40,6,-40);
	cicadaS.setBackground(Color.LIGHT_GRAY);
	c.fill = GridBagConstraints.HORIZONTAL;
	c.weightx = 0.5;
	c.gridx = 4;
	c.gridy = 3;
	pane.add(cicadaS, c);

	cicadaS.addChangeListener(new ChangeListener() {
		public void stateChanged(ChangeEvent e) {
			cicadaswav.currentVolume = cicadaS.getValue();
			if(cicadaswav.currentVolume == -40) {
				cicadaswav.currentVolume = -80;
			}
			cicadaswav.fc.setValue(cicadaswav.currentVolume);
		}
	});
	
	JButton cicadab = new JButton(cicadajpg);
	
	cicadab.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			cicadaswav.volumeMute(cicadaS);
		}
	});
	
	cicadab.setBackground(Color.black);
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 4;
	c.gridy = 4;
	pane.add(cicadab,c);	
	
	//reset button
	JButton reset = new JButton(resetjpg);
	
	reset.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			rainwav.volumeMute(rainS);
			thunderwav.volumeMute(thunderS);
			cicadaswav.volumeMute(cicadaS);
			fireplacewav.volumeMute(fireplaceS);
			windwav.volumeMute(windS);
			staticwav.volumeMute(staticS);
			birdswav.volumeMute(birdS);
			frogswav.volumeMute(frogsS);
		}
	});
	
	reset.setBackground(Color.gray);
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 4;
	c.gridy = 0;
	pane.add(reset,c);
	
    }
    

    /**
     * Create the GUI and show it.
     * @throws Exception 
     */
    private static void createAndShowGUI() throws Exception {
        //Create and set up the window.
        JFrame frame = new JFrame("My Perfect Storm");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
					createAndShowGUI();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
    }
}