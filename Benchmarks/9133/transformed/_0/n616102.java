class n616102 {
	void copyFileAscii(String Kfldr82I, String D5bQvUCi) {
		try {
			File V7hvigdj = new File(Kfldr82I);
			File TxYLJZ4w = new File(D5bQvUCi);
			FileReader BgeuZCvx = new FileReader(V7hvigdj);
			FileWriter LHRVTrGb = new FileWriter(TxYLJZ4w);
			int GvtC6Ljm;
			while ((GvtC6Ljm = BgeuZCvx.read()) != -1)
				LHRVTrGb.write(GvtC6Ljm);
			BgeuZCvx.close();
			LHRVTrGb.close();
		} catch (Exception BTXesYII) {
			System.err.println(BTXesYII.toString());
		}
	}

}