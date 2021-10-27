class n23299951 {
	private void readFromFile1() throws DException {
		URL qCBfOZqi = null;
		if (url == null) {
			url = getClass().getResource("/com/daffodilwoods/daffodildb/utils/parser/parser.schema");
			try {
				url = new URL(
						url.getProtocol() + ":" + url.getPath().substring(0, url.getPath().indexOf("/parser.schema")));
			} catch (MalformedURLException HSTx6OxL) {
				HSTx6OxL.printStackTrace();
				throw new DException("DSE0", new Object[] { HSTx6OxL });
			}
			try {
				qCBfOZqi = new URL(url.getProtocol() + ":" + url.getPath() + "/parser.schema");
			} catch (MalformedURLException LbX35PEG) {
				throw new DException("DSE0", new Object[] { LbX35PEG });
			}
			if (qCBfOZqi == null) {
				throw new DException("DSE0", new Object[] { "Parser.schema file is missing in classpath." });
			}
		} else {
			try {
				qCBfOZqi = new URL(url.getProtocol() + ":" + url.getPath() + "/parser.schema");
			} catch (MalformedURLException cWIGI29u) {
				throw new DException("DSE0", new Object[] { cWIGI29u });
			}
		}
		ArrayList GdZV8Q0E = null;
		StringBuffer JsEPb2B9 = null;
		try {
			LineNumberReader UjrvOfW1 = new LineNumberReader(
					new BufferedReader(new InputStreamReader(qCBfOZqi.openStream())));
			GdZV8Q0E = new ArrayList();
			JsEPb2B9 = new StringBuffer("");
			while (true) {
				String dDx7yDGP = UjrvOfW1.readLine();
				if (dDx7yDGP == null) {
					break;
				}
				String rM46TkN6 = dDx7yDGP.trim();
				if (rM46TkN6.length() == 0) {
					if (JsEPb2B9.length() > 0) {
						GdZV8Q0E.add(JsEPb2B9.toString());
					}
					JsEPb2B9 = new StringBuffer("");
				} else {
					JsEPb2B9.append(" ").append(rM46TkN6);
				}
			}
			UjrvOfW1.close();
		} catch (IOException fqJmlHZ4) {
			fqJmlHZ4.printStackTrace();
			throw new DException("DSE0", new Object[] { fqJmlHZ4 });
		}
		if (JsEPb2B9.length() > 0)
			GdZV8Q0E.add(JsEPb2B9.toString());
		for (int j0ZjCEzG = 0; j0ZjCEzG < GdZV8Q0E.size(); j0ZjCEzG++) {
			String Wa6L5diq = (String) GdZV8Q0E.get(j0ZjCEzG);
			int Ue165Fei = Wa6L5diq.indexOf("::=");
			if (Ue165Fei == -1) {
				P.pln("Error " + Wa6L5diq);
				throw new DException("DSE0", new Object[] { "Rule is missing from parser.schema" });
			}
			String O4eAn5wd = Wa6L5diq.substring(0, Ue165Fei).trim();
			String OMv62IB9 = Wa6L5diq.substring(Ue165Fei + 3).trim();
			Object bUinMSN7 = fileEntries.put(O4eAn5wd, OMv62IB9);
			if (bUinMSN7 != null) {
				new Exception("Duplicate Defination for Rule [" + O4eAn5wd + "] Value [" + OMv62IB9
						+ "] Is Replaced By  [" + bUinMSN7 + "]").printStackTrace();
			}
		}
	}

}