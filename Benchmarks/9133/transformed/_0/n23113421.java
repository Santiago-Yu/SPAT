class n23113421 {
	public String getString(String RLk1Snkn) throws Exception {
		URL qZSiZ9HR = new URL(RLk1Snkn);
		URLConnection BeUkQhHw = qZSiZ9HR.openConnection();
		BeUkQhHw.setUseCaches(false);
		BeUkQhHw.connect();
		InputStreamReader THWeIwFA = new InputStreamReader(BeUkQhHw.getInputStream(), "ISO-8859-1");
		StringBuffer YzOzVmRE = new StringBuffer();
		char[] mVxdGCbq = new char[1024];
		int oUD5hyYl;
		while ((oUD5hyYl = THWeIwFA.read(mVxdGCbq, 0, 1024)) >= 0) {
			YzOzVmRE.append(mVxdGCbq, 0, oUD5hyYl);
		}
		String UAziXiJR = YzOzVmRE.toString();
		if (UAziXiJR.startsWith("<pannenleiter-exception")) {
			builder.start(new TreeNode((TreeWidget) null, false), false);
			InputSource GC7cv6XW = new InputSource(new StringReader(UAziXiJR));
			parser.setDocumentHandler(builder);
			parser.parse(GC7cv6XW);
		}
		return UAziXiJR;
	}

}