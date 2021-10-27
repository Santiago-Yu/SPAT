class n8559629 {
	public static String httpGetJson(final List<NameValuePair> nameValuePairs) {
		String data = "";
		HttpClient httpclient = null;
		URI uri = null;
		try {
			final String paramString = URLEncodedUtils.format(nameValuePairs, "utf-8");
			final HttpGet request = new HttpGet();
			if (HTTPS) {
				final SchemeRegistry schemeRegistry = new SchemeRegistry();
				schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
				final HttpParams params = new BasicHttpParams();
				final SingleClientConnManager mgr = new SingleClientConnManager(params, schemeRegistry);
				httpclient = new DefaultHttpClient(mgr, params);
				uri = new URI(DEADDROPS_SERVER_URL_HTTPS + "?" + paramString);
			} else {
				httpclient = new DefaultHttpClient();
				uri = new URI(DEADDROPS_SERVER_URL + "?" + paramString);
			}
			request.setURI(uri);
			final HttpResponse response = httpclient.execute(request);
			String inputLine;
			final BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			while ((inputLine = in.readLine()) != null)
				data += inputLine;
			in.close();
		} catch (final URISyntaxException e) {
			e.printStackTrace();
			return null;
		} catch (final ClientProtocolException e) {
			e.printStackTrace();
			return null;
		} catch (final IOException e) {
			e.printStackTrace();
			return null;
		}
		return data;
	}

}