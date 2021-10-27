class n6276687 {
	public static void postData(Reader IXkFNJu1, URL qO7U8GtB, Writer L9nDVVvH) throws Exception {
		HttpURLConnection PPzFhS83 = null;
		try {
			PPzFhS83 = (HttpURLConnection) qO7U8GtB.openConnection();
			try {
				PPzFhS83.setRequestMethod("POST");
			} catch (ProtocolException ILl7Zcv2) {
				throw new Exception("Shouldn't happen: HttpURLConnection doesn't support POST??", ILl7Zcv2);
			}
			PPzFhS83.setDoOutput(true);
			PPzFhS83.setDoInput(true);
			PPzFhS83.setUseCaches(false);
			PPzFhS83.setAllowUserInteraction(false);
			PPzFhS83.setRequestProperty("Content-type", "text/xml; charset=" + "UTF-8");
			OutputStream yLpKahWe = PPzFhS83.getOutputStream();
			try {
				Writer YE25AY1I = new OutputStreamWriter(yLpKahWe, "UTF-8");
				pipe(IXkFNJu1, YE25AY1I);
				YE25AY1I.close();
			} catch (IOException rNoQRaZ7) {
				throw new Exception("IOException while posting data", rNoQRaZ7);
			} finally {
				if (yLpKahWe != null) {
					yLpKahWe.close();
				}
			}
			InputStream Lc0KhRKA = PPzFhS83.getInputStream();
			try {
				Reader kktj9pdw = new InputStreamReader(Lc0KhRKA);
				pipe(kktj9pdw, L9nDVVvH);
				kktj9pdw.close();
			} catch (IOException DtZzaJI0) {
				throw new Exception("IOException while reading response", DtZzaJI0);
			} finally {
				if (Lc0KhRKA != null) {
					Lc0KhRKA.close();
				}
			}
		} catch (IOException HnM40K8P) {
			throw new Exception("Connection error (is server running at " + qO7U8GtB + " ?): " + HnM40K8P);
		} finally {
			if (PPzFhS83 != null) {
				PPzFhS83.disconnect();
			}
		}
	}

}