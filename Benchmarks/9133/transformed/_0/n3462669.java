class n3462669 {
	private void fileCopy(final File vBY5KeMT, final File xmzmWDp6) throws IOException {
		final FileChannel P0jLJ5qy = new FileInputStream(vBY5KeMT).getChannel();
		final FileChannel SIKpFzqC = new FileOutputStream(xmzmWDp6).getChannel();
		SIKpFzqC.transferFrom(P0jLJ5qy, 0, P0jLJ5qy.size());
		P0jLJ5qy.close();
		SIKpFzqC.close();
	}

}