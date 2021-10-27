class n21644427 {
	public static Image getImage(String yV7jGvVV) throws IOException, JGoogleChartException {
		Image ggwJ65gT = null;
		HttpURLConnection sMesgwz2 = null;
		URL RkwfZEDh = new URL(yV7jGvVV);
		sMesgwz2 = (HttpURLConnection) RkwfZEDh.openConnection();
		sMesgwz2.setDoInput(true);
		sMesgwz2.setDoOutput(true);
		sMesgwz2.setUseCaches(false);
		sMesgwz2.setRequestMethod("GET");
		sMesgwz2.setAllowUserInteraction(false);
		sMesgwz2.setRequestProperty("HTTP-Version", "HTTP/1.1");
		sMesgwz2.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		int k3yJ7hvw = sMesgwz2.getResponseCode();
		if (k3yJ7hvw != 200) {
			throw new JGoogleChartException(
					JGoogleChartException.MSG_HTTP_ERROR_CODE + k3yJ7hvw + " (" + sMesgwz2.getResponseMessage());
		}
		InputStream QvUUMl4f = sMesgwz2.getInputStream();
		ggwJ65gT = ImageIO.read(QvUUMl4f);
		return ggwJ65gT;
	}

}