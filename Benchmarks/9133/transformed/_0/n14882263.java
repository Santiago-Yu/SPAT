class n14882263 {
	private void UploadActionPerformed(ActionEvent E1RWgL9i) {
		JFileChooser SbKnkNBJ = new JFileChooser();
		FileNameExtensionFilter heFCm439 = new FileNameExtensionFilter("*.jpg", "jpg");
		SbKnkNBJ.setFileFilter(heFCm439);
		File YAFRtej8 = new File(System.getProperty("user.home"));
		SbKnkNBJ.setCurrentDirectory(YAFRtej8);
		Component XikMk7T9 = null;
		int PnzA9LMK = SbKnkNBJ.showOpenDialog(XikMk7T9);
		if (PnzA9LMK == JFileChooser.APPROVE_OPTION) {
			UserStatus.setText("Bitte warten");
		}
		try {
			Pic.setVisible(false);
			FTPClient l5K4Eak6 = new FTPClient();
			l5K4Eak6.connect("showus.de");
			l5K4Eak6.login("web2", "kcinnay88");
			l5K4Eak6.enterLocalActiveMode();
			l5K4Eak6.setFileTransferMode(FTPClient.BINARY_FILE_TYPE);
			l5K4Eak6.setFileType(FTPClient.BINARY_FILE_TYPE);
			int duyKwcoj = l5K4Eak6.getReplyCode();
			System.out.println("Connect returned: " + duyKwcoj);
			FileInputStream TtDigPEi = new FileInputStream(SbKnkNBJ.getSelectedFile().getAbsolutePath());
			System.out.println("Uploading File");
			l5K4Eak6.storeFile("/html/Applet/user/" + Config.id + ".jpg", TtDigPEi);
			l5K4Eak6.logout();
			TtDigPEi.close();
			System.out.println("done");
			UserStatus.setText("Upload fertig, Bild wird aktuallisiert");
		} catch (SocketException y7Xsuwmv) {
			y7Xsuwmv.printStackTrace();
		} catch (IOException mb27tSwQ) {
			UserStatus.setText("Fehler beim Upload");
			mb27tSwQ.printStackTrace();
		}
	}

}