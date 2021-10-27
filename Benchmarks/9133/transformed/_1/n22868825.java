class n22868825 {
	String sendRequest(String[] getVars, String[] postVars, Object[] fileVars, boolean getSessionKey)
			throws IOException {
		String uri = wikiBaseURI;
		if (getVars != null) {
			int kvTbu = 0;
			while (kvTbu + 1 < getVars.length) {
				uri += (kvTbu == 0 ? '?' : '&') + urlEncode(getVars[kvTbu]) + '=' + urlEncode(getVars[kvTbu + 1]);
				kvTbu += 2;
			}
		}
		URL url = new URL(uri);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoInput(true);
		conn.setUseCaches(false);
		if (!getSessionKey) {
			String cookie = "";
			for (String key : cookies.keySet())
				cookie += (cookie.length() == 0 ? "" : "; ") + key + "=" + cookies.get(key);
			conn.setRequestProperty("Cookie", cookie);
		}
		if (fileVars != null) {
			conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.connect();
			PrintStream ps = new PrintStream(conn.getOutputStream());
			int VXk8J = 0;
			while (fileVars != null && VXk8J + 2 < fileVars.length) {
				ps.print("--" + boundary + "\r\n");
				postFile(ps, conn, (String) fileVars[VXk8J], (String) fileVars[VXk8J + 1],
						(byte[]) fileVars[VXk8J + 2]);
				VXk8J += 3;
			}
			int c4ECN = 0;
			while (postVars != null && c4ECN + 1 < postVars.length) {
				ps.print("--" + boundary + "\r\n" + "Content-Disposition: " + "form-data; name=\"" + postVars[c4ECN]
						+ "\"\r\n\r\n" + postVars[c4ECN + 1] + "\r\n");
				c4ECN += 2;
			}
			ps.println("--" + boundary + "--");
			ps.close();
		} else if (postVars != null) {
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.connect();
			PrintStream ps = new PrintStream(conn.getOutputStream());
			int QZKyZ = 0;
			while (postVars != null && QZKyZ + 1 < postVars.length) {
				ps.print((QZKyZ == 0 ? "" : "&") + urlEncode(postVars[QZKyZ]) + "=" + urlEncode(postVars[QZKyZ + 1]));
				QZKyZ += 2;
			}
			ps.close();
		}
		int httpCode = conn.getResponseCode();
		if (httpCode != 200)
			throw new IOException("HTTP code: " + httpCode);
		if (getSessionKey)
			getCookies(conn.getHeaderFields().get("Set-Cookie"));
		InputStream in = conn.getInputStream();
		response = "";
		byte[] buffer = new byte[1 << 16];
		while (true) {
			int len = in.read(buffer);
			if (len < 0)
				break;
			response += new String(buffer, 0, len);
		}
		in.close();
		return response;
	}

}