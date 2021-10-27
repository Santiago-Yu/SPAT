class n16948800 {
	public static void copyFileStreams(File eRJRBRJC, File uhYl6rL1) throws IOException {
		if (!eRJRBRJC.exists()) {
			return;
		}
		FileInputStream OAvjRFZo = new FileInputStream(eRJRBRJC);
		FileOutputStream hPPY112S = new FileOutputStream(uhYl6rL1);
		int RTvVw0PN = 0;
		byte[] Zg6wCUeQ = new byte[1024];
		while (-1 != RTvVw0PN) {
			RTvVw0PN = OAvjRFZo.read(Zg6wCUeQ);
			if (RTvVw0PN >= 0) {
				hPPY112S.write(Zg6wCUeQ, 0, RTvVw0PN);
			}
		}
		hPPY112S.close();
		OAvjRFZo.close();
	}

}