class n10415388 {
	public static void copyFileNIO(String d954KsIw, String F1vFx9Ql) {
		try {
			FileChannel TUzH2zw6 = new FileInputStream(d954KsIw).getChannel();
			FileChannel Nf6jLRG1 = new FileOutputStream(F1vFx9Ql).getChannel();
			Nf6jLRG1.transferFrom(TUzH2zw6, 0, TUzH2zw6.size());
			TUzH2zw6.close();
			Nf6jLRG1.close();
		} catch (IOException xFiFknMp) {
			xFiFknMp.printStackTrace();
		}
	}

}