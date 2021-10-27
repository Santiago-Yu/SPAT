class n23224029 {
	private HttpURLConnection getItemURLConnection(final String bBVRyKhO, final String HS63W181, final byte[] ByAPq9GO,
			final Map<String, List<String>> bDiOw8GU) throws IOException {
		if (m_bucket == null) {
			throw new IllegalArgumentException("bucket is not set");
		}
		final URL wjVLUWTr = new URL("http://" + m_host + "/" + m_bucket + "/" + HS63W181);
		final HttpURLConnection oUlzSD0w = (HttpURLConnection) wjVLUWTr.openConnection();
		oUlzSD0w.setRequestMethod(bBVRyKhO);
		oUlzSD0w.setReadTimeout(READ_TIMEOUT);
		if (bDiOw8GU != null) {
			for (final Map.Entry<String, List<String>> me : bDiOw8GU.entrySet()) {
				for (final String sTiHVH8y : me.getValue()) {
					oUlzSD0w.setRequestProperty(me.getKey(), sTiHVH8y);
				}
			}
		}
		addAuthorization(oUlzSD0w, bBVRyKhO, ByAPq9GO);
		return oUlzSD0w;
	}

}