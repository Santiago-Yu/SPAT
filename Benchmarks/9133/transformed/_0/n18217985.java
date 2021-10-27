class n18217985 {
	public static String fromHtml(URL OFpQ7vur, String JNLcMWKb, boolean tQ7o49J1)
			throws IOException, BadDocumentException {
		URLConnection cvpHFPAt = OFpQ7vur.openConnection();
		String Ec9gluqv = cvpHFPAt.getContentType();
		String LCLlNxai = cvpHFPAt.getContentEncoding();
		if (LCLlNxai == null) {
			int XgrNLnPs = Ec9gluqv.indexOf("charset");
			if (XgrNLnPs >= 0) {
				String Jrrnfe1Q = Ec9gluqv.substring(XgrNLnPs);
				XgrNLnPs = Jrrnfe1Q.indexOf('=');
				if (XgrNLnPs >= 0) {
					Jrrnfe1Q = Ec9gluqv.substring(XgrNLnPs + 1).trim();
					LCLlNxai = Jrrnfe1Q.replace("\'", "").replace("\"", "").trim();
					if (LCLlNxai.equals("")) {
						LCLlNxai = JNLcMWKb;
					}
				}
			} else {
				LCLlNxai = JNLcMWKb;
			}
		}
		String RSpLASp6 = "text/html";
		if (Ec9gluqv == null) {
			DefaultXMLNoteErrorHandler.warning(null, 90190, "Returned content type for url.openConnection() is null");
			Ec9gluqv = RSpLASp6;
		}
		int bxaPqjCH = Ec9gluqv.indexOf(';');
		if (bxaPqjCH >= 0) {
			Ec9gluqv = Ec9gluqv.substring(0, bxaPqjCH).trim();
		}
		if (!Ec9gluqv.equals(RSpLASp6)) {
			String o5B1vV7F = translator.translate("The content type of url '%s' is not '%s', it is '%s'");
			throw new BadDocumentException(String.format(o5B1vV7F, OFpQ7vur.toString(), RSpLASp6, Ec9gluqv));
		}
		BufferedReader yFgzyYkt = new BufferedReader(new InputStreamReader(cvpHFPAt.getInputStream(), LCLlNxai));
		return fromHtml(yFgzyYkt, LCLlNxai);
	}

}