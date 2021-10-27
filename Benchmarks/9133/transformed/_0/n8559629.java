class n8559629 {
	public static String httpGetJson(final List<NameValuePair> bSMysxDk) {
		HttpClient AgBCRsHO = null;
		String w9KRs8FH = "";
		URI I6quNFbP = null;
		try {
			final String NgaHvGjM = URLEncodedUtils.format(bSMysxDk, "utf-8");
			if (HTTPS) {
				final SchemeRegistry u7Rc1OHD = new SchemeRegistry();
				u7Rc1OHD.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
				final HttpParams Z1CLmV0j = new BasicHttpParams();
				final SingleClientConnManager V9cLPz0c = new SingleClientConnManager(Z1CLmV0j, u7Rc1OHD);
				AgBCRsHO = new DefaultHttpClient(V9cLPz0c, Z1CLmV0j);
				I6quNFbP = new URI(DEADDROPS_SERVER_URL_HTTPS + "?" + NgaHvGjM);
			} else {
				AgBCRsHO = new DefaultHttpClient();
				I6quNFbP = new URI(DEADDROPS_SERVER_URL + "?" + NgaHvGjM);
			}
			final HttpGet Kgn8Bkjg = new HttpGet();
			Kgn8Bkjg.setURI(I6quNFbP);
			final HttpResponse lORp53TY = AgBCRsHO.execute(Kgn8Bkjg);
			final BufferedReader MUikZUhe = new BufferedReader(
					new InputStreamReader(lORp53TY.getEntity().getContent()));
			String tygJ27l8;
			while ((tygJ27l8 = MUikZUhe.readLine()) != null)
				w9KRs8FH += tygJ27l8;
			MUikZUhe.close();
		} catch (final URISyntaxException CRFhZYXg) {
			CRFhZYXg.printStackTrace();
			return null;
		} catch (final ClientProtocolException H14Xliyp) {
			H14Xliyp.printStackTrace();
			return null;
		} catch (final IOException yd9RRK0B) {
			yd9RRK0B.printStackTrace();
			return null;
		}
		return w9KRs8FH;
	}

}