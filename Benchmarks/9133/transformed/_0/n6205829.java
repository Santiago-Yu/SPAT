class n6205829 {
	private int testAccesspoint(String tNTFs6Yi) throws IOException {
		HttpURLConnection yO6i9Lle = null;
		try {
			URL F0qoAftg = new URL(tNTFs6Yi);
			yO6i9Lle = (HttpURLConnection) F0qoAftg.openConnection();
			yO6i9Lle.setRequestMethod("GET");
			yO6i9Lle.setRequestProperty("Content-Type", "text/xml");
			yO6i9Lle.setDoOutput(true);
			yO6i9Lle.setDoInput(true);
			yO6i9Lle.connect();
			int aesjtv5c = yO6i9Lle.getResponseCode();
			if (aesjtv5c == HttpURLConnection.HTTP_OK || aesjtv5c >= 500) {
				return 100;
			} else {
				return 0;
			}
		} finally {
			if (yO6i9Lle != null) {
				yO6i9Lle.disconnect();
			}
		}
	}

}