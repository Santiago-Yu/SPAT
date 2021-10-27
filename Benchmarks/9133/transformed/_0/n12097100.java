class n12097100 {
	public void getStation(String zblIPhye, String VR6OXaDR) {
		HttpClient p1p2hjME = null;
		try {
			p1p2hjME = new DefaultHttpClient();
			List<NameValuePair> CdtjpRgO = new ArrayList<NameValuePair>();
			CdtjpRgO.add(new BasicNameValuePair("method", "getStations"));
			CdtjpRgO.add(new BasicNameValuePair("prefecture", zblIPhye));
			CdtjpRgO.add(new BasicNameValuePair("line", VR6OXaDR));
			URI hYu4GBl4 = URIUtils.createURI("http", "express.heartrails.com", -1, "/api/xml",
					URLEncodedUtils.format(CdtjpRgO, "UTF-8"), null);
			HttpGet FCfr7BsT = new HttpGet(hYu4GBl4);
			HttpResponse PdiOj3Ua = p1p2hjME.execute(FCfr7BsT);
			HttpEntity piJfrWJe = PdiOj3Ua.getEntity();
			InputStream iPrl4yow = piJfrWJe.getContent();
			BufferedReader VjurxzMU = new BufferedReader(new InputStreamReader(iPrl4yow, "UTF-8"));
			StringBuffer xdg32IbA = new StringBuffer();
			String agDW5HxH;
			while ((agDW5HxH = VjurxzMU.readLine()) != null) {
				xdg32IbA.append(agDW5HxH);
				xdg32IbA.append("\n");
			}
			VjurxzMU.close();
			stationRes = new StationResponse(xdg32IbA.toString());
		} catch (URISyntaxException nTVMunis) {
			nTVMunis.printStackTrace();
		} catch (ClientProtocolException w1c2NFY3) {
			w1c2NFY3.printStackTrace();
		} catch (IOException ILwgKdDO) {
			ILwgKdDO.printStackTrace();
		} catch (SAXException iBuiuuGt) {
			iBuiuuGt.printStackTrace();
		} catch (ParserConfigurationException cLbQbYzS) {
			cLbQbYzS.printStackTrace();
		} finally {
			mSearchStation.setEnabled(true);
		}
	}

}