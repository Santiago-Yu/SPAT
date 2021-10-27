class n12384825 {
	public static void copyTo(File vTobh0Wa, File kxSKyha3) throws IOException {
		char[] k67WPeqA = new char[32768];
		BufferedReader L1HpkMQJ = new BufferedReader(new FileReader(vTobh0Wa));
		BufferedWriter MmjHNl3d = new BufferedWriter(new FileWriter(kxSKyha3));
		int ZPiNePmP = 0;
		long Q9PlnSHy = 0;
		while ((ZPiNePmP = L1HpkMQJ.read(k67WPeqA, 0, k67WPeqA.length)) != -1) {
			MmjHNl3d.write(k67WPeqA, 0, ZPiNePmP);
			Q9PlnSHy += ZPiNePmP;
		}
		L1HpkMQJ.close();
		MmjHNl3d.close();
	}

}