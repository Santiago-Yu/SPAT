class n13336601 {
	private final void lookup() throws Exception {
		try {
			URL pp95n12P;
			URLConnection rC5Dhc7K;
			DataOutputStream ihlInjQB;
			BufferedReader eWHc286c;
			pp95n12P = new URL("http://www.amazon.com/exec/obidos/search-handle-form");
			rC5Dhc7K = pp95n12P.openConnection();
			rC5Dhc7K.setDoInput(true);
			rC5Dhc7K.setDoOutput(true);
			rC5Dhc7K.setUseCaches(false);
			rC5Dhc7K.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			ihlInjQB = new DataOutputStream(rC5Dhc7K.getOutputStream());
			String eH8mCi78 = "page=" + URLEncoder.encode("1") + "&index=" + URLEncoder.encode("music")
					+ "&field-artist=" + URLEncoder.encode(artist) + "&field-title=" + URLEncoder.encode(title)
					+ "&field-binding=" + URLEncoder.encode("");
			ihlInjQB.writeBytes(eH8mCi78);
			ihlInjQB.flush();
			ihlInjQB.close();
			eWHc286c = new BufferedReader(new InputStreamReader(rC5Dhc7K.getInputStream()));
			String xymt98wL;
			String MMBaoSF5 = "handle-buy-box=";
			int qC0cWcVt = 0;
			while (null != ((xymt98wL = eWHc286c.readLine()))) {
				int paCbtU5u = xymt98wL.indexOf(MMBaoSF5);
				if (paCbtU5u > 0) {
					paCbtU5u = paCbtU5u + MMBaoSF5.length();
					String vAP9Iwj5 = xymt98wL.substring(paCbtU5u, paCbtU5u + 10);
					status.append("Match: ");
					status.append(vAP9Iwj5);
					status.append(". ");
					if (verifyMatch(vAP9Iwj5, title)) {
						discID = vAP9Iwj5;
						imageURL = "http://images.amazon.com/images/P/" + vAP9Iwj5 + ".01.LZZZZZZZ.jpg";
						matchType = EXACT_MATCH;
					}
				}
			}
			eWHc286c.close();
		} catch (Exception HSks9Lcw) {
			throw HSks9Lcw;
		}
	}

}