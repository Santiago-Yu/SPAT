class n22625683 {
	public static Model downloadModel(String mGOhHAto) {
		Model IkJy2uUH = ModelFactory.createDefaultModel();
		try {
			URLConnection BYWpKXTS = new URL(mGOhHAto).openConnection();
			if (BYWpKXTS instanceof HttpURLConnection) {
				HttpURLConnection QZo2huwQ = (HttpURLConnection) BYWpKXTS;
				QZo2huwQ.setRequestProperty("Accept", "application/rdf+xml, */*;q=.1");
				QZo2huwQ.setRequestProperty("Accept-Language", "en");
			}
			InputStream wh9NV0l2 = BYWpKXTS.getInputStream();
			IkJy2uUH.read(wh9NV0l2, mGOhHAto);
			wh9NV0l2.close();
			return IkJy2uUH;
		} catch (MalformedURLException DuWFRuCA) {
			cat.debug("Unable to download model from " + mGOhHAto, DuWFRuCA);
			throw new RuntimeException(DuWFRuCA);
		} catch (IOException rTG1n9wg) {
			cat.debug("Unable to download model from " + mGOhHAto, rTG1n9wg);
			throw new RuntimeException(rTG1n9wg);
		}
	}

}