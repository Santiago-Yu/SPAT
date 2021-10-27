class n23147989 {
	public boolean copy(String KBua1Xq7, String D3kIcd8C) {
		try {
			File MLdSWemp = new File(KBua1Xq7);
			String lziNlEzO, jF9AJB1y;
			lziNlEzO = KBua1Xq7;
			jF9AJB1y = D3kIcd8C;
			while (jF9AJB1y.contains("\\")) {
				jF9AJB1y = jF9AJB1y.substring(jF9AJB1y.indexOf("\\") + 1);
				lziNlEzO = lziNlEzO.substring(lziNlEzO.indexOf("\\") + 1);
			}
			lziNlEzO = KBua1Xq7.substring(0, KBua1Xq7.length() - lziNlEzO.length()) + jF9AJB1y
					+ lziNlEzO.substring(lziNlEzO.indexOf("\\"));
			File G0iwjHF6 = new File(lziNlEzO);
			File Y0W5rdpQ = G0iwjHF6.getParentFile();
			Y0W5rdpQ.mkdirs();
			FileInputStream jmBq1mCV = new FileInputStream(MLdSWemp);
			FileOutputStream JjQTjWaq = new FileOutputStream(G0iwjHF6);
			byte[] fxVBxDP7 = new byte[1024];
			int E4SoRjCx;
			while ((E4SoRjCx = jmBq1mCV.read(fxVBxDP7)) != -1)
				JjQTjWaq.write(fxVBxDP7, 0, E4SoRjCx);
			jmBq1mCV.close();
			JjQTjWaq.close();
			return true;
		} catch (Exception NDh4zsHK) {
			NDh4zsHK.printStackTrace();
			System.out.println("Error!");
			return false;
		}
	}

}