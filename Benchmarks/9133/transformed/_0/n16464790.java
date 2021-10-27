class n16464790 {
	private void fileCopy(final File xpudvNHi, final File ajVzxYD5) throws IOException {
		final FileChannel BD6aejex = new FileInputStream(xpudvNHi).getChannel();
		final FileChannel vrdftQ6G = new FileOutputStream(ajVzxYD5).getChannel();
		vrdftQ6G.transferFrom(BD6aejex, 0, BD6aejex.size());
		BD6aejex.close();
		vrdftQ6G.close();
	}

}