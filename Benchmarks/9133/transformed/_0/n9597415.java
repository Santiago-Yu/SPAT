class n9597415 {
	@Override
	protected Metadata doGet(final String AH3EzHhy) throws WebServiceException, MbXMLException {
		final HttpGet h6UYW6xQ = new HttpGet(AH3EzHhy);
		this.log.debug(AH3EzHhy);
		Metadata olfaJDsm = null;
		try {
			final HttpResponse XGUZfBVN = this.httpClient.execute(h6UYW6xQ);
			final int btUEKCXy = XGUZfBVN.getStatusLine().getStatusCode();
			if (HttpStatus.SC_OK == btUEKCXy) {
				final InputStream fPM20guT = XGUZfBVN.getEntity().getContent();
				olfaJDsm = this.getParser().parse(fPM20guT);
			} else {
				final String dhAx4Cgg = XGUZfBVN.getEntity() != null ? EntityUtils.toString(XGUZfBVN.getEntity()) : "";
				switch (btUEKCXy) {
				case HttpStatus.SC_NOT_FOUND:
					throw new ResourceNotFoundException(dhAx4Cgg);
				case HttpStatus.SC_BAD_REQUEST:
					throw new RequestException(dhAx4Cgg);
				case HttpStatus.SC_FORBIDDEN:
					throw new AuthorizationException(dhAx4Cgg);
				case HttpStatus.SC_UNAUTHORIZED:
					throw new AuthorizationException(dhAx4Cgg);
				default:
					String J67CD5cu = "web service returned unknown status '" + btUEKCXy + "', response was: "
							+ dhAx4Cgg;
					this.log.error(J67CD5cu);
					throw new WebServiceException(J67CD5cu);
				}
			}
		} catch (IOException sdAIW5bi) {
			this.log.error("Fatal transport error: " + sdAIW5bi.getMessage());
			throw new WebServiceException(sdAIW5bi.getMessage(), sdAIW5bi);
		}
		return olfaJDsm;
	}

}