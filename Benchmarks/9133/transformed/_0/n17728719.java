class n17728719 {
	private void copyFile(File MkfjwUL3, File zN6C0tsH) throws IOException {
		InputStream xxm0Y7Gs = new FileInputStream(MkfjwUL3);
		OutputStream yLeiPSkZ = new FileOutputStream(zN6C0tsH);
		byte[] QSgHNWac = new byte[1024];
		int tOXvWgk1;
		while ((tOXvWgk1 = xxm0Y7Gs.read(QSgHNWac)) > 0)
			yLeiPSkZ.write(QSgHNWac, 0, tOXvWgk1);
		xxm0Y7Gs.close();
		yLeiPSkZ.close();
	}

}