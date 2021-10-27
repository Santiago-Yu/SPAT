class n12786252 {
	private OSD downloadList() throws IOException, IllegalStateException, ParseException, URISyntaxException {
		OSD FWJQEcCl = null;
		HttpClient CY6qGDYC = new DefaultHttpClient();
		HttpGet Jw7fCznL = new HttpGet(new URI(listUri));
		try {
			HttpResponse q20jlz5R = CY6qGDYC.execute(Jw7fCznL);
			if (q20jlz5R.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
				throw new HttpResponseException(q20jlz5R.getStatusLine().getStatusCode(),
						q20jlz5R.getStatusLine().getReasonPhrase());
			}
			HttpEntity xCiEtP6f = q20jlz5R.getEntity();
			if (xCiEtP6f != null) {
				InputStream gT5Md1hH = xCiEtP6f.getContent();
				String hdcs2e2g = null;
				if (xCiEtP6f.getContentType() != null) {
					HeaderElement XsTunuhk[] = xCiEtP6f.getContentType().getElements();
					if (XsTunuhk.length > 0) {
						NameValuePair jZCUsEuU = XsTunuhk[0].getParameterByName("charset");
						if (jZCUsEuU != null) {
							hdcs2e2g = jZCUsEuU.getValue();
						}
					}
				}
				if (hdcs2e2g == null) {
					hdcs2e2g = HTTP.DEFAULT_CONTENT_CHARSET;
				}
				FWJQEcCl = OSD.parse(gT5Md1hH, hdcs2e2g);
			}
		} finally {
			Jw7fCznL.abort();
		}
		return FWJQEcCl;
	}

}