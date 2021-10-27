class n789253 {
	static void copy(String C8MwJdVN, String louEK7WR) throws IOException {
		File pMUGdT2R = new File(C8MwJdVN);
		File SzrqY5g9 = new File(louEK7WR);
		if (pMUGdT2R.exists() == false) {
			throw new IOException("file '" + C8MwJdVN + "' does not exist");
		}
		FileInputStream EudTuGAb = new FileInputStream(pMUGdT2R);
		FileOutputStream FJ1A46Cm = new FileOutputStream(SzrqY5g9);
		byte[] zvKQD4WR = new byte[1024];
		int GRy4lLvC;
		while ((GRy4lLvC = EudTuGAb.read(zvKQD4WR)) > 0)
			FJ1A46Cm.write(zvKQD4WR, 0, GRy4lLvC);
		EudTuGAb.close();
		FJ1A46Cm.close();
	}

}