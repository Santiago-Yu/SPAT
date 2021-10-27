class n4407823 {
	public static void copyFolderStucture(String sszCCBd6, String NqjZml3v) throws IOException {
		Constants.iLog.LogInfoLine("copying " + sszCCBd6);
		File anqG3hAj = new File(sszCCBd6);
		File cMige0N4 = new File(NqjZml3v);
		if (anqG3hAj.isDirectory()) {
			cMige0N4.mkdirs();
			String qSBcMw3z[] = anqG3hAj.list();
			for (int s0i6CpF1 = 0; s0i6CpF1 < qSBcMw3z.length; s0i6CpF1++) {
				String i7GNDZVB = cMige0N4.getAbsolutePath() + "\\" + qSBcMw3z[s0i6CpF1];
				String vFgzECAp = anqG3hAj.getAbsolutePath() + "\\" + qSBcMw3z[s0i6CpF1];
				copyFolderStucture(vFgzECAp, i7GNDZVB);
			}
		} else {
			FileInputStream yrVBKKlx = new FileInputStream(anqG3hAj);
			FileOutputStream gVzcgjxf = new FileOutputStream(cMige0N4);
			int neXkELvU;
			while ((neXkELvU = yrVBKKlx.read()) >= 0)
				gVzcgjxf.write(neXkELvU);
			yrVBKKlx.close();
			gVzcgjxf.close();
		}
	}

}