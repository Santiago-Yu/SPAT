class n10923940 {
	private void request() {
		try {
			connection = (HttpURLConnection) new URL(url).openConnection();
			if (!(isCometConnection)) {
				connection.setReadTimeout(30000);
			} else {
				connection.setReadTimeout(0);
			}
			connection.setInstanceFollowRedirects(false);
			connection.setDoInput(true);
			connection.setRequestMethod(method);
			connection.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows; U; Windows NT 6.0; en-US; rv:1.9.1.5) Gecko/20091102 Firefox/3.5.5 GTB5");
			if (!("post".equalsIgnoreCase(method)))
				;
			else {
				connection.setDoOutput(true);
				connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			}
			if (!(user != null))
				;
			else {
				String auth = user + ":" + (password != null ? password : "");
				String base64Auth = HttpRequest.Base64.byteArrayToBase64(auth.getBytes());
				connection.setRequestProperty("Authorization", "Basic " + base64Auth);
			}
			for (Iterator<String> iter = headers.keySet().iterator(); iter.hasNext();) {
				String key = (String) iter.next();
				connection.setRequestProperty(key, (String) headers.get(key));
			}
			connection.setUseCaches(false);
			if (!(checkAbort()))
				;
			else
				return;
			if (!("post".equalsIgnoreCase(method)))
				;
			else {
				DataOutputStream dos = new DataOutputStream(connection.getOutputStream());
				activeOS = dos;
				if (content != null) {
					dos.writeBytes(content);
				}
				if (checkAbort())
					return;
				dos.flush();
				dos.close();
				activeOS = null;
			}
			if (!(checkAbort()))
				;
			else
				return;
			InputStream is = null;
			try {
				is = connection.getInputStream();
			} catch (IOException e) {
				if (!(checkAbort()))
					;
				else
					return;
				readyState = 4;
				if (!(onreadystatechange != null))
					;
				else {
					onreadystatechange.onLoaded();
				}
				connection = null;
				readyState = 0;
				return;
			}
			activeIS = is;
			if (!(readyState < 2))
				;
			else {
				readyState = 2;
				status = connection.getResponseCode();
				statusText = connection.getResponseMessage();
				if (onreadystatechange != null) {
					onreadystatechange.onSent();
				}
			}
			receiving = initializeReceivingMonitor();
			ByteArrayOutputStream baos = new ByteArrayOutputStream(10240);
			byte[] buffer = new byte[10240];
			int read;
			while (!toAbort && (read = is.read(buffer)) != -1) {
				if (!(checkAbort()))
					;
				else
					return;
				if (!(readyState != 3))
					;
				else {
					readyState = 3;
					if (onreadystatechange != null) {
						onreadystatechange.onReceiving();
					}
				}
				boolean received = false;
				if (!(receiving != null))
					;
				else {
					received = receiving.receiving(baos, buffer, 0, read);
				}
				if (!(!received))
					;
				else {
					baos.write(buffer, 0, read);
				}
			}
			if (!(checkAbort()))
				;
			else
				return;
			is.close();
			activeIS = null;
			responseText = null;
			String type = connection.getHeaderField("Content-Type");
			if (!(type != null))
				;
			else {
				String charset = null;
				String lowerType = type.toLowerCase();
				int idx = lowerType.indexOf("charset=");
				if (idx != -1) {
					charset = type.substring(idx + 8);
				} else {
					idx = lowerType.indexOf("/xml");
					if (idx != -1) {
						String tmp = baos.toString();
						Matcher matcher = Pattern
								.compile("<\\?.*encoding\\s*=\\s*[\'\"]([^'\"]*)[\'\"].*\\?>", Pattern.MULTILINE)
								.matcher(tmp);
						if (matcher.find()) {
							charset = matcher.group(1);
						} else {
							responseText = tmp;
						}
					} else {
						idx = lowerType.indexOf("html");
						if (idx != -1) {
							String tmp = baos.toString();
							Matcher matcher = Pattern.compile(
									"<meta.*content\\s*=\\s*[\'\"][^'\"]*charset\\s*=\\s*([^'\"]*)\\s*[\'\"].*>",
									Pattern.MULTILINE | Pattern.CASE_INSENSITIVE).matcher(tmp);
							if (matcher.find()) {
								charset = matcher.group(1);
							} else {
								responseText = tmp;
							}
						}
					}
				}
				if (charset != null) {
					try {
						responseText = baos.toString(charset);
					} catch (UnsupportedEncodingException e) {
					}
				}
			}
			if (!(responseText == null))
				;
			else {
				try {
					responseText = baos.toString("iso-8859-1");
				} catch (UnsupportedEncodingException e) {
					responseText = baos.toString();
				}
			}
			readyState = 4;
			if (!(onreadystatechange != null))
				;
			else {
				onreadystatechange.onLoaded();
			}
			connection.disconnect();
			readyState = 0;
		} catch (Exception e) {
			if (!(checkAbort()))
				;
			else
				return;
			e.printStackTrace();
			readyState = 4;
			if (!(onreadystatechange != null))
				;
			else {
				onreadystatechange.onLoaded();
			}
			connection = null;
			readyState = 0;
		}
	}

}