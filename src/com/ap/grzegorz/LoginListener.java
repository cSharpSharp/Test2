package com.ap.grzegorz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class LoginListener implements ActionListener {
	//G³ówna ramka programu
	private final JFrame frame;
	//Panel logowania, potrzebny do pobrania loginu i has³a
	private LoginPanel loginPanel;

	public void setPanel(LoginPanel loginPanel) {
		this.loginPanel = loginPanel;
	}

	public LoginListener(JFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String name = loginPanel.getName();
		String password = loginPanel.getPassword();
		if (UserValidator.authenticate(name, password)) {
			JOptionPane.showMessageDialog(null, "My Goodness, this is so concise");
			
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					

					// panel z edytorem html
					//JPanel htmlPanel = new HTMLPanel();
					// usuwamy panel logowania
					//frame.getContentPane().removeAll();
					// dodajemy panel html i odœwie¿amy widok
					//frame.add(htmlPanel);
					//frame.validate();
				}
			});
		}
	}
	
	static class UserValidator {
		private static final String name = "admin";
		private static final String password = "admin";

		public static boolean authenticate(String name, String password) {
			if(UserValidator.name.equals(name) & UserValidator.password.equals(password))
				return true;
			else
				return false;
		}
	}
}