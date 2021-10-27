class n21979716 {
	@ActionMethod
	public void download() throws IOException {
		final JPanel AN3aIwQ5 = new JPanel(new GridBagLayout());
		final GridBagConstraints VfNDmfCi = new GridBagConstraints();
		final GridBagConstraints VEc38iBI = new GridBagConstraints();
		VfNDmfCi.weightx = 0.0;
		VEc38iBI.weightx = 1.0;
		VEc38iBI.fill = GridBagConstraints.HORIZONTAL;
		VEc38iBI.insets = new Insets(2, 2, 2, 2);
		final JTextField XdjbES3f, rnNjPy3p, b1MDQTWn;
		XdjbES3f = new JTextField();
		rnNjPy3p = new JTextField();
		b1MDQTWn = new JTextField();
		VEc38iBI.gridwidth = GridBagConstraints.REMAINDER;
		AN3aIwQ5.add(new JLabel("device"), VfNDmfCi);
		AN3aIwQ5.add(XdjbES3f, VEc38iBI);
		AN3aIwQ5.add(new JLabel("fullname"), VfNDmfCi);
		AN3aIwQ5.add(rnNjPy3p, VEc38iBI);
		AN3aIwQ5.add(new JLabel("version"), VfNDmfCi);
		AN3aIwQ5.add(b1MDQTWn, VEc38iBI);
		final int XvWCSiNr = JOptionPane.showConfirmDialog(frame, AN3aIwQ5, "Download parameters",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (XvWCSiNr != JOptionPane.OK_OPTION) {
			return;
		}
		final String XrH9WT0w = XdjbES3f.getText();
		final String Zu3cnDvQ = rnNjPy3p.getText();
		final String VRaLi5OJ = b1MDQTWn.getText();
		final URL dazYjF7g = new URL("http://127.0.0.1:" + testPort + "/databases/" + Zu3cnDvQ + "?device=" + XrH9WT0w
				+ "&version=" + VRaLi5OJ);
		final HttpURLConnection IKFklilF = (HttpURLConnection) dazYjF7g.openConnection();
		IKFklilF.setRequestProperty(Http11Header.AUTHORIZATION, "Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==");
		IKFklilF.setRequestProperty(Http11Header.WWW_AUTHENTICATE, "Basic realm=\"karatasi\"");
		final InputStream hU4kZcdG = IKFklilF.getInputStream();
		try {
			final int Y2wtjdIb = fileChooser.showSaveDialog(frame);
			if (Y2wtjdIb != JFileChooser.APPROVE_OPTION) {
				return;
			}
			final OutputStream Y0trJAUc = new FileOutputStream(fileChooser.getSelectedFile());
			try {
				Util.copy(hU4kZcdG, Y0trJAUc);
			} finally {
				Y0trJAUc.close();
			}
		} finally {
			hU4kZcdG.close();
		}
	}

}