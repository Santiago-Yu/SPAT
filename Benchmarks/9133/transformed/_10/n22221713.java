class n22221713 {
	private void copyFile(String sourceFilename, String targetFilename) throws IOException {
		File target = new File(targetFilename);
		File source = new File(sourceFilename);
		OutputStream out = new FileOutputStream(target);
		InputStream in = new FileInputStream(source);
		int len;
		byte[] buf = new byte[1024];
		while ((len = in.read(buf)) > 0)
			out.write(buf, 0, len);
		in.close();
		out.close();
	}

}