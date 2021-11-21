package important;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.JSlider;

public class Sound {
	
	Clip clip;
	float previousVolume = 0;
	float currentVolume = -17;
	FloatControl fc;
	boolean mute = false;
	
	public void setFile(String name) {
		File file = new File(name);
		
		try {
			AudioInputStream sound = AudioSystem.getAudioInputStream(file);
			clip = AudioSystem.getClip();
			clip.open(sound);
			fc = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
		}
		catch (Exception e) {
			
		}
		
	}
	
	public void play() {
		
		fc.setValue(-80);
		
		clip.setFramePosition(0);	
		clip.start();
	}
	
	public void loop() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);;
	}
	
	public void volumeMute(JSlider slider) {
		if (mute == false) {
			previousVolume = currentVolume;
			currentVolume = -80.0f;
			fc.setValue(currentVolume);
			mute = true;
			
			slider.setValue(slider.getMinimum());
			
		} else if(mute == true) {
			currentVolume = previousVolume;
			slider.setValue((int)currentVolume);
			fc.setValue(currentVolume);
			mute = false;
		}
	}
}
