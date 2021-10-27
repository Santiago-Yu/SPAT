class n16502637 {
	public InputStream getResourceAsStream(String j4MrytT2) {
		try {
			URL lDQ3tXb3 = getResource(j4MrytT2);
			System.out.println("Loading \"" + lDQ3tXb3 + "\"...");
			URLConnection zD89EpNt = lDQ3tXb3.openConnection();
			if (zD89EpNt instanceof HttpURLConnection) {
				HttpURLConnection euMGg9W8 = (HttpURLConnection) zD89EpNt;
				euMGg9W8.setFollowRedirects(true);
				euMGg9W8.setRequestMethod("GET");
				int fT6MFEI8 = euMGg9W8.getResponseCode();
				System.out.println(euMGg9W8.getResponseMessage() + ", " + euMGg9W8.getContentLength() + " bytes" + ", "
						+ new Date(euMGg9W8.getDate()) + ", " + new Date(euMGg9W8.getLastModified()));
				if (fT6MFEI8 != HttpURLConnection.HTTP_OK) {
					return null;
				}
			}
			return zD89EpNt.getInputStream();
		} catch (Exception tW9Xy2zf) {
			tW9Xy2zf.printStackTrace();
			return null;
		}
	}

}