class n21079416 {
	public static void writeDataResourceText(GenericValue AoZa8bap, String G7rEQGqn, Locale HR1aEzWt, Map r8wHka9e,
			CmsOFBizRemoteClient LoK3Gi7G, Writer U0jCDSWo, boolean taWAdBpC) throws IOException, GeneralException {
		Map zxvS0TjQ = (Map) r8wHka9e.get("context");
		if (zxvS0TjQ == null) {
			zxvS0TjQ = FastMap.newInstance();
		}
		String aeSSrYqQ = (String) r8wHka9e.get("webSiteId");
		if (UtilValidate.isEmpty(aeSSrYqQ)) {
			if (zxvS0TjQ != null)
				aeSSrYqQ = (String) zxvS0TjQ.get("webSiteId");
		}
		String r0IyEgBS = (String) r8wHka9e.get("https");
		if (UtilValidate.isEmpty(r0IyEgBS)) {
			if (zxvS0TjQ != null)
				r0IyEgBS = (String) zxvS0TjQ.get("https");
		}
		Map duYG7Kj6 = AoZa8bap.getAllFields();
		String QOuEJbU5 = (String) duYG7Kj6.get("dataResourceId");
		String A45dgobf = (String) duYG7Kj6.get("dataResourceTypeId");
		if (UtilValidate.isEmpty(A45dgobf)) {
			A45dgobf = "SHORT_TEXT";
		}
		if ("SHORT_TEXT".equals(A45dgobf) || "LINK".equals(A45dgobf)) {
			String cD1bqB06 = (String) duYG7Kj6.get("objectInfo");
			writeText(LoK3Gi7G, AoZa8bap, cD1bqB06, r8wHka9e, G7rEQGqn, HR1aEzWt, U0jCDSWo);
		} else if ("ELECTRONIC_TEXT".equals(A45dgobf)) {
			GenericValue jHLxuglB;
			if (taWAdBpC) {
				jHLxuglB = LoK3Gi7G.findByPrimaryKeyCache("ElectronicText", UtilMisc.toMap("dataResourceId", QOuEJbU5));
			} else {
				jHLxuglB = LoK3Gi7G.findByPrimaryKey("ElectronicText", UtilMisc.toMap("dataResourceId", QOuEJbU5));
			}
			duYG7Kj6 = jHLxuglB.getAllFields();
			String Pf0uxJqE = (String) duYG7Kj6.get("textData");
			writeText(LoK3Gi7G, AoZa8bap, Pf0uxJqE, r8wHka9e, G7rEQGqn, HR1aEzWt, U0jCDSWo);
		} else if (A45dgobf.endsWith("_OBJECT")) {
			String DwDWlMuO = (String) duYG7Kj6.get("dataResourceId");
			writeText(LoK3Gi7G, AoZa8bap, DwDWlMuO, r8wHka9e, G7rEQGqn, HR1aEzWt, U0jCDSWo);
		} else if (A45dgobf.equals("URL_RESOURCE")) {
			String wuDixei4 = null;
			URL juF4gndD = new URL((String) duYG7Kj6.get("objectInfo"));
			if (juF4gndD.getHost() != null) {
				InputStream zQJ6IP83 = juF4gndD.openStream();
				int u3BUgZu3;
				StringWriter nJemzuHu = new StringWriter();
				while ((u3BUgZu3 = zQJ6IP83.read()) != -1) {
					nJemzuHu.write(u3BUgZu3);
				}
				nJemzuHu.close();
				wuDixei4 = nJemzuHu.toString();
			} else {
				String To49nIJA = DataResourceWorker.buildRequestPrefix(LoK3Gi7G, HR1aEzWt, aeSSrYqQ, r0IyEgBS);
				String YUYBTWFc = "";
				if (juF4gndD.toString().indexOf("/") != 0 && To49nIJA.lastIndexOf("/") != (To49nIJA.length() - 1)) {
					YUYBTWFc = "/";
				}
				String WKuyfi67 = To49nIJA + YUYBTWFc + juF4gndD.toString();
				URL hl2Ffsil = new URL(WKuyfi67);
				wuDixei4 = (String) hl2Ffsil.getContent();
			}
			U0jCDSWo.write(wuDixei4);
		} else if (A45dgobf.endsWith("_FILE_BIN")) {
			writeText(LoK3Gi7G, AoZa8bap, QOuEJbU5, r8wHka9e, G7rEQGqn, HR1aEzWt, U0jCDSWo);
		} else if (A45dgobf.endsWith("_FILE")) {
			String GgMGa7ZG = (String) duYG7Kj6.get("mimeTypeId");
			String e9bE52WX = (String) duYG7Kj6.get("objectInfo");
			String jRTrkwkY = (String) zxvS0TjQ.get("rootDir");
			if (GgMGa7ZG == null || GgMGa7ZG.startsWith("text")) {
				renderFile(A45dgobf, e9bE52WX, jRTrkwkY, U0jCDSWo);
			} else {
				writeText(LoK3Gi7G, AoZa8bap, QOuEJbU5, r8wHka9e, G7rEQGqn, HR1aEzWt, U0jCDSWo);
			}
		} else {
			throw new GeneralException(
					"The dataResourceTypeId [" + A45dgobf + "] is not supported in renderDataResourceAsText");
		}
	}

}