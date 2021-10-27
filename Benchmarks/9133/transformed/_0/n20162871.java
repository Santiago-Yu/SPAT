class n20162871 {
	public static void copyFile(String lCJoRIAL, String NEwCHyVf, boolean cJkAJbHV)
			throws FileNotFoundException, IOException {
		if (cJkAJbHV) {
			PogoString Wv09el15 = new PogoString(PogoUtil.readFile(lCJoRIAL));
			Wv09el15 = PogoUtil.removeLogMessages(Wv09el15);
			PogoUtil.writeFile(NEwCHyVf, Wv09el15.str);
		} else {
			FileInputStream MWHWPqME = new FileInputStream(lCJoRIAL);
			FileOutputStream Efom0rTw = new FileOutputStream(NEwCHyVf);
			int yos1LYdK = MWHWPqME.available();
			byte[] mzEuOIxP = new byte[yos1LYdK];
			if (MWHWPqME.read(mzEuOIxP) > 0)
				Efom0rTw.write(mzEuOIxP);
			MWHWPqME.close();
			Efom0rTw.close();
		}
	}

}