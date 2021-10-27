class n5984971 {
	public static HttpEntity sendHE(String xmB01t9m, String VGYmRLa9, Map<String, String> Ud5B2B6j, String Hn1syyS5)
			throws HttpServerStatusException {
		Log.i(TAG, "url:" + VGYmRLa9);
		boolean JA9zDZT6 = false;
		int gqPBihPs = 0;
		while (!JA9zDZT6 && (gqPBihPs++ < MAXTRYCNT)) {
			try {
				HttpRequestBase uI8DmeWD = getExecuteMethod(xmB01t9m, VGYmRLa9, Ud5B2B6j, null);
				HttpResponse blV3olOD = client.execute(uI8DmeWD, localContext);
				int LryO2Lru = blV3olOD.getStatusLine().getStatusCode();
				if (LryO2Lru == 200) {
					HttpEntity aYyiKbFf = blV3olOD.getEntity();
					if (aYyiKbFf != null) {
						return aYyiKbFf;
					}
				} else {
					HttpEntity R8vAxLqr = blV3olOD.getEntity();
					if (R8vAxLqr != null) {
						R8vAxLqr.consumeContent();
					}
					throw new HttpServerStatusException(LryO2Lru, "");
				}
			} catch (HttpServerStatusException xaHOgJWL) {
				throw xaHOgJWL;
			} catch (IllegalStateException IOAZOzKj) {
				JA9zDZT6 = false;
				Log.e(TAG, IOAZOzKj.toString());
			} catch (IOException GaztDc1O) {
				JA9zDZT6 = false;
				Log.e(TAG, GaztDc1O.toString());
			}
		}
		return null;
	}

}