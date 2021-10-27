class n662295 {
	public static void copy(URL url, String outPath) throws IOException {
		System.out.println("copying from: " + url + " to " + outPath);
		FileOutputStream fout = new FileOutputStream(outPath);
		InputStream in = url.openStream();
		int read = -1;
		byte[] data = new byte[8192];
		while ((read = in.read(data)) != -1) {
			fout.write(data, 0, read);
		}
		fout.close();
	}

}