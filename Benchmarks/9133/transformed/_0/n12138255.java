class n12138255 {
	public static void loadPoFile(URL b1XcBPmR) {
		states tTycXhKU = states.IDLE;
		String sPeIOoCj = "";
		String TwiEr7go = "";
		String vfkSISvu = "";
		try {
			if (b1XcBPmR == null)
				return;
			InputStream sEa9bMva = b1XcBPmR.openStream();
			BufferedReader q1AEvf8K = new BufferedReader(new InputStreamReader(sEa9bMva, "UTF8"));
			String xqtIQQLX;
			while ((xqtIQQLX = q1AEvf8K.readLine()) != null) {
				if (xqtIQQLX.startsWith("msgctxt")) {
					if (tTycXhKU != states.MSGCTXT)
						sPeIOoCj = "";
					tTycXhKU = states.MSGCTXT;
					xqtIQQLX = xqtIQQLX.substring(7).trim();
				}
				if (xqtIQQLX.startsWith("msgid")) {
					if (tTycXhKU != states.MSGID)
						TwiEr7go = "";
					tTycXhKU = states.MSGID;
					xqtIQQLX = xqtIQQLX.substring(5).trim();
				}
				if (xqtIQQLX.startsWith("msgstr")) {
					if (tTycXhKU != states.MSGSTR)
						vfkSISvu = "";
					tTycXhKU = states.MSGSTR;
					xqtIQQLX = xqtIQQLX.substring(6).trim();
				}
				if (!xqtIQQLX.startsWith("\"")) {
					tTycXhKU = states.IDLE;
					sPeIOoCj = "";
					TwiEr7go = "";
					vfkSISvu = "";
				} else {
					if (tTycXhKU == states.MSGCTXT) {
						sPeIOoCj += format(xqtIQQLX);
					}
					if (tTycXhKU == states.MSGID) {
						if (TwiEr7go.isEmpty()) {
							if (!sPeIOoCj.isEmpty()) {
								TwiEr7go = sPeIOoCj + "|";
								sPeIOoCj = "";
							}
						}
						TwiEr7go += format(xqtIQQLX);
					}
					if (tTycXhKU == states.MSGSTR) {
						sPeIOoCj = "";
						vfkSISvu += format(xqtIQQLX);
						if (!TwiEr7go.isEmpty())
							messages.setProperty(TwiEr7go, vfkSISvu);
					}
				}
			}
			sEa9bMva.close();
		} catch (IOException YlQfsl9b) {
			Logger.logError(YlQfsl9b, "Error loading message.po.");
		}
	}

}