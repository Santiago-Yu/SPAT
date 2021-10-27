class n10062077 {
	private void appendArchive(File instClass) throws IOException {
		FileInputStream zipStream = new FileInputStream("install.jar");
		FileOutputStream out = new FileOutputStream(instClass.getName(), true);
		byte[] buf = new byte[2048];
		int read = zipStream.read(buf);
		while (read > 0) {
			out.write(buf, 0, read);
			read = zipStream.read(buf);
		}
		zipStream.close();
		out.close();
	}

}