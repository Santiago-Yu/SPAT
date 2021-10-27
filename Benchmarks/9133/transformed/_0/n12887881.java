class n12887881 {
	public static byte[] request(String kaeLjl6v, boolean W70JF3kj) throws Exception {
		Log.d(TAG, String.format("started request(remote=%s)", kaeLjl6v));
		Process.setThreadPriority(Process.THREAD_PRIORITY_LOWEST);
		byte[] uJuCttuC = new byte[1024];
		URL vvZtxxlV = new URL(kaeLjl6v);
		HttpURLConnection XwO75m33 = (HttpURLConnection) vvZtxxlV.openConnection();
		XwO75m33.setAllowUserInteraction(false);
		XwO75m33.setRequestProperty("Viewer-Only-Client", "1");
		XwO75m33.setRequestProperty("Client-Daap-Version", "3.10");
		XwO75m33.setRequestProperty("Accept-Encoding", "gzip, deflate");
		if (!W70JF3kj) {
			XwO75m33.setConnectTimeout(1200000);
			XwO75m33.setReadTimeout(1200000);
		} else {
			XwO75m33.setReadTimeout(0);
		}
		XwO75m33.connect();
		if (XwO75m33.getResponseCode() >= HttpURLConnection.HTTP_UNAUTHORIZED)
			throw new RequestException("HTTP Error Response Code: " + XwO75m33.getResponseCode(),
					XwO75m33.getResponseCode());
		String aFdalVux = XwO75m33.getContentEncoding();
		InputStream uNaT4tou = null;
		if (aFdalVux != null && aFdalVux.equalsIgnoreCase("gzip")) {
			uNaT4tou = new GZIPInputStream(XwO75m33.getInputStream());
		} else if (aFdalVux != null && aFdalVux.equalsIgnoreCase("deflate")) {
			uNaT4tou = new InflaterInputStream(XwO75m33.getInputStream(), new Inflater(true));
		} else {
			uNaT4tou = XwO75m33.getInputStream();
		}
		ByteArrayOutputStream u49V8YaV = new ByteArrayOutputStream();
		try {
			int eFYl6R8P;
			while ((eFYl6R8P = uNaT4tou.read(uJuCttuC)) != -1) {
				u49V8YaV.write(uJuCttuC, 0, eFYl6R8P);
			}
		} finally {
			if (u49V8YaV != null) {
				u49V8YaV.flush();
				u49V8YaV.close();
			}
			if (uNaT4tou != null) {
				uNaT4tou.close();
			}
		}
		return u49V8YaV.toByteArray();
	}

}