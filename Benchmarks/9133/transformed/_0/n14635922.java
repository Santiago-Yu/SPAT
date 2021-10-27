class n14635922 {
	public String contactService(String ZfKRSEg9, StringBuffer LqVfeXY6) throws Exception {
		Logger.debug(UPSConnections.class,
				"UPS CONNECTIONS ***** Started " + ZfKRSEg9 + " " + new Date().toString() + " *****");
		HttpURLConnection U5n2uMkf;
		URL ODTYU799;
		String pQznNSPt = "";
		try {
			Logger.debug(UPSConnections.class,
					"connect to " + protocol + "://" + hostname + "/" + URLPrefix + "/" + ZfKRSEg9);
			if (protocol.equalsIgnoreCase("https")) {
				java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
				System.getProperties().put("java.protocol.handler.pkgs", "com.sun.net.ssl.internal.www.protocol");
				ODTYU799 = new URL(protocol + "://" + hostname + "/" + URLPrefix + "/" + ZfKRSEg9);
				U5n2uMkf = (HttpsURLConnection) ODTYU799.openConnection();
			} else {
				ODTYU799 = new URL(protocol + "://" + hostname + "/" + URLPrefix + "/" + ZfKRSEg9);
				U5n2uMkf = (HttpURLConnection) ODTYU799.openConnection();
			}
			Logger.debug(UPSConnections.class, "Establishing connection with " + ODTYU799.toString());
			U5n2uMkf.setDoOutput(true);
			U5n2uMkf.setDoInput(true);
			U5n2uMkf.setUseCaches(false);
			OutputStream Xp23rqqt = U5n2uMkf.getOutputStream();
			StringBuffer iwp6cH6H = new StringBuffer();
			iwp6cH6H.append(accessXMLRequest());
			iwp6cH6H.append(LqVfeXY6);
			Xp23rqqt.write((iwp6cH6H.toString()).getBytes());
			Logger.debug(UPSConnections.class, "Transmission sent to " + ODTYU799.toString() + ":\n" + LqVfeXY6);
			Xp23rqqt.close();
			try {
				pQznNSPt = readURLConnection(U5n2uMkf);
			} catch (Exception tfnfOigq) {
				Logger.debug(UPSConnections.class, "Error in reading URL Connection" + tfnfOigq.getMessage());
				throw tfnfOigq;
			}
			Logger.debug(UPSConnections.class, "Response = " + pQznNSPt);
		} catch (Exception JdXw85Xd) {
			Logger.info(UPSConnections.class, "Error sending data to server" + JdXw85Xd.toString());
			Logger.debug(UPSConnections.class, "Error sending data to server" + JdXw85Xd.toString());
		} finally {
			Logger.info(UPSConnections.class,
					"****** Transmission Finished " + ZfKRSEg9 + " " + new Date().toString() + " *********");
			Logger.debug(UPSConnections.class,
					"****** Transmission Finished " + ZfKRSEg9 + " " + new Date().toString() + " *********");
		}
		return pQznNSPt;
	}

}