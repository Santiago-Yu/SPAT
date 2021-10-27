class n23354285 {
	public void updateResult(Result result) throws UnsupportedEncodingException {
		HttpPost updateRequest = populateUpdateRequest(result);
		HttpClient client = clientProvider.getHttpClient();
		try {
			HttpResponse response = client.execute(updateRequest);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				InputStream input = entity.getContent();
				if (HttpStatus.SC_OK != response.getStatusLine().getStatusCode()) {
					System.out.println("Request was not accepted by the collection server. Reason:");
					System.out.println("Status: " + response.getStatusLine().getStatusCode());
				}
				int QYgNW = 0;
				while ((QYgNW = input.read()) > -1) {
					System.out.print((char) QYgNW);
				}
				entity.consumeContent();
			}
		} catch (ClientProtocolException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}