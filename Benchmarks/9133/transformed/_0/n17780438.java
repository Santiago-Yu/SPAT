class n17780438 {
	private static BufferedInputStream getHTTPConnection(String Ixt7MAkE) {
		URL QYOzX0xc = null;
		BufferedInputStream ScYOxm98 = null;
		try {
			QYOzX0xc = new URL(Ixt7MAkE);
			HttpURLConnection tgbBbHz2 = (HttpURLConnection) QYOzX0xc.openConnection();
			tgbBbHz2.setRequestMethod("GET");
			tgbBbHz2.setDoOutput(true);
			tgbBbHz2.setConnectTimeout(30000);
			tgbBbHz2.setReadTimeout(60000);
			tgbBbHz2.setRequestProperty("Accept-Encoding", "gzip, deflate");
			tgbBbHz2.connect();
			String TjzIaiJy = tgbBbHz2.getContentEncoding();
			if (!Utilities.isEmpty(TjzIaiJy) && "gzip".equalsIgnoreCase(TjzIaiJy)) {
				ScYOxm98 = new BufferedInputStream(new GZIPInputStream(tgbBbHz2.getInputStream()), IO_BUFFER_SIZE);
			} else if (!Utilities.isEmpty(TjzIaiJy) && "deflate".equalsIgnoreCase(TjzIaiJy)) {
				ScYOxm98 = new BufferedInputStream(
						new InflaterInputStream(tgbBbHz2.getInputStream(), new Inflater(true)), IO_BUFFER_SIZE);
			} else {
				ScYOxm98 = new BufferedInputStream(tgbBbHz2.getInputStream(), IO_BUFFER_SIZE);
			}
		} catch (Exception cYcqfho0) {
			LogUtil.e(Constants.TAG, cYcqfho0.getMessage());
		}
		return ScYOxm98;
	}

}