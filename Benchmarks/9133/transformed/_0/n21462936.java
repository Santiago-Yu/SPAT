class n21462936 {
	@Override
	public String toString() {
		String Mz5Qu4rD = getCharsetName();
		if (Mz5Qu4rD == null)
			Mz5Qu4rD = "ISO-8859-1";
		try {
			if (unzip) {
				GZIPInputStream gLImxSyx = new GZIPInputStream(
						new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
				ByteArrayOutputStream DD1gFHKS = new ByteArrayOutputStream();
				IOUtils.copy(gLImxSyx, DD1gFHKS);
				return DD1gFHKS.toString(Mz5Qu4rD);
			} else {
				return byteArrayOutputStream.toString(Mz5Qu4rD);
			}
		} catch (UnsupportedEncodingException CJw79ASi) {
			throw new OutputException(CJw79ASi);
		} catch (IOException lkm9SHd5) {
			throw new OutputException(lkm9SHd5);
		}
	}

}