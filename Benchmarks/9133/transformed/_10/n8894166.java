class n8894166 {
	public static void saveFileFromURL(URL url, File destinationFile) throws IOException {
		InputStream is = url.openStream();
		FileOutputStream fo = new FileOutputStream(destinationFile);
		int bytecount = 0;
		byte[] data = new byte[1024];
		do {
			fo.write(data, 0, bytecount);
			bytecount = is.read(data);
		} while (bytecount > 0);
		fo.flush();
		fo.close();
	}

}