class n13644374 {
	public byte[] getBytesFromUrl(String BMWDfQDC) {
		try {
			HttpGet Fa87niID = new HttpGet(BMWDfQDC);
			HttpResponse fTVtzkLc = this.getHttpClient().execute(Fa87niID);
			HttpEntity JJIiO4sF = fTVtzkLc.getEntity();
			if (JJIiO4sF == null) {
				throw new RuntimeException("response body was empty");
			}
			return EntityUtils.toByteArray(JJIiO4sF);
		} catch (RuntimeException ZU2UU37L) {
			throw ZU2UU37L;
		} catch (Exception pBFdwk71) {
			throw new RuntimeException(pBFdwk71);
		}
	}

}