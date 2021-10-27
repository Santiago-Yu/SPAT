class n14577922 {
	public TwilioRestResponse request(String path, String method, Map<String, String> vars) throws TwilioRestException {
		String encoded = "";
		if (vars != null) {
			for (String key : vars.keySet()) {
				try {
					encoded += "&" + key + "=" + URLEncoder.encode(vars.get(key), "UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			if (encoded.length() > 0) {
				encoded = encoded.substring(1);
			}
		}
		String url = this.endpoint + path;
		if (method.toUpperCase().equals("GET"))
			url += ((-1 == path.indexOf('?')) ? "?" : "&") + encoded;
		try {
			URL resturl = new URL(url);
			HttpURLConnection con = (HttpURLConnection) resturl.openConnection();
			String userpass = this.accountSid + ":" + this.authToken;
			String encodeuserpass = new String(Base64.encodeToByte(userpass.getBytes(), false));
			con.setRequestProperty("Authorization", "Basic " + encodeuserpass);
			con.setDoOutput(true);
			if (method.toUpperCase().equals("GET")) {
				con.setRequestMethod("GET");
			} else if (method.toUpperCase().equals("POST")) {
				con.setRequestMethod("POST");
				OutputStreamWriter out = new OutputStreamWriter(con.getOutputStream());
				out.write(encoded);
				out.close();
			} else if (method.toUpperCase().equals("PUT")) {
				con.setRequestMethod("PUT");
				OutputStreamWriter out = new OutputStreamWriter(con.getOutputStream());
				out.write(encoded);
				out.close();
			} else if (method.toUpperCase().equals("DELETE")) {
				con.setRequestMethod("DELETE");
			} else {
				throw new TwilioRestException("Unknown method " + method);
			}
			BufferedReader in = null;
			try {
				if (con.getInputStream() != null) {
					in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				}
			} catch (IOException e) {
				if (con.getErrorStream() != null) {
					in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				}
			}
			if (null == in) {
				throw new TwilioRestException("Unable to read response from server");
			}
			StringBuffer decodedString = new StringBuffer();
			String line;
			while ((line = in.readLine()) != null) {
				decodedString.append(line);
			}
			in.close();
			int responseCode = con.getResponseCode();
			return new TwilioRestResponse(url, decodedString.toString(), responseCode);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}