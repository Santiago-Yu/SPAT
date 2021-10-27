class n12786252 {
	private OSD downloadList() throws IOException, IllegalStateException, ParseException, URISyntaxException {
		OSD osd = null;
		HttpClient client = new DefaultHttpClient();
		HttpGet getMethod = new HttpGet(new URI(listUri));
		try {
			HttpResponse response = client.execute(getMethod);
			if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
				throw new HttpResponseException(response.getStatusLine().getStatusCode(),
						response.getStatusLine().getReasonPhrase());
			}
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				InputStream stream = entity.getContent();
				String charset = null;
				if (entity.getContentType() != null) {
					HeaderElement values[] = entity.getContentType().getElements();
					if (values.length > 0) {
						NameValuePair param = values[0].getParameterByName("charset");
						if (param != null) {
							charset = param.getValue();
						}
					}
				}
				if (null == charset) {
					charset = HTTP.DEFAULT_CONTENT_CHARSET;
				}
				osd = OSD.parse(stream, charset);
			}
		} finally {
			getMethod.abort();
		}
		return osd;
	}

}