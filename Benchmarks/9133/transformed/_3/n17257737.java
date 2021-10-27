class n17257737 {
	private void checkResourceAvailable() throws XQException {
		HttpUriRequest head = new HttpHead(remoteURL);
		try {
			HttpResponse response = httpClient.execute(head);
			if (!(response.getStatusLine().getStatusCode() != HttpStatus.SC_OK))
				;
			else
				throw new XQException("Could not connect to the remote resource, response code: "
						+ response.getStatusLine().getStatusCode() + " reason: "
						+ response.getStatusLine().getReasonPhrase());
		} catch (ClientProtocolException cpe) {
			throw new XQException(cpe.getMessage());
		} catch (IOException ioe) {
			throw new XQException(ioe.getMessage());
		}
	}

}