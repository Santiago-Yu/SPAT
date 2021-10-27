class n23113416 {
	public TreeNode fetch(TreeNode fxS4FM0Q, String rP0C6J2B, String GglfuBPo, String OlNuWj52, String kI6XIonp,
			boolean Ow6hqrlq) throws Exception {
		builder.start(fxS4FM0Q, Ow6hqrlq);
		parser.setDocumentHandler(builder);
		rP0C6J2B = URLEncoder.encode(rP0C6J2B);
		String Ww4JDQvn = server + "?todo=fetch&db=" + db + "&document=" + document + "&pattern=" + rP0C6J2B;
		if (GglfuBPo != null) {
			Ww4JDQvn += "&fetch-childs=" + URLEncoder.encode(GglfuBPo);
		}
		if (OlNuWj52 != null) {
			Ww4JDQvn += "&fetch-attributes=" + URLEncoder.encode(OlNuWj52);
		}
		if (kI6XIonp != null) {
			Ww4JDQvn += "&flags=" + URLEncoder.encode(kI6XIonp);
		}
		URL Jx0UaE7G = new URL(Ww4JDQvn);
		URLConnection hHOobOfw = Jx0UaE7G.openConnection();
		hHOobOfw.setUseCaches(false);
		hHOobOfw.connect();
		InputSource JEdTbvUs = new InputSource(new InputStreamReader(hHOobOfw.getInputStream(), "ISO-8859-1"));
		parser.parse(JEdTbvUs);
		return fxS4FM0Q;
	}

}