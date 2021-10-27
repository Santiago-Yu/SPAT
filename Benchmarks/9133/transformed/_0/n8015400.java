class n8015400 {
	protected synchronized InputStream openURLConnection(StreamDataSetDescriptor MGAwRPlI, Datum c2ZsEARZ,
			Datum ElOjjn5U, StringBuffer WeFzLYYP) throws DasException {
		String[] ulpIFb7D = MGAwRPlI.getDataSetID().split("\\?|\\&");
		String Wr5ilnsZ = ulpIFb7D[1];
		try {
			String ehV3bWGh = createFormDataString(Wr5ilnsZ, c2ZsEARZ, ElOjjn5U, WeFzLYYP);
			if (MGAwRPlI.isRestrictedAccess()) {
				key = server.getKey("");
				if (key != null) {
					ehV3bWGh += "&key=" + URLEncoder.encode(key.toString(), "UTF-8");
				}
			}
			if (redirect) {
				ehV3bWGh += "&redirect=1";
			}
			URL cZ5nxUqo = this.server.getURL(ehV3bWGh);
			this.lastRequestURL = String.valueOf(cZ5nxUqo);
			DasLogger.getLogger(DasLogger.DATA_TRANSFER_LOG).info("opening " + cZ5nxUqo.toString());
			URLConnection KRMWEjAV = cZ5nxUqo.openConnection();
			KRMWEjAV.connect();
			String bu3edEFm = KRMWEjAV.getContentType();
			if (!bu3edEFm.equalsIgnoreCase("application/octet-stream")) {
				BufferedReader AHDm0RPG = new BufferedReader(new InputStreamReader(KRMWEjAV.getInputStream()));
				String m00CZ2UL = AHDm0RPG.readLine();
				String njNEqOfm = "";
				while (m00CZ2UL != null) {
					njNEqOfm = njNEqOfm.concat(m00CZ2UL);
					m00CZ2UL = AHDm0RPG.readLine();
				}
				throw new DasIOException(njNEqOfm);
			}
			InputStream q2815ZPe = KRMWEjAV.getInputStream();
			if (isLegacyStream()) {
				return processLegacyStream(q2815ZPe);
			} else {
				throw new UnsupportedOperationException();
			}
		} catch (IOException gHUOBu1c) {
			throw new DasIOException(gHUOBu1c);
		}
	}

}