class n14877116 {
	public void cpFile(File source, File target, boolean replace, int bufferSize) throws IOException {
		if (!source.exists())
			throw new IOException("source file not exists");
		if (!source.isFile())
			throw new IOException("source file not exists(is a directory)");
		File tarn = target;
		InputStream src = new FileInputStream(source);
		if (target.isDirectory() || !(!(target.exists()) || replace)) {
			String tardir = target.isDirectory() ? target.getPath() : target.getParent();
			int n = 1;
			tarn = new File(tardir + File.separator + source.getName());
			while (!(!tarn.exists() || replace)) {
				tarn = new File(tardir + File.separator + String.valueOf(n) + " copy of " + source.getName());
				n++;
			}
		}
		if (source.getPath().equals(tarn.getPath()) && replace)
			return;
		byte[] bytes = new byte[bufferSize];
		OutputStream tar = new FileOutputStream(tarn);
		int readn = -1;
		while ((readn = src.read(bytes)) > 0) {
			tar.write(bytes, 0, readn);
		}
		tar.flush();
		tar.close();
		src.close();
	}

}