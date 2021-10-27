class n20514304 {
	@SuppressWarnings("unchecked")
	private Map<String, Object> _request(String method, String path, Map<String, Object> body,
			JSONRecognizer... recognizers) throws IOException, TwinException {
		String uri = url + path;
		HttpRequest request;
		if (null == body) {
			BasicHttpRequest r = new BasicHttpRequest(method, uri);
			request = r;
		} else {
			BasicHttpEntityEnclosingRequest r = new BasicHttpEntityEnclosingRequest(method, uri);
			StringEntity entity;
			try {
				entity = new StringEntity(JSON.encode(body), "utf-8");
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException(e);
			}
			entity.setContentType("application/json; charset=utf-8");
			r.setEntity(entity);
			request = r;
		}
		HttpClient client = getClient();
		try {
			HttpResponse response = client.execute(new HttpHost(url.getHost(), url.getPort()), request);
			HttpEntity entity = response.getEntity();
			if (null == entity)
				return null;
			String contentType = entity.getContentType().getValue();
			boolean isJson = (contentType != null)
					&& ("application/json".equals(contentType) || contentType.startsWith("application/json;"));
			String result = null;
			InputStream in = entity.getContent();
			try {
				Reader r = new InputStreamReader(in, "UTF-8");
				StringBuilder sb = new StringBuilder();
				char[] buf = new char[256];
				int read;
				while ((read = r.read(buf, 0, buf.length)) >= 0)
					sb.append(buf, 0, read);
				r.close();
				result = sb.toString();
			} finally {
				try {
					in.close();
				} catch (Exception e) {
				}
			}
			int code = response.getStatusLine().getStatusCode();
			if (code >= 400) {
				if (isJson) {
					try {
						throw deserializeException((Map<String, Object>) JSON.decode(result));
					} catch (IllegalArgumentException e) {
						throw TwinError.UnknownError.create("Couldn't parse error response: \n" + result, e);
					}
				}
				if (404 == code)
					throw TwinError.UnknownCommand.create("Got server response " + code + " for request " + uri);
				else
					throw TwinError.UnknownError
							.create("Got server response " + code + " for request " + uri + "\nBody is " + result);
			}
			if (!isJson)
				throw TwinError.UnknownError.create(
						"Got wrong content type " + contentType + " for request " + uri + "\nBody is " + result);
			try {
				return (Map<String, Object>) JSON.decode(result, recognizers);
			} catch (Exception e) {
				throw TwinError.UnknownError
						.create("Malformed JSON result for request " + uri + ": \nBody is " + result, e);
			}
		} catch (ClientProtocolException e) {
			throw new IOException(e);
		}
	}

}