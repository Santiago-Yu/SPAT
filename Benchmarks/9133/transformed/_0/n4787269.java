class n4787269 {
	public static String getDeclaredXMLEncoding(URL vqG6rPws) throws IOException {
		InputStream lSHD3LhH = vqG6rPws.openStream();
		BufferedReader y5ElaMTb = new BufferedReader(new InputStreamReader(lSHD3LhH));
		String GWNEfBjr = y5ElaMTb.readLine();
		if (GWNEfBjr == null) {
			return SYSTEM_ENCODING;
		}
		int goVSXWLJ = GWNEfBjr.indexOf("<?xml version=\"1.0\"");
		if (goVSXWLJ != -1) {
			int peSdbSAE = GWNEfBjr.indexOf("encoding=\"");
			if (peSdbSAE >= 0) {
				int YHhPBbZ7 = GWNEfBjr.indexOf('"', peSdbSAE + 10);
				if (YHhPBbZ7 >= 0) {
					String THHaBcIh = GWNEfBjr.substring(peSdbSAE + 10, YHhPBbZ7);
					return THHaBcIh.trim();
				}
			}
		}
		lSHD3LhH.close();
		return SYSTEM_ENCODING;
	}

}