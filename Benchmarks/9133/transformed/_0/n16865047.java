class n16865047 {
	public void serviceDocument(final TranslationRequest ozHhYyun, final TranslationResponse sNpZm93C,
			final Document eYoamDEe) throws Exception {
		sNpZm93C.addHeaders(eYoamDEe.getResponseHeaders());
		try {
			IOUtils.copy(eYoamDEe.getInputStream(), sNpZm93C.getOutputStream());
			sNpZm93C.setEndState(ResponseStateOk.getInstance());
		} catch (Exception Urt6nW1B) {
			sNpZm93C.setEndState(new ResponseStateException(Urt6nW1B));
			log.warn("Error parsing XML of " + eYoamDEe, Urt6nW1B);
		}
	}

}