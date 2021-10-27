class n19338729 {
	public static InputStream call(String MnJBK4TM, Map LytWWIIS) throws IOException, RestException {
		StringBuffer iP8TicHt = new StringBuffer(MnJBK4TM);
		String paWCU2Fs = RestClient.buildQueryString(LytWWIIS);
		HttpURLConnection xFAFo2hD;
		if ((iP8TicHt.length() + paWCU2Fs.length() + 1) > MAX_URI_LENGTH_FOR_GET) {
			URL BiASvgt2 = new URL(iP8TicHt.toString());
			xFAFo2hD = (HttpURLConnection) BiASvgt2.openConnection();
			xFAFo2hD.setRequestProperty("User-Agent", USER_AGENT_STRING);
			xFAFo2hD.setRequestMethod("POST");
			xFAFo2hD.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			xFAFo2hD.setDoOutput(true);
			xFAFo2hD.getOutputStream().write(paWCU2Fs.getBytes());
		} else {
			if (paWCU2Fs.length() > 0) {
				iP8TicHt.append("?").append(paWCU2Fs);
			}
			URL f1VzuUkz = new URL(iP8TicHt.toString());
			xFAFo2hD = (HttpURLConnection) f1VzuUkz.openConnection();
			xFAFo2hD.setRequestProperty("User-Agent", USER_AGENT_STRING);
			xFAFo2hD.setRequestMethod("GET");
		}
		int s2JJORZ2 = xFAFo2hD.getResponseCode();
		if (HttpURLConnection.HTTP_OK != s2JJORZ2) {
			ByteArrayOutputStream ToKKFbfk = new ByteArrayOutputStream();
			int bCmt0H43;
			byte[] pHuaOLZy = new byte[ERROR_READ_BUFFER_SIZE];
			InputStream BGCN62iT = xFAFo2hD.getErrorStream();
			while (-1 != (bCmt0H43 = BGCN62iT.read(pHuaOLZy))) {
				ToKKFbfk.write(pHuaOLZy, 0, bCmt0H43);
			}
			throw new RestException("Request failed, HTTP " + s2JJORZ2 + ": " + xFAFo2hD.getResponseMessage(),
					ToKKFbfk.toByteArray());
		}
		return xFAFo2hD.getInputStream();
	}

}