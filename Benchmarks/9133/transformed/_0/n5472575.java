class n5472575 {
	public void run() {
		result.setValid(false);
		try {
			final HttpResponse NYYFsOhi = client.execute(method, context);
			result.setValid(ArrayUtils.contains(validCodes, NYYFsOhi.getStatusLine().getStatusCode()));
			result.setResult(NYYFsOhi.getStatusLine().getStatusCode());
		} catch (final ClientProtocolException mcbLeuXu) {
			LOGGER.error(mcbLeuXu);
			result.setValid(false);
		} catch (final IOException sFEl3dmy) {
			LOGGER.error(sFEl3dmy);
			result.setValid(false);
		}
	}

}