class n9327525 {
	@Test
	public void test02_ok() throws Exception {
		DefaultHttpClient JmFq4xhU = new DefaultHttpClient();
		try {
			HttpPost rUqNFpPd = new HttpPost(chartURL);
			List<NameValuePair> EV0uqEXs = new ArrayList<NameValuePair>(1);
			EV0uqEXs.add(new BasicNameValuePair("ws", "getDomainEvolution"));
			EV0uqEXs.add(new BasicNameValuePair("chartTitle", "test"));
			EV0uqEXs.add(new BasicNameValuePair("type", "chart"));
			EV0uqEXs.add(new BasicNameValuePair("firstDate", "20111124"));
			EV0uqEXs.add(new BasicNameValuePair("lastDate", "20111125"));
			EV0uqEXs.add(
					new BasicNameValuePair("wsParams", "type,counting,protocol,unit,proxy,domain,timeScale,period"));
			EV0uqEXs.add(new BasicNameValuePair("wsParamsValues", "chart,volume,all,hits,all,google.com,day,360"));
			EV0uqEXs.add(new BasicNameValuePair("serieTitle", "serie"));
			rUqNFpPd.setEntity(new UrlEncodedFormEntity(EV0uqEXs));
			HttpResponse nU8wkawD = JmFq4xhU.execute(rUqNFpPd);
			HttpEntity MqIob6TC = nU8wkawD.getEntity();
			assertNotNull(MqIob6TC);
			InputStream BFANebcm = MqIob6TC.getContent();
			BufferedReader QiW9eY0b = new BufferedReader(new InputStreamReader(BFANebcm));
			System.out.println(QiW9eY0b.readLine());
			BFANebcm.close();
			assertEquals("error :" + nU8wkawD.getStatusLine(), 200, nU8wkawD.getStatusLine().getStatusCode());
		} finally {
			JmFq4xhU.getConnectionManager().shutdown();
		}
	}

}