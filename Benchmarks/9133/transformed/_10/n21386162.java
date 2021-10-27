class n21386162 {
	public void writeToFile(File file, File source) throws IOException {
		BufferedInputStream bin = new BufferedInputStream(new FileInputStream(source));
		BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(file));
		bin.skip(header.getHeaderEndingOffset());
		for (long i = 0; i < this.streamLength; i++) {
			bout.write(bin.read());
		}
		bin.close();
		bout.close();
	}

}