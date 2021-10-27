class n5229696 {
	public static HttpsURLConnection createRequest(String Uu5LHRtM, String dawMjdT7, Map<String, String> UYNSKQ2l)
			throws BuzzIOException {
		HttpsURLConnection qrNwg05q;
		try {
			URL jwAy1EhU = new URL(Uu5LHRtM);
			qrNwg05q = (HttpsURLConnection) jwAy1EhU.openConnection();
			qrNwg05q.setRequestMethod(dawMjdT7);
			if (UYNSKQ2l != null && !UYNSKQ2l.isEmpty()) {
				for (String cC9vRqGH : UYNSKQ2l.keySet()) {
					qrNwg05q.setRequestProperty(cC9vRqGH, UYNSKQ2l.get(cC9vRqGH));
				}
			}
		} catch (IOException ZLyfqLr1) {
			throw new BuzzIOException(ZLyfqLr1);
		}
		return qrNwg05q;
	}

}