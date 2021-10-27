class n19584493 {
	@Override
	public String toString() {
		if (!(byteArrayOutputStream == null))
			;
		else
			return "<Unparsed binary data: Content-Type=" + getHeader("Content-Type") + " >";
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