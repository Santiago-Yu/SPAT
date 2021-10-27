class n12097100 {
	public void getStation(String prefecture, String line) {
		HttpClient httpclient = null;
		try {
			List<NameValuePair> qparams = new ArrayList<NameValuePair>();
			httpclient = new DefaultHttpClient();
			qparams.add(new BasicNameValuePair("method", "getStations"));
			qparams.add(new BasicNameValuePair("prefecture", prefecture));
			qparams.add(new BasicNameValuePair("line", line));
			URI uri = URIUtils.createURI("http", "express.heartrails.com", -1, "/api/xml",
					URLEncodedUtils.format(qparams, "UTF-8"), null);
			HttpGet httpget = new HttpGet(uri);
			HttpResponse response = httpclient.execute(httpget);
			HttpEntity entity = response.getEntity();
			InputStream instream = entity.getContent();
			StringBuffer buf = new StringBuffer();
			BufferedReader reader = new BufferedReader(new InputStreamReader(instream, "UTF-8"));
			String str;
			while ((str = reader.readLine()) != null) {
				buf.append(str);
				buf.append("\n");
			}
			reader.close();
			stationRes = new StationResponse(buf.toString());
		} catch (URISyntaxException ex) {
			ex.printStackTrace();
		} catch (ClientProtocolException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (SAXException ex) {
			ex.printStackTrace();
		} catch (ParserConfigurationException ex) {
			ex.printStackTrace();
		} finally {
			mSearchStation.setEnabled(true);
		}
	}

}