class n22489287 {
	public void load(URL NsZl9IoC) throws IOException {
		try {
			oggBitStream_ = new BufferedInputStream(NsZl9IoC.openStream());
		} catch (Exception ifzADPI9) {
			System.err.println("ogg file " + NsZl9IoC + " could not be loaded");
		}
		load();
	}

}