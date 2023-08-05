package _04_gui_from_scratch._1_fortune_cookie;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FortuneCookie implements ActionListener {
	
	public void showButton() {
		
		JFrame frame = new JFrame();
		JButton button = new JButton("HI IM A TINY BUTTON");
		
		button.setPreferredSize(new Dimension(500,500));
		frame.add(button);
		frame.setVisible(true);
		frame.pack();
		
		button.addActionListener(this);
		
		
		System.out.println("Button clicked");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		int rand = new Random().nextInt(5);
		
		String yourFortune = "";
		
		switch (rand) {
		
		case 0:  yourFortune = "no";
		break;
		case 1: yourFortune = "Hello?";
		break;
		case 2: yourFortune = "run.";
		break;
		case 3:  yourFortune = "If you eat something and no one sees you eat it, it has no calories";
		break;
		case 4:  yourFortune = "Hi there";
		break;
		
		}
		
		JOptionPane.showMessageDialog(null, yourFortune);
	}

}
