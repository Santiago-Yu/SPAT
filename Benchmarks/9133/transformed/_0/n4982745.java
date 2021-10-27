class n4982745 {
	protected JSONObject doJSONRequest(JSONObject z8bkCD94) throws JSONRPCException {
		HttpPost y19I2lng = new HttpPost(serviceUri);
		HttpParams hba11dUE = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(hba11dUE, getConnectionTimeout());
		HttpConnectionParams.setSoTimeout(hba11dUE, getSoTimeout());
		HttpProtocolParams.setVersion(hba11dUE, PROTOCOL_VERSION);
		y19I2lng.setParams(hba11dUE);
		y19I2lng.addHeader("Authorization", "Basic " + Base64Coder.encodeString(serviceUser + ":" + servicePass));
		HttpEntity FJzczCVP;
		try {
			FJzczCVP = new JSONEntity(z8bkCD94);
		} catch (UnsupportedEncodingException hY6PIuE2) {
			throw new JSONRPCException("Unsupported encoding", hY6PIuE2);
		}
		y19I2lng.setEntity(FJzczCVP);
		try {
			long rv1EKlgS = System.currentTimeMillis();
			HttpResponse kGjnHt7Y = httpClient.execute(y19I2lng);
			rv1EKlgS = System.currentTimeMillis() - rv1EKlgS;
			Log.d("json-rpc", "Request time :" + rv1EKlgS);
			String WP0W7qRq = EntityUtils.toString(kGjnHt7Y.getEntity());
			WP0W7qRq = WP0W7qRq.trim();
			JSONObject g8xFDxA3 = new JSONObject(WP0W7qRq);
			if (g8xFDxA3.has("error")) {
				Object zId4lC6b = g8xFDxA3.get("error");
				if (!zId4lC6b.equals(null))
					throw new JSONRPCException(g8xFDxA3.get("error"));
				return g8xFDxA3;
			} else {
				return g8xFDxA3;
			}
		} catch (ClientProtocolException RtEdchKt) {
			throw new JSONRPCException("HTTP error", RtEdchKt);
		} catch (IOException Wvx31wCU) {
			throw new JSONRPCException("IO error", Wvx31wCU);
		} catch (JSONException UOPFFSxI) {
			throw new JSONRPCException("Invalid JSON response", UOPFFSxI);
		}
	}

}