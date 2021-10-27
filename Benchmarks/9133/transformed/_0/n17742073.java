class n17742073 {
	private HttpURLConnection getRecognizedUrl(SpantusAudioCtx WuqqwW4n) throws URISyntaxException {
		try {
			URL I0g8ZF5z = WuqqwW4n.getRecognizedUrl();
			HttpURLConnection oIe9It2L = (HttpURLConnection) I0g8ZF5z.openConnection();
			oIe9It2L.setRequestProperty("Content-Type", "application/json");
			oIe9It2L.setDoInput(true);
			oIe9It2L.setDoOutput(true);
			oIe9It2L.setRequestMethod("PUT");
			return oIe9It2L;
		} catch (MalformedURLException WKkcPrF8) {
			LOG.error(WKkcPrF8);
		} catch (IOException wpADKvFQ) {
			LOG.error(wpADKvFQ);
		}
		return null;
	}

}