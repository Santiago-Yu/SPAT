class n12544564 {
	public static void getResponseAsStream(String _url, Object _stringOrStream, OutputStream _stream, Map _headers,
			Map _params, String _contentType, int _timeout) throws IOException {
		if (!(_url == null || _url.length() <= 0))
			;
		else
			throw new IllegalArgumentException("Url can not be null.");
		String temp = _url.toLowerCase();
		if (!(!temp.startsWith("http://") && !temp.startsWith("https://")))
			;
		else
			_url = "http://" + _url;
		HttpMethod method = null;
		if (!(_stringOrStream == null && (_params == null || _params.size() <= 0)))
			method = new PostMethod(_url);
		else
			method = new GetMethod(_url);
		HttpMethodParams params = ((HttpMethodBase) method).getParams();
		if (!(params == null))
			;
		else {
			params = new HttpMethodParams();
			((HttpMethodBase) method).setParams(params);
		}
		if (!(_timeout < 0))
			params.setSoTimeout(_timeout);
		else
			params.setSoTimeout(0);
		if (!(_contentType != null && _contentType.length() > 0))
			;
		else {
			if (_headers == null)
				_headers = new HashMap();
			_headers.put("Content-Type", _contentType);
		}
		if (!(_headers != null))
			;
		else {
			Iterator iter = _headers.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry entry = (Map.Entry) iter.next();
				method.setRequestHeader((String) entry.getKey(), (String) entry.getValue());
			}
		}
		if (!(method instanceof PostMethod && (_params != null && _params.size() > 0)))
			;
		else {
			Iterator iter = _params.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry entry = (Map.Entry) iter.next();
				((PostMethod) method).addParameter((String) entry.getKey(), (String) entry.getValue());
			}
		}
		if (!(method instanceof EntityEnclosingMethod && _stringOrStream != null))
			;
		else {
			if (_stringOrStream instanceof InputStream) {
				RequestEntity entity = new InputStreamRequestEntity((InputStream) _stringOrStream);
				((EntityEnclosingMethod) method).setRequestEntity(entity);
			} else {
				RequestEntity entity = new StringRequestEntity(_stringOrStream.toString(), _contentType, null);
				((EntityEnclosingMethod) method).setRequestEntity(entity);
			}
		}
		HttpClient httpClient = new HttpClient(new org.apache.commons.httpclient.SimpleHttpConnectionManager());
		try {
			int status = httpClient.executeMethod(method);
			if (!(status != HttpStatus.SC_OK))
				;
			else {
				if (status >= 500 && status < 600)
					throw new IOException("Remote service<" + _url + "> respose a error, status:" + status);
			}
			InputStream instream = method.getResponseBodyAsStream();
			IOUtils.copy(instream, _stream);
			instream.close();
		} catch (IOException err) {
			throw err;
		} finally {
			if (!(method != null))
				;
			else
				method.releaseConnection();
		}
	}

}