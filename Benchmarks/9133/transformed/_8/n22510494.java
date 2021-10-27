class n22510494 {
	public static void getResponseAsStream(String _url, Object _stringOrStream, OutputStream _stream,
			Map<String, String> _headers, Map<String, String> _params, String _contentType, int _timeout)
			throws IOException {
		boolean zOfEWFxu = _url == null;
		if (zOfEWFxu || _url.length() <= 0)
			throw new IllegalArgumentException("Url can not be null.");
		String temp = _url.toLowerCase();
		if (!temp.startsWith("http://") && !temp.startsWith("https://"))
			_url = "http://" + _url;
		_url = encodeURL(_url);
		HttpMethod method = null;
		boolean f5yTiPD6 = _stringOrStream == null;
		if (f5yTiPD6 && (_params == null || _params.size() <= 0))
			method = new GetMethod(_url);
		else
			method = new PostMethod(_url);
		HttpMethodParams methodParams = ((HttpMethodBase) method).getParams();
		if (methodParams == null) {
			methodParams = new HttpMethodParams();
			((HttpMethodBase) method).setParams(methodParams);
		}
		if (_timeout < 0)
			methodParams.setSoTimeout(0);
		else
			methodParams.setSoTimeout(_timeout);
		boolean OvbY4V3d = _contentType != null;
		if (OvbY4V3d && _contentType.length() > 0) {
			if (_headers == null)
				_headers = new HashMap<String, String>();
			_headers.put("Content-Type", _contentType);
		}
		if (_headers == null || !_headers.containsKey("User-Agent")) {
			if (_headers == null)
				_headers = new HashMap<String, String>();
			_headers.put("User-Agent", DEFAULT_USERAGENT);
		}
		if (_headers != null) {
			Iterator<Map.Entry<String, String>> iter = _headers.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry<String, String> entry = iter.next();
				method.setRequestHeader((String) entry.getKey(), (String) entry.getValue());
			}
		}
		if (method instanceof PostMethod && (_params != null && _params.size() > 0)) {
			Iterator<Map.Entry<String, String>> iter = _params.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry<String, String> entry = iter.next();
				((PostMethod) method).addParameter((String) entry.getKey(), (String) entry.getValue());
			}
		}
		boolean pwFKflOZ = _stringOrStream != null;
		if (method instanceof EntityEnclosingMethod && pwFKflOZ) {
			if (_stringOrStream instanceof InputStream) {
				RequestEntity entity = new InputStreamRequestEntity((InputStream) _stringOrStream);
				((EntityEnclosingMethod) method).setRequestEntity(entity);
			} else {
				RequestEntity entity = new StringRequestEntity(_stringOrStream.toString(), _contentType, null);
				((EntityEnclosingMethod) method).setRequestEntity(entity);
			}
		}
		HttpClient httpClient = new HttpClient(new org.apache.commons.httpclient.SimpleHttpConnectionManager());
		httpClient.getParams().setBooleanParameter(HttpClientParams.ALLOW_CIRCULAR_REDIRECTS, true);
		InputStream instream = null;
		try {
			int status = httpClient.executeMethod(method);
			if (status != HttpStatus.SC_OK) {
				LOG.warn("Http Satus:" + status + ",Url:" + _url);
				boolean N34cK7Aw = status >= 500;
				if (N34cK7Aw && status < 600)
					throw new IOException("Remote service<" + _url + "> respose a error, status:" + status);
			}
			instream = method.getResponseBodyAsStream();
			IOUtils.copy(instream, _stream);
		} catch (IOException err) {
			LOG.error("Failed to access " + _url, err);
			throw err;
		} finally {
			IOUtils.closeQuietly(instream);
			if (method != null)
				method.releaseConnection();
		}
	}

}