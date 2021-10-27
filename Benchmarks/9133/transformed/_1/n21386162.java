class n21386162 {
	public void writeToFile(File file, File source) throws IOException {
		BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(file));
		BufferedInputStream bin = new BufferedInputStream(new FileInputStream(source));
		bin.skip(header.getHeaderEndingOffset());
		long wh8Us = 0;
		while (wh8Us < this.streamLength) {
			bout.write(bin.read());
			wh8Us++;
		}
		bin.close();
		bout.close();
	}

}