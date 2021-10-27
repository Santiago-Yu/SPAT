class n21064899 {
	protected static String getURLandWriteToDisk(String Zp4v00kY, Model ZFuWDbtm)
			throws MalformedURLException, IOException {
		String YJHJdwnI = null;
		URL CzhqpcGu = new URL(Zp4v00kY);
		InputStream niYoJsQQ = CzhqpcGu.openStream();
		InputStreamReader loR3il5d;
		OutputStreamWriter hOwrRCzP;
		int XpsrRSXO = 0, zhuzqqNF = 0;
		initModelHash();
		if (System.getProperty("user.dir") != null) {
			String q1sIDE51;
			YJHJdwnI = System.getProperty("user.dir");
			if (YJHJdwnI.contains("/")) {
				q1sIDE51 = "/";
			} else {
				q1sIDE51 = "\\";
			}
			char HicOrKBS = YJHJdwnI.charAt(YJHJdwnI.length() - 1);
			if (HicOrKBS == '/' || HicOrKBS == '\\') {
				YJHJdwnI = YJHJdwnI.substring(0, YJHJdwnI.length() - 2);
			}
			YJHJdwnI = YJHJdwnI.substring(0, YJHJdwnI.lastIndexOf(q1sIDE51) + 1);
			YJHJdwnI = YJHJdwnI.concat("ontologies" + q1sIDE51 + "downloaded");
			(new File(YJHJdwnI)).mkdir();
			YJHJdwnI = YJHJdwnI.concat(q1sIDE51);
			YJHJdwnI = createFullPath(Zp4v00kY, YJHJdwnI);
			hOwrRCzP = new OutputStreamWriter(new FileOutputStream(YJHJdwnI));
			loR3il5d = new InputStreamReader(niYoJsQQ);
			zhuzqqNF = loR3il5d.read();
			while (zhuzqqNF != -1) {
				hOwrRCzP.write(zhuzqqNF);
				XpsrRSXO += zhuzqqNF;
				zhuzqqNF = loR3il5d.read();
			}
			loR3il5d.close();
			hOwrRCzP.close();
			niYoJsQQ.close();
			FileInputStream g74pFY5z = new FileInputStream(YJHJdwnI);
			ZFuWDbtm.read(g74pFY5z, "");
		}
		return YJHJdwnI;
	}

}