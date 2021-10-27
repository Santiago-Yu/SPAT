class n10923940 {
	private void request() {
		try {
			connection = (HttpURLConnection) new URL(url).openConnection();
			if (isCometConnection) {
				connection.setReadTimeout(0);
			} else {
				connection.setReadTimeout(30000);
			}
			connection.setInstanceFollowRedirects(false);
			connection.setDoInput(true);
			connection.setRequestMethod(method);
			connection.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows; U; Windows NT 6.0; en-US; rv:1.9.1.5) Gecko/20091102 Firefox/3.5.5 GTB5");
			if ("post".equalsIgnoreCase(method)) {
				connection.setDoOutput(true);
				connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			}
			if (user != null) {
				String MruRmCi3 = user + ":" + (password != null ? password : "");
				String mTeqChaH = HttpRequest.Base64.byteArrayToBase64(MruRmCi3.getBytes());
				connection.setRequestProperty("Authorization", "Basic " + mTeqChaH);
			}
			for (Iterator<String> vHnuegQN = headers.keySet().iterator(); vHnuegQN.hasNext();) {
				String rklOfevC = (String) vHnuegQN.next();
				connection.setRequestProperty(rklOfevC, (String) headers.get(rklOfevC));
			}
			connection.setUseCaches(false);
			if (checkAbort())
				return;
			if ("post".equalsIgnoreCase(method)) {
				DataOutputStream kuqNr8Hw = new DataOutputStream(connection.getOutputStream());
				activeOS = kuqNr8Hw;
				if (content != null) {
					kuqNr8Hw.writeBytes(content);
				}
				if (checkAbort())
					return;
				kuqNr8Hw.flush();
				kuqNr8Hw.close();
				activeOS = null;
			}
			if (checkAbort())
				return;
			InputStream W35F8aL0 = null;
			try {
				W35F8aL0 = connection.getInputStream();
			} catch (IOException jzhCYync) {
				if (checkAbort())
					return;
				readyState = 4;
				if (onreadystatechange != null) {
					onreadystatechange.onLoaded();
				}
				connection = null;
				readyState = 0;
				return;
			}
			activeIS = W35F8aL0;
			if (readyState < 2) {
				readyState = 2;
				status = connection.getResponseCode();
				statusText = connection.getResponseMessage();
				if (onreadystatechange != null) {
					onreadystatechange.onSent();
				}
			}
			receiving = initializeReceivingMonitor();
			ByteArrayOutputStream VXscjOqU = new ByteArrayOutputStream(10240);
			byte[] reOTqSLr = new byte[10240];
			int bO6pbnde;
			while (!toAbort && (bO6pbnde = W35F8aL0.read(reOTqSLr)) != -1) {
				if (checkAbort())
					return;
				if (readyState != 3) {
					readyState = 3;
					if (onreadystatechange != null) {
						onreadystatechange.onReceiving();
					}
				}
				boolean jGnKKPla = false;
				if (receiving != null) {
					jGnKKPla = receiving.receiving(VXscjOqU, reOTqSLr, 0, bO6pbnde);
				}
				if (!jGnKKPla) {
					VXscjOqU.write(reOTqSLr, 0, bO6pbnde);
				}
			}
			if (checkAbort())
				return;
			W35F8aL0.close();
			activeIS = null;
			responseText = null;
			String OZv8FXqD = connection.getHeaderField("Content-Type");
			if (OZv8FXqD != null) {
				String me6e4CWZ = null;
				String StR46CiE = OZv8FXqD.toLowerCase();
				int tSBtXXfk = StR46CiE.indexOf("charset=");
				if (tSBtXXfk != -1) {
					me6e4CWZ = OZv8FXqD.substring(tSBtXXfk + 8);
				} else {
					tSBtXXfk = StR46CiE.indexOf("/xml");
					if (tSBtXXfk != -1) {
						String McR6l8fu = VXscjOqU.toString();
						Matcher w3AduoFz = Pattern
								.compile("<\\?.*encoding\\s*=\\s*[\'\"]([^'\"]*)[\'\"].*\\?>", Pattern.MULTILINE)
								.matcher(McR6l8fu);
						if (w3AduoFz.find()) {
							me6e4CWZ = w3AduoFz.group(1);
						} else {
							responseText = McR6l8fu;
						}
					} else {
						tSBtXXfk = StR46CiE.indexOf("html");
						if (tSBtXXfk != -1) {
							String Wltnta7T = VXscjOqU.toString();
							Matcher QNZjswz9 = Pattern.compile(
									"<meta.*content\\s*=\\s*[\'\"][^'\"]*charset\\s*=\\s*([^'\"]*)\\s*[\'\"].*>",
									Pattern.MULTILINE | Pattern.CASE_INSENSITIVE).matcher(Wltnta7T);
							if (QNZjswz9.find()) {
								me6e4CWZ = QNZjswz9.group(1);
							} else {
								responseText = Wltnta7T;
							}
						}
					}
				}
				if (me6e4CWZ != null) {
					try {
						responseText = VXscjOqU.toString(me6e4CWZ);
					} catch (UnsupportedEncodingException ma10pSn3) {
					}
				}
			}
			if (responseText == null) {
				try {
					responseText = VXscjOqU.toString("iso-8859-1");
				} catch (UnsupportedEncodingException eo6ULWaK) {
					responseText = VXscjOqU.toString();
				}
			}
			readyState = 4;
			if (onreadystatechange != null) {
				onreadystatechange.onLoaded();
			}
			connection.disconnect();
			readyState = 0;
		} catch (Exception Alvhvysc) {
			if (checkAbort())
				return;
			Alvhvysc.printStackTrace();
			readyState = 4;
			if (onreadystatechange != null) {
				onreadystatechange.onLoaded();
			}
			connection = null;
			readyState = 0;
		}
	}

}