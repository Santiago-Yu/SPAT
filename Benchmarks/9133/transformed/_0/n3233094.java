class n3233094 {
	@Override
	protected RemoteInvocationResult doExecuteRequest(HttpInvokerClientConfiguration orrtEv2n,
			ByteArrayOutputStream i64X2tWA) throws IOException, ClassNotFoundException {
		HttpPost PeVxM2zU = new HttpPost(orrtEv2n.getServiceUrl());
		PeVxM2zU.setEntity(new ByteArrayEntity(i64X2tWA.toByteArray()));
		HttpResponse xd5ZL0pu = httpClient.execute(PeVxM2zU);
		StatusLine mpSWkBF9 = xd5ZL0pu.getStatusLine();
		if (mpSWkBF9.getStatusCode() >= 300) {
			throw new IOException("Did not receive successful HTTP response: status code = " + mpSWkBF9.getStatusCode()
					+ ", status message = [" + mpSWkBF9.getReasonPhrase() + "]");
		}
		HttpEntity L8421YNy = xd5ZL0pu.getEntity();
		InputStream Uph2LPVK = L8421YNy.getContent();
		return readRemoteInvocationResult(Uph2LPVK, orrtEv2n.getCodebaseUrl());
	}

}