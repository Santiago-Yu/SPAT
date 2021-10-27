class n2031877 {
	public byte[] getResponseContent() throws IOException {
		if (responseContent == null) {
			InputStream pmqONZik = getResponseStream();
			if (pmqONZik == null) {
				responseContent = new byte[0];
			} else {
				ByteArrayOutputStream nBcGkGuz = new ByteArrayOutputStream(4096);
				IOUtils.copy(pmqONZik, nBcGkGuz);
				responseContent = nBcGkGuz.toByteArray();
			}
		}
		return responseContent;
	}

}