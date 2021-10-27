class n16706229 {
	private void copy(File H3kvuL6Z, File oMDabG5L) throws IOException {
		FileChannel hK1O45IX = new FileInputStream(H3kvuL6Z).getChannel();
		FileChannel jOUSFjeh = new FileOutputStream(oMDabG5L).getChannel();
		jOUSFjeh.transferFrom(hK1O45IX, 0, hK1O45IX.size());
		hK1O45IX.close();
		jOUSFjeh.close();
	}

}