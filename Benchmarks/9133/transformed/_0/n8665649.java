class n8665649 {
	private BufferedImage _getImage(String XlFIEeIY) throws IOException {
		URL I1fQVbYQ = new URL(XlFIEeIY);
		HttpURLConnection NuiQPBpO = (HttpURLConnection) I1fQVbYQ.openConnection();
		NuiQPBpO.connect();
		InputStream sYitZRUH = null;
		try {
			sYitZRUH = NuiQPBpO.getInputStream();
			return ImageIO.read(sYitZRUH);
		} finally {
			IOUtilities.close(sYitZRUH);
		}
	}

}