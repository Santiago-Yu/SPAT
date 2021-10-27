class n22966596 {
	public static void copyFile(String gaswwTe6, String JX6yInQN) throws IOException {
		int KlTtm8Xa = 0;
		int OPKSXgtt = 0;
		File XE8vnrxo = new File(gaswwTe6);
		if (XE8vnrxo.exists()) {
			InputStream yYzN59ND = new FileInputStream(gaswwTe6);
			FileOutputStream uPwTAjz7 = new FileOutputStream(JX6yInQN);
			byte[] Hm4bOvgP = new byte[1444];
			while ((OPKSXgtt = yYzN59ND.read(Hm4bOvgP)) != -1) {
				KlTtm8Xa += OPKSXgtt;
				uPwTAjz7.write(Hm4bOvgP, 0, OPKSXgtt);
			}
			yYzN59ND.close();
		}
	}

}