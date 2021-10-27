class n21979717 {
	@ActionMethod
	public void upload() throws IOException {
		final int X8voSptK = fileChooser.showOpenDialog(frame);
		if (X8voSptK != JFileChooser.APPROVE_OPTION) {
			return;
		}
		final InputStream FPBGEgeE = new FileInputStream(fileChooser.getSelectedFile());
		try {
			final URL TmjH6WS8 = new URL(
					"http://127.0.0.1:" + testPort + "/databases/" + fileChooser.getSelectedFile().getName());
			final HttpURLConnection fk8UibFI = (HttpURLConnection) TmjH6WS8.openConnection();
			fk8UibFI.setRequestMethod("PUT");
			fk8UibFI.setDoOutput(true);
			fk8UibFI.setRequestProperty(Http11Header.AUTHORIZATION, "Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==");
			fk8UibFI.setRequestProperty(Http11Header.WWW_AUTHENTICATE, "Basic realm=\"karatasi\"");
			fk8UibFI.setRequestProperty(Http11Header.CONTENT_LENGTH,
					Long.toString(fileChooser.getSelectedFile().length()));
			fk8UibFI.setRequestProperty(Http11Header.CONTENT_TYPE, "application/octet-stream");
			final OutputStream HqzseX8G = fk8UibFI.getOutputStream();
			try {
				Util.copy(FPBGEgeE, HqzseX8G);
				fk8UibFI.connect();
				final InputStream yXrGCTPH = fk8UibFI.getInputStream();
				try {
					textArea.setText("");
					final byte[] MmAzr6d2 = new byte[4096];
					for (int XCQk7GTW; (XCQk7GTW = yXrGCTPH.read(MmAzr6d2)) != -1;) {
						textArea.append(new String(MmAzr6d2, 0, XCQk7GTW));
					}
				} finally {
					yXrGCTPH.close();
				}
			} finally {
				HqzseX8G.close();
			}
		} finally {
			FPBGEgeE.close();
		}
	}

}