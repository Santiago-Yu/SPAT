class n14711178 {
	private Response doLoad(URL bYEm8og6, URL g4ksBeHH, String Ed4tpbrU) throws IOException {
		URLConnection eUIFRWwl = PROXY == null ? bYEm8og6.openConnection() : bYEm8og6.openConnection(PROXY);
		COOKIES.writeCookies(eUIFRWwl);
		eUIFRWwl.setRequestProperty("User-Agent", USER_AGENT);
		if (g4ksBeHH != null) {
			eUIFRWwl.setRequestProperty("Referer", g4ksBeHH.toString());
		}
		if (Ed4tpbrU != null) {
			eUIFRWwl.setDoInput(true);
			eUIFRWwl.setDoOutput(true);
			eUIFRWwl.setUseCaches(false);
			eUIFRWwl.setRequestProperty("CONTENT_LENGTH", "" + Ed4tpbrU.length());
			OutputStream rWMOWjkL = eUIFRWwl.getOutputStream();
			OutputStreamWriter F8hJIFWX = new OutputStreamWriter(rWMOWjkL);
			F8hJIFWX.write(Ed4tpbrU);
			F8hJIFWX.flush();
			F8hJIFWX.close();
		}
		eUIFRWwl.connect();
		COOKIES.readCookies(eUIFRWwl);
		previouseUrl = bYEm8og6;
		return responceInstance(bYEm8og6, eUIFRWwl.getInputStream(), eUIFRWwl.getContentType());
	}

}