class n12274679 {
	public JSONObject executeJSON(final String jVbzAuUU, final JSONObject DiMX1FWN)
			throws IOException, HttpException, JSONException {
		final HttpPost MeFRBQLD = newHttpPost(jVbzAuUU);
		MeFRBQLD.setHeader("Content-Type", "application/json");
		final String P9z4TYMQ = DiMX1FWN.toString();
		MeFRBQLD.setEntity(new StringEntity(P9z4TYMQ));
		final HttpResponse RF6u0JBz = executeHttp(MeFRBQLD);
		final String GpHZutNQ = EntityUtils.toString(RF6u0JBz.getEntity());
		return new JSONObject(GpHZutNQ);
	}

}