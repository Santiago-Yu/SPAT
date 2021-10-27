class n21561833 {
	private static void copyFile(String w96euJzU, String dE19hrwR) throws IOException {
		File nsMnZeiK = new File(dE19hrwR);
		if (nsMnZeiK.exists()) {
			nsMnZeiK.delete();
		}
		FileChannel fx1G1uom = new FileInputStream(w96euJzU).getChannel();
		FileChannel oB1C3otX = new FileOutputStream(dE19hrwR).getChannel();
		oB1C3otX.transferFrom(fx1G1uom, 0, fx1G1uom.size());
		fx1G1uom.close();
		oB1C3otX.close();
	}

}