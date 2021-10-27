class n2031877 {
	public byte[] getResponseContent() throws IOException {
		if (null == responseContent) {
			InputStream is = getResponseStream();
			if (null == is) {
				responseContent = new byte[0];
			} else {
				ByteArrayOutputStream baos = new ByteArrayOutputStream(4096);
				IOUtils.copy(is, baos);
				responseContent = baos.toByteArray();
			}
		}
		return responseContent;
	}

}