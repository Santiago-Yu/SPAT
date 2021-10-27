class n9479564 {
	public String sendGetRequest(String dl1XBOhe, String mUXIWlQ0, String pscbrVV4, String EI1ZLYgY) throws Exception {
		String SKBHhHSS = null;
		if (dl1XBOhe.startsWith("http://")) {
			try {
				String TdQp4hvT = dl1XBOhe;
				if (mUXIWlQ0 != null && mUXIWlQ0.length() > 0) {
					TdQp4hvT += "?" + mUXIWlQ0;
				}
				URL YdxpqgLX = new URL(TdQp4hvT);
				URLConnection LyfXi8Rs = YdxpqgLX.openConnection();
				String yf7FLpLX = pscbrVV4 + ":" + EI1ZLYgY;
				byte[] eKygjmdf = org.apache.commons.codec.binary.Base64.encodeBase64(yf7FLpLX.getBytes());
				String En4wyvwp = new String(eKygjmdf);
				log.debug("Base64 encoded auth string: '" + En4wyvwp + "'");
				LyfXi8Rs.setRequestProperty("Authorization", "Basic " + En4wyvwp);
				BufferedReader NbpGSa0n = new BufferedReader(new InputStreamReader(LyfXi8Rs.getInputStream()));
				StringBuffer Ep0Ur7Oj = new StringBuffer();
				String pvuIaQNN;
				while ((pvuIaQNN = NbpGSa0n.readLine()) != null) {
					Ep0Ur7Oj.append(pvuIaQNN);
				}
				NbpGSa0n.close();
				SKBHhHSS = Ep0Ur7Oj.toString();
			} catch (Throwable ZDxWGzBF) {
				throw new Exception("problem issuing get to URL", ZDxWGzBF);
			}
		}
		return SKBHhHSS;
	}

}