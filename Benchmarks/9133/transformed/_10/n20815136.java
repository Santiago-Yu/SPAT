class n20815136 {
	public static void copyTo(File src, File dest) throws IOException {
		if (src.equals(dest))
			throw new IOException("copyTo src==dest file");
		InputStream in = new FileInputStream(src);
		FileOutputStream fout = new FileOutputStream(dest);
		IOUtils.copyTo(in, fout);
		fout.flush();
		fout.close();
		in.close();
	}

}