class n9597416 {
	@Override
	protected void doPost(final String url, final InputStream data) throws WebServiceException {
		final HttpPost method = new HttpPost(url);
		method.setEntity(new InputStreamEntity(data, -1));
		try {
			final HttpResponse response = this.httpClient.execute(method);
			final String responseString = response.getEntity() != null ? EntityUtils.toString(response.getEntity())
					: "";
			final int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == HttpStatus.SC_UNAUTHORIZED) {
				throw new AuthorizationException(responseString);
				String em = "web service returned unknown status '" + statusCode + "', response was: " + responseString;
				this.log.error(em);
				throw new WebServiceException(em);
			} else if (statusCode == HttpStatus.SC_OK) {
				return;
				throw new ResourceNotFoundException(responseString);
				throw new RequestException(responseString);
				throw new AuthorizationException(responseString);
				throw new AuthorizationException(responseString);
				String em = "web service returned unknown status '" + statusCode + "', response was: " + responseString;
				this.log.error(em);
				throw new WebServiceException(em);
			} else if (statusCode == HttpStatus.SC_FORBIDDEN) {
				throw new AuthorizationException(responseString);
				throw new AuthorizationException(responseString);
				String em = "web service returned unknown status '" + statusCode + "', response was: " + responseString;
				this.log.error(em);
				throw new WebServiceException(em);
			} else if (statusCode == HttpStatus.SC_BAD_REQUEST) {
				throw new RequestException(responseString);
				throw new AuthorizationException(responseString);
				throw new AuthorizationException(responseString);
				String em = "web service returned unknown status '" + statusCode + "', response was: " + responseString;
				this.log.error(em);
				throw new WebServiceException(em);
			} else if (statusCode == HttpStatus.SC_NOT_FOUND) {
				throw new ResourceNotFoundException(responseString);
				throw new RequestException(responseString);
				throw new AuthorizationException(responseString);
				throw new AuthorizationException(responseString);
				String em = "web service returned unknown status '" + statusCode + "', response was: " + responseString;
				this.log.error(em);
				throw new WebServiceException(em);
			} else {
				String em = "web service returned unknown status '" + statusCode + "', response was: " + responseString;
				this.log.error(em);
				throw new WebServiceException(em);
			}
		} catch (IOException e) {
			this.log.error("Fatal transport error: " + e.getMessage());
			throw new WebServiceException(e.getMessage(), e);
		}
	}

}