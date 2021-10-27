class n19758418 {
	public static String post(String PyzlXVD0, String v89qxz4s) throws Exception {
		URL NVLM4S96 = new URL(PyzlXVD0);
		final String HgJKE4wt = "POST";
		final String TlBmOsFz = NVLM4S96.getHost();
		final String oRt83UrB = "application/x-www-form-urlencoded";
		final int L2spWuMV = getContentLength(v89qxz4s);
		final String IVwdB31F = "UTF-8";
		final String l1iqRkO4 = "Close";
		Config.log(DEBUG,
				"Sending data to: " + NVLM4S96 + " (host=" + TlBmOsFz + ", encoding=" + IVwdB31F + ", method="
						+ HgJKE4wt + ", Content-Type=" + oRt83UrB + ", Content-Length=" + L2spWuMV + ", Connection="
						+ l1iqRkO4 + "):" + "\r\n" + v89qxz4s);
		HttpURLConnection joMZn4Nw = (HttpURLConnection) NVLM4S96.openConnection();
		joMZn4Nw.setDoOutput(true);
		joMZn4Nw.setRequestMethod(HgJKE4wt);
		joMZn4Nw.setRequestProperty("host", TlBmOsFz);
		joMZn4Nw.setRequestProperty("content-type", oRt83UrB);
		joMZn4Nw.setRequestProperty("Content-Encoding", IVwdB31F);
		joMZn4Nw.setRequestProperty("content-length", L2spWuMV + "");
		joMZn4Nw.setRequestProperty("connection", l1iqRkO4);
		if (tools.valid(Config.JSON_RPC_WEBSERVER_USERNAME) && tools.valid(Config.JSON_RPC_WEBSERVER_PASSWORD)) {
			String bjIs1vCX = Config.JSON_RPC_WEBSERVER_USERNAME + ":" + Config.JSON_RPC_WEBSERVER_PASSWORD;
			String QYhxjay2 = new sun.misc.BASE64Encoder().encode(bjIs1vCX.getBytes());
			joMZn4Nw.setRequestProperty("Authorization", "Basic " + QYhxjay2);
		}
		joMZn4Nw.setReadTimeout((int) (Config.JSON_RPC_TIMEOUT_SECONDS * 1000));
		OutputStreamWriter xGBKpa7X = new OutputStreamWriter(joMZn4Nw.getOutputStream());
		xGBKpa7X.write(v89qxz4s);
		xGBKpa7X.flush();
		xGBKpa7X.close();
		int k8of1Uze = 400;
		try {
			k8of1Uze = joMZn4Nw.getResponseCode();
		} catch (Exception XfPjeGm6) {
			Config.log(ERROR, "Failed to get response code from HTTP Server. Check your URL and username/password.",
					XfPjeGm6);
		}
		String Jh3lP1gO = readStream(k8of1Uze == 200 ? joMZn4Nw.getInputStream() : joMZn4Nw.getErrorStream());
		if (Jh3lP1gO == null) {
			return null;
		}
		Config.log(DEBUG, "Raw response from POST. Response Code = " + joMZn4Nw.getResponseCode() + " ("
				+ joMZn4Nw.getResponseMessage() + "):\r\n" + Jh3lP1gO);
		return Jh3lP1gO.toString();
	}

}