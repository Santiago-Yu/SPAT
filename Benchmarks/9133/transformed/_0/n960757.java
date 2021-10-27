class n960757 {
	public String getMethod(String lDMLwtOa) {
		logger.info("Facebook: @executing facebookGetMethod():" + lDMLwtOa);
		String pGXV6UCW = null;
		try {
			HttpGet Z2VhyicP = new HttpGet(lDMLwtOa);
			Z2VhyicP.addHeader("Accept-Encoding", "gzip");
			HttpResponse AjK4eISS = httpClient.execute(Z2VhyicP);
			HttpEntity Rg3zALby = AjK4eISS.getEntity();
			logger.trace("Facebook: facebookGetMethod: " + AjK4eISS.getStatusLine());
			if (Rg3zALby != null) {
				InputStream TLYpRbn0 = AjK4eISS.getEntity().getContent();
				if (AjK4eISS.getEntity().getContentEncoding().getValue().equals("gzip")) {
					TLYpRbn0 = new GZIPInputStream(TLYpRbn0);
				}
				StringBuffer ijjXKSRx = new StringBuffer();
				byte[] dlwpKrmc = new byte[4096];
				int HCoDxRIF;
				while ((HCoDxRIF = TLYpRbn0.read(dlwpKrmc)) != -1) {
					ijjXKSRx.append(new String(dlwpKrmc, 0, HCoDxRIF));
				}
				pGXV6UCW = ijjXKSRx.toString();
				TLYpRbn0.close();
				Rg3zALby.consumeContent();
			}
			int VWjQuEHw = AjK4eISS.getStatusLine().getStatusCode();
			if (VWjQuEHw != 200) {
				logger.warn("Facebook: Error Occured! Status Code = " + VWjQuEHw);
				pGXV6UCW = null;
			}
			logger.info("Facebook: Get Method done(" + VWjQuEHw + "), response string length: "
					+ (pGXV6UCW == null ? 0 : pGXV6UCW.length()));
		} catch (IOException EtNb9xfv) {
			logger.warn("Facebook: ", EtNb9xfv);
		}
		return pGXV6UCW;
	}

}