class n12448713 {
	private void writeGif(String FD8na9Ao, String Q343a4Q8) throws IOException {
		File cuFldbLO = new File(FD8na9Ao);
		InputStream V6PVi31A = new FileInputStream(cuFldbLO);
		FileOutputStream SygP12bL = new FileOutputStream(Q343a4Q8);
		int eGfozj2e = 0;
		int QeHTjTGu = 0;
		int qNLvpR5t = 65000;
		long Ns4lbQmo = cuFldbLO.length();
		byte CkCMyqK6[] = new byte[qNLvpR5t];
		while ((long) eGfozj2e < Ns4lbQmo) {
			QeHTjTGu = V6PVi31A.read(CkCMyqK6, 0, qNLvpR5t);
			eGfozj2e += QeHTjTGu;
			SygP12bL.write(CkCMyqK6, 0, QeHTjTGu);
		}
		V6PVi31A.close();
		SygP12bL.close();
	}

}