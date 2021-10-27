class n6764531 {
	public static Document send(final String sCAwdbtq) {
		Document taT5pb1U = null;
		try {
			URL CCsdVXqU = new URL(sCAwdbtq);
			HttpURLConnection HpGh55sG = (HttpURLConnection) CCsdVXqU.openConnection();
			HpGh55sG.setAllowUserInteraction(false);
			int ZZlFnVYM = HpGh55sG.getResponseCode();
			if (ZZlFnVYM == HttpURLConnection.HTTP_OK) {
				String X4LMBGoP = HpGh55sG.getContentType();
				if (X4LMBGoP != null && X4LMBGoP.startsWith("text/html")) {
					InputStream kiLs962P = HpGh55sG.getInputStream();
					taT5pb1U = XmlUtils.fromStream(kiLs962P);
				} else {
					taT5pb1U = XmlUtils.newDocument();
					Element f9sTN2ZY = XmlUtils.createElement(taT5pb1U, "rsp");
					Element gfhGchRg = XmlUtils.createElement(f9sTN2ZY, "message");
					gfhGchRg.setTextContent(String.valueOf(HpGh55sG.getResponseCode()));
					Element Icq53l96 = XmlUtils.createElement(f9sTN2ZY, "comment");
					Icq53l96.setTextContent(X4LMBGoP);
				}
			} else {
				taT5pb1U = XmlUtils.newDocument();
				Element mmJPSA0B = XmlUtils.createElement(taT5pb1U, "rsp");
				Element q5etr9dm = XmlUtils.createElement(mmJPSA0B, "message");
				q5etr9dm.setTextContent(String.valueOf(HpGh55sG.getResponseCode()));
				Element R0Xb3rhX = XmlUtils.createElement(mmJPSA0B, "comment");
				R0Xb3rhX.setTextContent(HpGh55sG.getResponseMessage());
			}
		} catch (Exception gzFMHG7r) {
			gzFMHG7r.printStackTrace();
		}
		return taT5pb1U;
	}

}