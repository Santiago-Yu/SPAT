class n5817511 {
	@Override
	public void send(String payload, TransportReceiver receiver) {
		HttpURLConnection connection = null;
		try {
			connection = (HttpURLConnection) url.openConnection();
			configureConnection(connection);
			OutputStream out = connection.getOutputStream();
			out.write(payload.getBytes("UTF-8"));
			out.close();
			int status = connection.getResponseCode();
			if (status != HttpURLConnection.HTTP_OK) {
				ServerFailure failure = new ServerFailure(status + " " + connection.getResponseMessage());
				receiver.onTransportFailure(failure);
				return;
			}
			List<String> cookieHeaders = connection.getHeaderFields().get("Set-Cookie");
			if (cookieHeaders != null) {
				for (String header : cookieHeaders) {
					try {
						JSONObject cookie = Cookie.toJSONObject(header);
						String name = cookie.getString("name"), value = cookie.getString("value");
						String domain = cookie.optString("Domain");
						if (domain == null || url.getHost().endsWith(domain)) {
							String path = cookie.optString("Path");
							if (path == null || url.getPath().startsWith(path)) {
								cookies.put(name, value);
							}
						}
					} catch (JSONException ignored) {
					}
				}
			}
			String encoding = connection.getContentEncoding();
			InputStream in = connection.getInputStream();
			if ("gzip".equalsIgnoreCase(encoding)) {
				in = new GZIPInputStream(in);
			} else if ("deflate".equalsIgnoreCase(encoding)) {
				in = new InflaterInputStream(in);
			} else if (encoding != null) {
				receiver.onTransportFailure(new ServerFailure("Unknown server encoding " + encoding));
				return;
			}
			ByteArrayOutputStream bytes = new ByteArrayOutputStream();
			byte[] buffer = new byte[4096];
			int read = in.read(buffer);
			while (read != -1) {
				bytes.write(buffer, 0, read);
				read = in.read(buffer);
			}
			in.close();
			String received = new String(bytes.toByteArray(), "UTF-8");
			receiver.onTransportSuccess(received);
		} catch (IOException e) {
			ServerFailure failure = new ServerFailure(e.getMessage(), e.getClass().getName(), null, true);
			receiver.onTransportFailure(failure);
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}

}