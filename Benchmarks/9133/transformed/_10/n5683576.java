class n5683576 {
	public String shorten(String url) {
		List<NameValuePair> qparams = new ArrayList<NameValuePair>();
		qparams.add(new BasicNameValuePair("version", "2.0.1"));
		qparams.add(new BasicNameValuePair("longUrl", url));
		if (login != null) {
			qparams.add(new BasicNameValuePair("login", login));
			qparams.add(new BasicNameValuePair("apiKey", apiKey));
			qparams.add(new BasicNameValuePair("history", "1"));
		}
		try {
			BasicHttpParams params = new BasicHttpParams();
			URI uri = URIUtils.createURI("http", "api.j.mp", -1, "/shorten", URLEncodedUtils.format(qparams, "UTF-8"),
					null);
			DefaultHttpClient httpclient = new DefaultHttpClient(params);
			HttpGet httpget = new HttpGet(uri);
			if (logger.isDebugEnabled())
				logger.debug("HttpGet.uri={}", httpget.getURI());
			HttpResponse response = httpclient.execute(httpget);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				JsonFactory f = new JsonFactory();
				InputStream instream = entity.getContent();
				JmpShortenResponse responseObj = new JmpShortenResponse();
				JsonParser jp = f.createJsonParser(instream);
				for (;;) {
					JsonToken token = jp.nextToken();
					String fieldname = jp.getCurrentName();
					if (logger.isDebugEnabled())
						logger.debug("Token={}, currentName={}", token, fieldname);
					if (token == JsonToken.START_OBJECT) {
						continue;
					}
					if (token == JsonToken.END_OBJECT) {
						break;
					}
					if ("errorCode".equals(fieldname)) {
						token = jp.nextToken();
						responseObj.setErrorCode(jp.getIntValue());
					} else if ("errorMessage".equals(fieldname)) {
						token = jp.nextToken();
						responseObj.setErrorMessage(jp.getText());
					} else if ("statusCode".equals(fieldname)) {
						token = jp.nextToken();
						responseObj.setStatusCode(jp.getText());
					} else if ("results".equals(fieldname)) {
						Map<String, ShortenedUrl> results = parseResults(jp);
						responseObj.setResults(results);
					} else {
						throw new IllegalStateException("Unrecognized field '" + fieldname + "'!");
					}
				}
				Map<String, ShortenedUrl> results = responseObj.getResults();
				if (results == null) {
					return null;
				}
				ShortenedUrl shortened = results.get(url);
				if (logger.isDebugEnabled())
					logger.debug("JmpShortenResponse: {}", responseObj);
				if (shortened == null) {
					return null;
				}
				if ("OK".equals(responseObj.getStatusCode())) {
					return shortened.getShortUrl();
				}
				if (logger.isWarnEnabled())
					logger.warn("JmpShortenResponse: {}", responseObj);
			}
		} catch (IOException ex) {
			if (logger.isWarnEnabled())
				logger.warn("Exception!", ex);
		} catch (URISyntaxException ex) {
			if (logger.isWarnEnabled())
				logger.warn("Exception!", ex);
		}
		return null;
	}

}