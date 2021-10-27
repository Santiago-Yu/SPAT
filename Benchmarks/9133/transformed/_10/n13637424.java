class n13637424 {
	public void actionPerformed(ActionEvent e) {
		String aboutText = "Slug application.";
		boolean canShowInPane = false;
		String aboutURL = System.getProperty(GateConstants.ABOUT_URL_JAVA_PROPERTY_NAME);
		if (aboutURL != null) {
			try {
				AboutPaneDialog dlg = new AboutPaneDialog(ShellSlacFrame.this, "Slug application about", true);
				URL url = new URL(aboutURL);
				canShowInPane = dlg.setURL(url);
				if (canShowInPane) {
					dlg.setSize(300, 200);
					dlg.setLocationRelativeTo(ShellSlacFrame.this);
					dlg.setVisible(true);
				} else {
					String line = "";
					BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
					StringBuffer content = new StringBuffer();
					do {
						content.append(line);
						line = reader.readLine();
					} while (line != null);
					if (content.length() != 0) {
						aboutText = content.toString();
					}
				}
			} catch (Exception ex) {
				if (DEBUG) {
					ex.printStackTrace();
				}
			}
		}
		if (!canShowInPane)
			JOptionPane.showMessageDialog(ShellSlacFrame.this, aboutText, "Slug application about",
					JOptionPane.INFORMATION_MESSAGE);
	}

}