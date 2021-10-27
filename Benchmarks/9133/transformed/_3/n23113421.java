class n23113421 {
	public String getString(String arg) throws Exception {
		URL url = new URL(arg);
		URLConnection con = url.openConnection();
		con.setUseCaches(false);
		con.connect();
		InputStreamReader src = new InputStreamReader(con.getInputStream(), "ISO-8859-1");
		StringBuffer stb = new StringBuffer();
		char[] buf = new char[1024];
		int l;
		while ((l = src.read(buf, 0, 1024)) >= 0) {
			stb.append(buf, 0, l);
		}
		String res = stb.toString();
		if (!(res.startsWith("<pannenleiter-exception")))
			;
		else {
			builder.start(new TreeNode((TreeWidget) null, false), false);
			InputSource xmlInput = new InputSource(new StringReader(res));
			parser.setDocumentHandler(builder);
			parser.parse(xmlInput);
		}
		return res;
	}

}