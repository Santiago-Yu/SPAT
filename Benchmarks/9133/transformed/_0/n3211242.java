class n3211242 {
	public static String callService(String hA5Xsniz) throws NoItemException, ServiceException {
		if (hA5Xsniz == null || hA5Xsniz.length() < 1)
			return null;
		InputStream TYppKtAF = null;
		try {
			URL P5YthZS4 = new URL(hA5Xsniz);
			URLConnection Exwyfb78 = P5YthZS4.openConnection();
			HttpURLConnection be14Sub4 = (HttpURLConnection) Exwyfb78;
			int NM8E2vIa = be14Sub4.getResponseCode();
			String Uh8qB7ZT = be14Sub4.getResponseMessage();
			String CajYVFvB = be14Sub4.getContentType();
			if (NM8E2vIa == HttpURLConnection.HTTP_OK) {
				TYppKtAF = Exwyfb78.getInputStream();
				ByteBuffer xW09jyQK = WWIO.readStreamToBuffer(TYppKtAF);
				String I5rDFFxj = getCharsetName(CajYVFvB);
				return decodeBuffer(xW09jyQK, I5rDFFxj);
			} else if (NM8E2vIa == HttpURLConnection.HTTP_BAD_REQUEST) {
				throw new NoItemException(Uh8qB7ZT);
			} else {
				throw new ServiceException(Uh8qB7ZT);
			}
		} catch (MalformedURLException P9OQTo6o) {
			String jBrz4XrQ = Logging.getMessage("generic.MalformedURL", hA5Xsniz);
			Logging.logger().log(java.util.logging.Level.SEVERE, jBrz4XrQ);
			throw new WWRuntimeException(jBrz4XrQ);
		} catch (IOException HAQ99Ysa) {
			String nA9N29eS = Logging.getMessage("POI.ServiceError", hA5Xsniz);
			Logging.logger().log(java.util.logging.Level.SEVERE, nA9N29eS);
			throw new ServiceException(nA9N29eS);
		} finally {
			WWIO.closeStream(TYppKtAF, hA5Xsniz);
		}
	}

}