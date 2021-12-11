package homework5;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

class Sound {
	String files[] = {"startpage.wav","boink.wav","fail.wav","crack.wav","special.wav","victory.wav"};
	Clip clip;
	URL url;
	
	Sound(){
		try {
			clip = AudioSystem.getClip();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	};
	
	public void play(int n) {
		
		String sound;
		switch(n) {
		case 0:
			sound = files[0];//start sound
			break;
		case 1:
			sound = files[1];//boink sound
			break;
		case 2:
			sound = files[2];//fail sound
			break;
		case 3:
			sound = files[3];//crack sound
			break;
		case 4:
			sound = files[4];//crack special block
			break;
		case 5:
			sound = files[5];//victory
			break;
		default:
			sound = null;
			break;
		}
		
		url = getClass().getClassLoader().getResource(sound);
		
	
		AudioInputStream audio = null;
		try {
			audio = AudioSystem.getAudioInputStream(url);
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		}
		
		try {
			clip.open(audio);
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		clip.start();
	}
	public void stop() {
		clip.stop();
	}
}
