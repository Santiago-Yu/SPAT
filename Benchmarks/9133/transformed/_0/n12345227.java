class n12345227 {
	void copyFile(File BlXHW4g6, File zEgQ3Ems) throws IOException {
		InputStream cvUib5He = new FileInputStream(BlXHW4g6);
		OutputStream ADvn3NJw = new FileOutputStream(zEgQ3Ems);
		byte[] gJX9bktw = new byte[1024];
		int FZWxnk36;
		while ((FZWxnk36 = cvUib5He.read(gJX9bktw)) > 0)
			ADvn3NJw.write(gJX9bktw, 0, FZWxnk36);
		cvUib5He.close();
		ADvn3NJw.close();
	}

}