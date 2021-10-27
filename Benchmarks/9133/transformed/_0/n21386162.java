class n21386162 {
	public void writeToFile(File gaan6tFY, File NUal56CT) throws IOException {
		BufferedOutputStream BuYFMjdG = new BufferedOutputStream(new FileOutputStream(gaan6tFY));
		BufferedInputStream rHr7OQtW = new BufferedInputStream(new FileInputStream(NUal56CT));
		rHr7OQtW.skip(header.getHeaderEndingOffset());
		for (long dry2Klir = 0; dry2Klir < this.streamLength; dry2Klir++) {
			BuYFMjdG.write(rHr7OQtW.read());
		}
		rHr7OQtW.close();
		BuYFMjdG.close();
	}

}