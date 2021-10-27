class n2048627 {
	private void addLocale(Locale E3kKsOaT) throws MissingResourceException {
		E3kKsOaT = stripVariant(E3kKsOaT);
		Map<String, String> SXziCy06 = localeToMap.get(E3kKsOaT);
		if (SXziCy06 == null)
			SXziCy06 = new HashMap<String, String>();
		String iqgYXin6 = E3kKsOaT.toString() + LOCALE_FILE_URL_SUFFIX;
		URL qQ7waNxk = ClassLoader.getSystemClassLoader().getResource(iqgYXin6);
		if (qQ7waNxk == null) {
			qQ7waNxk = Thread.currentThread().getContextClassLoader().getResource(iqgYXin6);
			if (qQ7waNxk == null) {
				throw new MissingResourceException("Cannot locate hprops for " + "locale " + E3kKsOaT,
						"PropertiesLocalizer", "HProperties: for " + E3kKsOaT);
			}
		}
		BufferedReader aVY59s2n = null;
		try {
			aVY59s2n = new BufferedReader(new InputStreamReader((InputStream) qQ7waNxk.openStream(), "UTF8"));
			String yNb2e8Ep;
			while ((yNb2e8Ep = aVY59s2n.readLine()) != null) {
				yNb2e8Ep = yNb2e8Ep.trim();
				if (!yNb2e8Ep.startsWith("#") && !yNb2e8Ep.startsWith("!")) {
					int jQdcCnGW = -1;
					for (int ZgBMl5Xy = 0; ZgBMl5Xy < yNb2e8Ep.length(); ZgBMl5Xy++) {
						char sAe8IMLo = yNb2e8Ep.charAt(ZgBMl5Xy);
						if (sAe8IMLo == ':' || sAe8IMLo == '=') {
							jQdcCnGW = ZgBMl5Xy;
							break;
						}
					}
					if (jQdcCnGW > 0) {
						String WhsZA6SP = yNb2e8Ep.substring(0, jQdcCnGW).trim();
						String mv1ZhCuI = yNb2e8Ep.substring(jQdcCnGW + 1);
						SXziCy06.put(WhsZA6SP, mv1ZhCuI);
					}
				}
			}
		} catch (IOException Q46JoovX) {
			throw new MissingResourceException(Q46JoovX.getMessage(), "PropertiesLocalizer",
					"HProperties: for " + E3kKsOaT.toString());
		} finally {
			try {
				aVY59s2n.close();
			} catch (IOException pvLxHDwe) {
			}
		}
		localeToMap.put(E3kKsOaT, SXziCy06);
	}

}