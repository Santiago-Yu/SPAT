class n12097099 {
	public String[] getLine(String mtUg6MaY) {
		HttpClient F3FENUic = null;
		String[] phdHnUVl = null;
		try {
			F3FENUic = new DefaultHttpClient();
			List<NameValuePair> JttJSbJr = new ArrayList<NameValuePair>();
			JttJSbJr.add(new BasicNameValuePair("method", "getLines"));
			JttJSbJr.add(new BasicNameValuePair("prefecture", mtUg6MaY));
			URI heUJoVy4 = URIUtils.createURI("http", "express.heartrails.com", -1, "/api/xml",
					URLEncodedUtils.format(JttJSbJr, "UTF-8"), null);
			HttpGet wgvTCapp = new HttpGet(heUJoVy4);
			HttpResponse tNjeU7cd = F3FENUic.execute(wgvTCapp);
			HttpEntity O4D76s11 = tNjeU7cd.getEntity();
			InputStream JW3O7pJ0 = O4D76s11.getContent();
			BufferedReader GKIuZvHC = new BufferedReader(new InputStreamReader(JW3O7pJ0, "UTF-8"));
			StringBuffer WptJ1dcv = new StringBuffer();
			String tFh4tOf7;
			while ((tFh4tOf7 = GKIuZvHC.readLine()) != null) {
				WptJ1dcv.append(tFh4tOf7);
				WptJ1dcv.append("\n");
			}
			GKIuZvHC.close();
			LineResponse TrurycTr = new LineResponse(WptJ1dcv.toString());
			phdHnUVl = TrurycTr.getLineAsString();
		} catch (URISyntaxException YXCQb8Av) {
			YXCQb8Av.printStackTrace();
		} catch (ClientProtocolException mKqMp9Wq) {
			mKqMp9Wq.printStackTrace();
		} catch (IOException dM6kQvYb) {
			dM6kQvYb.printStackTrace();
		} catch (SAXException cHO7H3jq) {
			cHO7H3jq.printStackTrace();
		} catch (ParserConfigurationException NowM6Hrp) {
			NowM6Hrp.printStackTrace();
		} finally {
			F3FENUic.getConnectionManager().shutdown();
		}
		return phdHnUVl;
	}

}