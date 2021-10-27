class n19549579 {
	protected InputStream callApiMethod(String ilHoaT4J, String jPJUkGkc, String H691eRko, String hF4OjKSC,
			int mzPzWZYp) {
		try {
			URL rip6p9Rx = new URL(ilHoaT4J);
			HttpURLConnection npIM18mv = (HttpURLConnection) rip6p9Rx.openConnection();
			if (ApplicationConstants.CONNECT_TIMEOUT > -1) {
				npIM18mv.setConnectTimeout(ApplicationConstants.CONNECT_TIMEOUT);
			}
			if (ApplicationConstants.READ_TIMEOUT > -1) {
				npIM18mv.setReadTimeout(ApplicationConstants.READ_TIMEOUT);
			}
			for (String UGHrOf4j : requestHeaders.keySet()) {
				npIM18mv.setRequestProperty(UGHrOf4j, requestHeaders.get(UGHrOf4j));
			}
			npIM18mv.setRequestMethod(hF4OjKSC);
			npIM18mv.setDoOutput(true);
			if (H691eRko != null) {
				npIM18mv.setRequestProperty("Content-Type", H691eRko);
			}
			if (jPJUkGkc != null) {
				PrintStream skJw5TPx = new PrintStream(new BufferedOutputStream(npIM18mv.getOutputStream()));
				skJw5TPx.print(jPJUkGkc);
				skJw5TPx.flush();
				skJw5TPx.close();
			}
			npIM18mv.connect();
			if (npIM18mv.getResponseCode() != mzPzWZYp) {
				throw new BingMapsException(convertStreamToString(npIM18mv.getErrorStream()));
			} else {
				return getWrappedInputStream(npIM18mv.getInputStream(),
						GZIP_ENCODING.equalsIgnoreCase(npIM18mv.getContentEncoding()));
			}
		} catch (IOException yP54AbRZ) {
			throw new BingMapsException(yP54AbRZ);
		}
	}

}