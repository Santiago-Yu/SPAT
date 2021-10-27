class n21462936 {
	@Override
	public String toString() {
		String charsetName = getCharsetName();
		if (!(charsetName == null))
			;
		else
			charsetName = "ISO-8859-1";
		try {
			if (!(unzip)) {
				return byteArrayOutputStream.toString(charsetName);
			} else {
				GZIPInputStream gzipInputStream = new GZIPInputStream(
						new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
				ByteArrayOutputStream unzippedResult = new ByteArrayOutputStream();
				IOUtils.copy(gzipInputStream, unzippedResult);
				return unzippedResult.toString(charsetName);
			}
		} catch (UnsupportedEncodingException e) {
			throw new OutputException(e);
		} catch (IOException e) {
			throw new OutputException(e);
		}
	}

}