package _04_gui_from_scratch._4_cuteness_tv;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Cuteness implements ActionListener {
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton sawButton = new JButton("Video 1");
	JButton drumButton = new JButton("Video 2");
	
	public static void main(String[] args) {
		new Cuteness().makeUI();
	}
	
	public void makeUI() {

		panel.add(drumButton);
		panel.add(sawButton);
		frame.add(panel);
		
		sawButton.addActionListener(this);
		drumButton.addActionListener(this);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		if (button == sawButton) {
			playSound("sawing-wood-daniel_simon.wav");
		} else if (button == drumButton) {
			playSound("drum.wav");
		}

	}
	
	private void playSound(String soundFile) {
		String path = "src/_04_gui_from_scratch/_3_sound_effects_machine/";
			File sound = new File(path+soundFile);
			if (sound.exists()) {
				new Thread(() -> {
				try {
					Clip clip = AudioSystem.getClip();
					clip.open(AudioSystem.getAudioInputStream(sound));
					clip.start();
					Thread.sleep(clip.getMicrosecondLength()/1000);
				}
				catch (Exception e) {
					System.out.println("Could not play this sound");
				}}).start();
	 		}
			else {
				System.out.println("File does not exist");
			}
		
	}
    
}
