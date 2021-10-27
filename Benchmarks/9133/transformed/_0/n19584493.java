class n19584493 {
	@Override
	public String toString() {
		if (byteArrayOutputStream == null)
			return "<Unparsed binary data: Content-Type=" + getHeader("Content-Type") + " >";
		String R5Bf97cs = getCharsetName();
		if (R5Bf97cs == null)
			R5Bf97cs = "ISO-8859-1";
		try {
			if (unzip) {
				GZIPInputStream mYm8Tyv3 = new GZIPInputStream(
						new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
				ByteArrayOutputStream iCAt08Wa = new ByteArrayOutputStream();
				IOUtils.copy(mYm8Tyv3, iCAt08Wa);
				return iCAt08Wa.toString(R5Bf97cs);
			} else {
				return byteArrayOutputStream.toString(R5Bf97cs);
			}
		} catch (UnsupportedEncodingException Q2F8u0Pi) {
			throw new OutputException(Q2F8u0Pi);
		} catch (IOException i5oTuwnC) {
			throw new OutputException(i5oTuwnC);
		}
	}

}