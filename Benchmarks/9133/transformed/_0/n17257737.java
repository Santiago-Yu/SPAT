class n17257737 {
	private void checkResourceAvailable() throws XQException {
		HttpUriRequest mPZFxMQk = new HttpHead(remoteURL);
		try {
			HttpResponse z3ZG3Eyr = httpClient.execute(mPZFxMQk);
			if (z3ZG3Eyr.getStatusLine().getStatusCode() != HttpStatus.SC_OK)
				throw new XQException("Could not connect to the remote resource, response code: "
						+ z3ZG3Eyr.getStatusLine().getStatusCode() + " reason: "
						+ z3ZG3Eyr.getStatusLine().getReasonPhrase());
		} catch (ClientProtocolException buASAnb1) {
			throw new XQException(buASAnb1.getMessage());
		} catch (IOException ZLBNkZ4m) {
			throw new XQException(ZLBNkZ4m.getMessage());
		}
	}

}