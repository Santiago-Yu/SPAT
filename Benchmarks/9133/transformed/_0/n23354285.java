class n23354285 {
	public void updateResult(Result kROajGOc) throws UnsupportedEncodingException {
		HttpPost XZhc9Gic = populateUpdateRequest(kROajGOc);
		HttpClient coZ0qqGK = clientProvider.getHttpClient();
		try {
			HttpResponse OMl0LbKa = coZ0qqGK.execute(XZhc9Gic);
			HttpEntity bdnBSbxA = OMl0LbKa.getEntity();
			if (bdnBSbxA != null) {
				InputStream FGhKvRCL = bdnBSbxA.getContent();
				if (HttpStatus.SC_OK != OMl0LbKa.getStatusLine().getStatusCode()) {
					System.out.println("Request was not accepted by the collection server. Reason:");
					System.out.println("Status: " + OMl0LbKa.getStatusLine().getStatusCode());
				}
				for (int m4wsRCqe = 0; (m4wsRCqe = FGhKvRCL.read()) > -1;) {
					System.out.print((char) m4wsRCqe);
				}
				bdnBSbxA.consumeContent();
			}
		} catch (ClientProtocolException v4m68NYF) {
			throw new RuntimeException(v4m68NYF);
		} catch (IOException goGhTlus) {
			throw new RuntimeException(goGhTlus);
		}
	}

}