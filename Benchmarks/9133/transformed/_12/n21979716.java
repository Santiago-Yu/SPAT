class n21979716 {
	@ActionMethod
	public void download() throws IOException {
		final JPanel message = new JPanel(new GridBagLayout());
		final GridBagConstraints gbcLabel = new GridBagConstraints();
		final GridBagConstraints gbcField = new GridBagConstraints();
		gbcLabel.weightx = 0.0;
		gbcField.weightx = 1.0;
		gbcField.fill = GridBagConstraints.HORIZONTAL;
		gbcField.insets = new Insets(2, 2, 2, 2);
		final JTextField deviceField, fullnameField, versionField;
		deviceField = new JTextField();
		fullnameField = new JTextField();
		versionField = new JTextField();
		gbcField.gridwidth = GridBagConstraints.REMAINDER;
		message.add(new JLabel("device"), gbcLabel);
		message.add(deviceField, gbcField);
		message.add(new JLabel("fullname"), gbcLabel);
		message.add(fullnameField, gbcField);
		message.add(new JLabel("version"), gbcLabel);
		message.add(versionField, gbcField);
		final int result = JOptionPane.showConfirmDialog(frame, message, "Download parameters",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (result != JOptionPane.OK_OPTION) {
			return;
		}
		final String device = deviceField.getText(), fullname = fullnameField.getText();
		final String version = versionField.getText();
		final URL url = new URL("http://127.0.0.1:" + testPort + "/databases/" + fullname + "?device=" + device
				+ "&version=" + version);
		final HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestProperty(Http11Header.AUTHORIZATION, "Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==");
		con.setRequestProperty(Http11Header.WWW_AUTHENTICATE, "Basic realm=\"karatasi\"");
		final InputStream in = con.getInputStream();
		try {
			final int fileResult = fileChooser.showSaveDialog(frame);
			if (fileResult != JFileChooser.APPROVE_OPTION) {
				return;
			}
			final OutputStream out = new FileOutputStream(fileChooser.getSelectedFile());
			try {
				Util.copy(in, out);
			} finally {
				out.close();
			}
		} finally {
			in.close();
		}
	}

}