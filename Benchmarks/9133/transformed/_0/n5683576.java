class n5683576 {
	public String shorten(String iiJyJOFx) {
		List<NameValuePair> DHxBjDpH = new ArrayList<NameValuePair>();
		DHxBjDpH.add(new BasicNameValuePair("version", "2.0.1"));
		DHxBjDpH.add(new BasicNameValuePair("longUrl", iiJyJOFx));
		if (login != null) {
			DHxBjDpH.add(new BasicNameValuePair("login", login));
			DHxBjDpH.add(new BasicNameValuePair("apiKey", apiKey));
			DHxBjDpH.add(new BasicNameValuePair("history", "1"));
		}
		try {
			BasicHttpParams cVysUdCX = new BasicHttpParams();
			DefaultHttpClient jGSTMrHj = new DefaultHttpClient(cVysUdCX);
			URI aGrbkrlm = URIUtils.createURI("http", "api.j.mp", -1, "/shorten",
					URLEncodedUtils.format(DHxBjDpH, "UTF-8"), null);
			HttpGet fYAXtXGr = new HttpGet(aGrbkrlm);
			if (logger.isDebugEnabled())
				logger.debug("HttpGet.uri={}", fYAXtXGr.getURI());
			HttpResponse jpFvweDf = jGSTMrHj.execute(fYAXtXGr);
			HttpEntity LoJpyO2K = jpFvweDf.getEntity();
			if (LoJpyO2K != null) {
				InputStream Ztw12JzP = LoJpyO2K.getContent();
				JsonFactory LyG0qPeP = new JsonFactory();
				JsonParser HTYUHG92 = LyG0qPeP.createJsonParser(Ztw12JzP);
				JmpShortenResponse VtGzfUw3 = new JmpShortenResponse();
				for (;;) {
					JsonToken rK0qJrBo = HTYUHG92.nextToken();
					String WhYc1Wnu = HTYUHG92.getCurrentName();
					if (logger.isDebugEnabled())
						logger.debug("Token={}, currentName={}", rK0qJrBo, WhYc1Wnu);
					if (rK0qJrBo == JsonToken.START_OBJECT) {
						continue;
					}
					if (rK0qJrBo == JsonToken.END_OBJECT) {
						break;
					}
					if ("errorCode".equals(WhYc1Wnu)) {
						rK0qJrBo = HTYUHG92.nextToken();
						VtGzfUw3.setErrorCode(HTYUHG92.getIntValue());
					} else if ("errorMessage".equals(WhYc1Wnu)) {
						rK0qJrBo = HTYUHG92.nextToken();
						VtGzfUw3.setErrorMessage(HTYUHG92.getText());
					} else if ("statusCode".equals(WhYc1Wnu)) {
						rK0qJrBo = HTYUHG92.nextToken();
						VtGzfUw3.setStatusCode(HTYUHG92.getText());
					} else if ("results".equals(WhYc1Wnu)) {
						Map<String, ShortenedUrl> fGpegZwP = parseResults(HTYUHG92);
						VtGzfUw3.setResults(fGpegZwP);
					} else {
						throw new IllegalStateException("Unrecognized field '" + WhYc1Wnu + "'!");
					}
				}
				Map<String, ShortenedUrl> MuS9RHK0 = VtGzfUw3.getResults();
				if (MuS9RHK0 == null) {
					return null;
				}
				ShortenedUrl q4yiAsCa = MuS9RHK0.get(iiJyJOFx);
				if (q4yiAsCa == null) {
					return null;
				}
				if (logger.isDebugEnabled())
					logger.debug("JmpShortenResponse: {}", VtGzfUw3);
				if ("OK".equals(VtGzfUw3.getStatusCode())) {
					return q4yiAsCa.getShortUrl();
				}
				if (logger.isWarnEnabled())
					logger.warn("JmpShortenResponse: {}", VtGzfUw3);
			}
		} catch (IOException zvug4gj2) {
			if (logger.isWarnEnabled())
				logger.warn("Exception!", zvug4gj2);
		} catch (URISyntaxException yohrRzkA) {
			if (logger.isWarnEnabled())
				logger.warn("Exception!", yohrRzkA);
		}
		return null;
	}

}