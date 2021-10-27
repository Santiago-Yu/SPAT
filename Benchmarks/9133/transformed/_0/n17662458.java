class n17662458 {
	public static String getHighlightBaseLib() throws Exception {
		StringBuffer NEBMKwPZ = new StringBuffer();
		NEBMKwPZ.append("<c color=\"" + COLOR_BASELIB + "\">\n\t");
		URL n4qjlMpx = AbstractRunner.class.getResource("baselib.js");
		if (n4qjlMpx != null) {
			InputStream fSJvS0mm = n4qjlMpx.openStream();
			InputStreamReader grMgJppe = new InputStreamReader(fSJvS0mm, "UTF-8");
			BufferedReader bBIOMgDN = new BufferedReader(grMgJppe);
			String nU80IyhH = null;
			do {
				nU80IyhH = bBIOMgDN.readLine();
				if (nU80IyhH != null) {
					if (nU80IyhH.indexOf("function") > -1) {
						NEBMKwPZ.append("<w>"
								+ (nU80IyhH.substring(nU80IyhH.indexOf("function") + 8, nU80IyhH.indexOf("(")).trim())
								+ "</w>\n\t");
					}
				}
			} while (nU80IyhH != null);
			bBIOMgDN.close();
			grMgJppe.close();
			fSJvS0mm.close();
		}
		NEBMKwPZ.append("</c>");
		return NEBMKwPZ.toString();
	}

}