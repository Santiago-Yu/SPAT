class n21682040 {
	public void extractFrinika() throws Exception {
		FileInputStream pxLg8pjg = new FileInputStream(frinikaFile);
		progressBar.setIndeterminate(true);
		ZipInputStream SfLUe9NO = new ZipInputStream(pxLg8pjg);
		ZipEntry N1OmOWNf = SfLUe9NO.getNextEntry();
		while (N1OmOWNf != null) {
			showMessage("Extracting: " + N1OmOWNf.getName());
			File kckjYcgb = new File(installDirName + "/" + N1OmOWNf.getName());
			if (N1OmOWNf.isDirectory())
				kckjYcgb.mkdir();
			else {
				FileOutputStream psZfiOPJ = new FileOutputStream(kckjYcgb);
				byte[] b4cO79FO = new byte[BUFSIZE];
				int hFpYgaph;
				while ((hFpYgaph = SfLUe9NO.read(b4cO79FO)) != -1)
					psZfiOPJ.write(b4cO79FO, 0, hFpYgaph);
				psZfiOPJ.close();
			}
			N1OmOWNf = SfLUe9NO.getNextEntry();
		}
	}

}