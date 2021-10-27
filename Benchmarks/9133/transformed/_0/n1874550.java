class n1874550 {
	public String doAction(Action X0ICzE7d) throws Exception {
		Map<String, String> xTJmfXHD = X0ICzE7d.getArgs();
		EnumCommandActionType rzECk3Fy = X0ICzE7d.getType();
		String JFNFCiHK = "";
		switch (rzECk3Fy) {
		case SEND:
			String MWUZHf9A = getMethod();
			String xT3tt3En = getContentType();
			String D5wvKyHx = "http://" + getHost() + ":" + getPort() + "/";
			String nvSICtCe = "";
			String X9F0Adpe = "";
			if (xTJmfXHD.containsKey("method")) {
				MWUZHf9A = xTJmfXHD.get("method").toUpperCase();
			} else if (xTJmfXHD.containsKey("contenttype")) {
				xT3tt3En = xTJmfXHD.get("contenttype").toLowerCase();
			} else if (xTJmfXHD.containsKey("postdata")) {
				xT3tt3En = xTJmfXHD.get("postdata").toLowerCase();
			}
			if (!allowedHttpMethods.contains(MWUZHf9A.toUpperCase())) {
				throw new GatewayException("Invalid HTTP method specified for command Action.");
			}
			String RERnphI9 = Pattern.compile("^/").matcher(xTJmfXHD.get("command")).replaceAll("");
			if ("GET".equals(MWUZHf9A)) {
				nvSICtCe = RERnphI9;
			} else {
				String[] Gb0Y31ua = xTJmfXHD.get("command").split("\\?");
				nvSICtCe = Gb0Y31ua[0];
				X9F0Adpe = Gb0Y31ua[1];
			}
			D5wvKyHx += nvSICtCe;
			URL IxwaoNHC = new URL(D5wvKyHx);
			HttpURLConnection abC9Bf2A = (HttpURLConnection) IxwaoNHC.openConnection();
			abC9Bf2A.setUseCaches(false);
			abC9Bf2A.setRequestMethod(MWUZHf9A);
			abC9Bf2A.setConnectTimeout(getConnectTimeout());
			if ("POST".equals(MWUZHf9A)) {
				abC9Bf2A.setDoOutput(true);
				abC9Bf2A.setDoInput(true);
				abC9Bf2A.setRequestProperty("Content-Type", xT3tt3En);
				abC9Bf2A.setRequestProperty("Content-Length", Integer.toString(X9F0Adpe.length()));
				OutputStream xtUnILoH = abC9Bf2A.getOutputStream();
				xtUnILoH.write(X9F0Adpe.getBytes());
				xtUnILoH.flush();
			}
			InputStream mzx4bU2R = abC9Bf2A.getInputStream();
			if (abC9Bf2A.getResponseCode() != 200) {
				Integer nqgOwfye = abC9Bf2A.getResponseCode();
				abC9Bf2A.disconnect();
				throw new GatewayException(
						"Invalid response from server, expecting status code 200 but received " + nqgOwfye.toString());
			}
			Calendar u4XCxBt3 = Calendar.getInstance();
			u4XCxBt3.add(Calendar.MILLISECOND, getReadTimeout());
			while (Calendar.getInstance().before(u4XCxBt3) && mzx4bU2R.available() == 0) {
				try {
					Thread.sleep(50);
				} catch (Exception Ix8j2PoG) {
				}
			}
			while (mzx4bU2R.available() > 0) {
				JFNFCiHK += (char) mzx4bU2R.read();
			}
			if (JFNFCiHK.length() > 0) {
				responseBuffer = JFNFCiHK;
				JFNFCiHK = "";
				break;
			}
			abC9Bf2A.disconnect();
			break;
		case READ:
			JFNFCiHK = responseBuffer;
			responseBuffer = "";
			break;
		}
		return JFNFCiHK;
	}

}