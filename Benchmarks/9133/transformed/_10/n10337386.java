class n10337386 {
	protected void zipFile(File from, File to) throws IOException {
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(to));
		FileInputStream in = new FileInputStream(from);
		int bytes_read;
		byte[] buffer = new byte[4096];
		while ((bytes_read = in.read(buffer)) != -1)
			out.write(buffer, 0, bytes_read);
		in.close();
		out.close();
	}

}