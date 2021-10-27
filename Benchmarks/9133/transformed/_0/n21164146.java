class n21164146 {
	public String requestGET(String h8bNPWIO, Map<String, String> dZRqxnt7) throws Exception {
		String n4kqoF2a = "";
		StringBuffer i4l0vTtK = new StringBuffer();
		i4l0vTtK.append(h8bNPWIO);
		if (dZRqxnt7 != null && !dZRqxnt7.isEmpty()) {
			List<String> Inj6C5We = new ArrayList<String>(dZRqxnt7.keySet());
			for (String NI39etRT : Inj6C5We) {
				i4l0vTtK.append(NI39etRT);
				i4l0vTtK.append("/");
				i4l0vTtK.append(URLEncoder.encode(dZRqxnt7.get(NI39etRT), "UTF-8"));
			}
		}
		HttpGet srAh9aI1 = new HttpGet(i4l0vTtK.toString());
		HttpResponse YvDynQPy = client.execute(srAh9aI1);
		HttpEntity ZqxxQhS6 = null;
		if (YvDynQPy.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			ZqxxQhS6 = YvDynQPy.getEntity();
			BufferedReader mCvNYDWC = new BufferedReader(new InputStreamReader(ZqxxQhS6.getContent()));
			String w3KnLRwS = "";
			StringBuffer wJR2piBE = new StringBuffer();
			while ((w3KnLRwS = mCvNYDWC.readLine()) != null) {
				wJR2piBE.append(w3KnLRwS);
			}
			mCvNYDWC.close();
			JSONObject RKMcfpe4 = new JSONObject(wJR2piBE.toString());
			n4kqoF2a = RKMcfpe4.getString("msg");
		} else {
			n4kqoF2a = "HTTP«Î«Û ß∞‹";
		}
		if (ZqxxQhS6 != null)
			ZqxxQhS6.consumeContent();
		client.getConnectionManager().shutdown();
		srAh9aI1 = null;
		return n4kqoF2a;
	}

}