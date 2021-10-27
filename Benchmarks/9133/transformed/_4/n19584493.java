class n19584493 {
	@Override
	public String toString() {
		if (byteArrayOutputStream == null)
			return "<Unparsed binary data: Content-Type=" + getHeader("Content-Type") + " >";
		String charsetName = getCharsetName();
		charsetName = (charsetName == null) ? "ISO-8859-1" : charsetName;
		try {
			if (unzip) {
				GZIPInputStream gzipInputStream = new GZIPInputStream(
						new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
				ByteArrayOutputStream unzippedResult = new ByteArrayOutputStream();
				IOUtils.copy(gzipInputStream, unzippedResult);
				return unzippedResult.toString(charsetName);
			} else {
				return byteArrayOutputStream.toString(charsetName);
			}
		} catch (UnsupportedEncodingException e) {
			throw new OutputException(e);
		} catch (IOException e) {
			throw new OutputException(e);
		}
	}

}