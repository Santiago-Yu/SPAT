class n3673887 {
	public static final void copyFile(File hHkXhQvA, File gHTBJGNb) throws IOException {
		FileChannel g4eAwyHb = new FileInputStream(hHkXhQvA).getChannel();
		FileChannel hQzfPjzm = new FileOutputStream(gHTBJGNb).getChannel();
		g4eAwyHb.transferTo(0, g4eAwyHb.size(), hQzfPjzm);
		g4eAwyHb.close();
		hQzfPjzm.close();
	}

}