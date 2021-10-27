class n5609837 {
	public String postXmlRequest(String AjDc6aTZ, String b2jJZFMq) {
		DefaultHttpClient EpXryM6Y = new DefaultHttpClient();
		HttpPost Sm1Xs2gG = new HttpPost(AjDc6aTZ);
		StringBuffer teQvs8mP = new StringBuffer();
		try {
			System.out.println(b2jJZFMq);
			Log4j.logger.info("Request:\n" + b2jJZFMq);
			StringEntity oQEQQl2D = new StringEntity(b2jJZFMq, "UTF-8");
			oQEQQl2D.setContentType("text/xml");
			Sm1Xs2gG.setEntity(oQEQQl2D);
			HttpResponse MKlzjnQx = EpXryM6Y.execute(Sm1Xs2gG);
			HttpEntity TC3UMEuU = MKlzjnQx.getEntity();
			this.setPostSatus(MKlzjnQx.getStatusLine().getStatusCode());
			BufferedReader HG7NNuzO = new BufferedReader(new InputStreamReader(TC3UMEuU.getContent(), "UTF-8"));
			String fIydkvs1 = null;
			while ((fIydkvs1 = HG7NNuzO.readLine()) != null) {
				teQvs8mP.append(fIydkvs1 + "\n");
			}
			if (TC3UMEuU != null) {
				TC3UMEuU.consumeContent();
			}
		} catch (Exception KGqEA7vP) {
			KGqEA7vP.printStackTrace();
		}
		System.out.println(teQvs8mP);
		Log4j.logger.info("Response:\n" + teQvs8mP);
		return teQvs8mP.toString();
	}

}