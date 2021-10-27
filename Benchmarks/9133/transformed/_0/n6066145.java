class n6066145 {
	public void copy(String onEGOYu3, String Y3PBHCcR) throws IOException {
		@Cleanup
		FileChannel pJgl99he = new FileInputStream(new File(onEGOYu3)).getChannel();
		@Cleanup
		FileChannel nrOdAwkk = new FileOutputStream(new File(Y3PBHCcR)).getChannel();
		nrOdAwkk.transferFrom(pJgl99he, 0, pJgl99he.size());
	}

}