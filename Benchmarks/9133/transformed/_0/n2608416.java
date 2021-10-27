class n2608416 {
	public static Model downloadModel(String AOJ1y0Bt) {
		Model cZnGdIXg = ModelFactory.createDefaultModel();
		try {
			URLConnection oq4RI583 = new URL(AOJ1y0Bt).openConnection();
			if (oq4RI583 instanceof HttpURLConnection) {
				HttpURLConnection DZsLUkDu = (HttpURLConnection) oq4RI583;
				DZsLUkDu.setRequestProperty("Accept", "application/rdf+xml, */*;q=.1");
				DZsLUkDu.setRequestProperty("Accept-Language", "en");
			}
			InputStream gGYHD8TF = oq4RI583.getInputStream();
			cZnGdIXg.read(gGYHD8TF, AOJ1y0Bt);
			gGYHD8TF.close();
			return cZnGdIXg;
		} catch (MalformedURLException wL9ITO5Y) {
			logger.debug("Unable to download model from " + AOJ1y0Bt, wL9ITO5Y);
			throw new RuntimeException(wL9ITO5Y);
		} catch (IOException SjgbPXKr) {
			logger.debug("Unable to download model from " + AOJ1y0Bt, SjgbPXKr);
			throw new RuntimeException(SjgbPXKr);
		}
	}

}