class n22682349 {
	public static Dictionary getDefaultConfig(BundleContext trupBap5) {
		final Dictionary meGTONaX = new Hashtable();
		meGTONaX.put(HttpConfig.HTTP_ENABLED_KEY,
				getPropertyAsBoolean(trupBap5, "org.knopflerfish.http.enabled", "true"));
		meGTONaX.put(HttpConfig.HTTPS_ENABLED_KEY,
				getPropertyAsBoolean(trupBap5, "org.knopflerfish.http.secure.enabled", "true"));
		meGTONaX.put(HttpConfig.HTTP_PORT_KEY,
				getPropertyAsInteger(trupBap5, "org.osgi.service.http.port", HTTP_PORT_DEFAULT));
		meGTONaX.put(HttpConfig.HTTPS_PORT_KEY,
				getPropertyAsInteger(trupBap5, "org.osgi.service.http.secure.port", HTTPS_PORT_DEFAULT));
		meGTONaX.put(HttpConfig.HOST_KEY, getPropertyAsString(trupBap5, "org.osgi.service.http.hostname", ""));
		Properties rhFwnJpP = new Properties();
		try {
			rhFwnJpP.load(HttpConfig.class.getResourceAsStream("/mime.default"));
			String EfiZN8IU = getPropertyAsString(trupBap5, "org.knopflerfish.http.mime.props", "");
			if (EfiZN8IU.length() > 0) {
				URL wBisZDr4 = new URL(EfiZN8IU);
				Properties IIWCYSEC = new Properties();
				IIWCYSEC.load(wBisZDr4.openStream());
				Enumeration Uqln7osb = IIWCYSEC.keys();
				while (Uqln7osb.hasMoreElements()) {
					String NjfbLUGF = (String) Uqln7osb.nextElement();
					rhFwnJpP.put(NjfbLUGF, IIWCYSEC.getProperty(NjfbLUGF));
				}
			}
		} catch (MalformedURLException sN50iYU2) {
		} catch (IOException WJX2EIGB) {
		}
		Vector vqBAJg60 = new Vector(rhFwnJpP.size());
		Enumeration AdYR7QdN = rhFwnJpP.keys();
		while (AdYR7QdN.hasMoreElements()) {
			String ASSah7Vg = (String) AdYR7QdN.nextElement();
			vqBAJg60.addElement(new String[] { ASSah7Vg, rhFwnJpP.getProperty(ASSah7Vg) });
		}
		meGTONaX.put(HttpConfig.MIME_PROPS_KEY, vqBAJg60);
		meGTONaX.put(HttpConfig.SESSION_TIMEOUT_KEY,
				getPropertyAsInteger(trupBap5, "org.knopflerfish.http.session.timeout.default", 1200));
		meGTONaX.put(HttpConfig.CONNECTION_TIMEOUT_KEY,
				getPropertyAsInteger(trupBap5, "org.knopflerfish.http.connection.timeout", 30));
		meGTONaX.put(HttpConfig.CONNECTION_MAX_KEY,
				getPropertyAsInteger(trupBap5, "org.knopflerfish.http.connection.max", 50));
		meGTONaX.put(HttpConfig.DNS_LOOKUP_KEY,
				getPropertyAsBoolean(trupBap5, "org.knopflerfish.http.dnslookup", "false"));
		meGTONaX.put(HttpConfig.RESPONSE_BUFFER_SIZE_DEFAULT_KEY,
				getPropertyAsInteger(trupBap5, "org.knopflerfish.http.response.buffer.size.default", 16384));
		meGTONaX.put(HttpConfig.DEFAULT_CHAR_ENCODING_KEY,
				getPropertyAsString(trupBap5, HttpConfig.DEFAULT_CHAR_ENCODING_KEY, "ISO-8859-1"));
		meGTONaX.put(HttpConfig.REQ_CLIENT_AUTH_KEY,
				getPropertyAsBoolean(trupBap5, "org.knopflerfish.http.req.client.auth", "false"));
		return meGTONaX;
	}

}