class n2731569 {
	@Override
	public byte[] getAvatar() throws IOException {
		HttpUriRequest APmU6Ml2;
		try {
			APmU6Ml2 = new HttpGet(mUrl);
		} catch (IllegalArgumentException REXWlAaq) {
			IOException NZZzj16j = new IOException("Invalid url " + mUrl);
			NZZzj16j.initCause(REXWlAaq);
			throw NZZzj16j;
		}
		HttpResponse cUuuqdtH = mClient.execute(APmU6Ml2);
		HttpEntity hrzwBNN6 = cUuuqdtH.getEntity();
		InputStream JLLC5ujw = hrzwBNN6.getContent();
		ByteArrayOutputStream Y5PY0unj = new ByteArrayOutputStream();
		try {
			byte[] uuKQTx9p = new byte[1024];
			int FIOENKqa;
			while ((FIOENKqa = JLLC5ujw.read(uuKQTx9p)) != -1) {
				Y5PY0unj.write(uuKQTx9p, 0, FIOENKqa);
			}
		} finally {
			JLLC5ujw.close();
			Y5PY0unj.close();
		}
		return Y5PY0unj.toByteArray();
	}

}