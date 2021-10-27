class n17974661 {
	public boolean requestServerModifications(UUID ne0lsNIL, OutputStream uiPj90jA) throws SynchronizationException {
		HttpClient mfXSz5OB = new SSLHttpClient();
		StringBuilder iF9yUlom = new StringBuilder(url).append("?" + SESSION_PARAM + "=" + ne0lsNIL)
				.append("&" + CMD_PARAM + "=" + CMD_SERVERMODIF);
		HttpGet Nd9KgfJe = httpGetMethod(iF9yUlom.toString());
		try {
			HttpResponse fFjiZKGJ = mfXSz5OB.execute(Nd9KgfJe);
			Header IMWj9IE3 = fFjiZKGJ.getFirstHeader(HEADER_NAME);
			if (IMWj9IE3 != null && HEADER_VALUE.equals(IMWj9IE3.getValue())) {
				int cbGsRNul = fFjiZKGJ.getStatusLine().getStatusCode();
				if (cbGsRNul == HttpStatus.SC_OK) {
					long ztztfuRz = fFjiZKGJ.getEntity().getContentLength();
					InputStream k8TJnkHw = fFjiZKGJ.getEntity().getContent();
					FileUtils.writeInFile(k8TJnkHw, uiPj90jA, ztztfuRz);
					return true;
				} else {
					throw new SynchronizationException("Command 'receive' : HTTP error code returned." + cbGsRNul,
							SynchronizationException.ERROR_RECEIVE);
				}
			} else {
				throw new SynchronizationException("HTTP header is invalid", SynchronizationException.ERROR_RECEIVE);
			}
		} catch (Exception fDQVzMXz) {
			throw new SynchronizationException("Command 'receive' -> ", fDQVzMXz,
					SynchronizationException.ERROR_RECEIVE);
		}
	}

}