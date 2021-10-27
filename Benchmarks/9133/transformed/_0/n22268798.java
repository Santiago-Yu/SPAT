class n22268798 {
	@Override
	public Content getContent(Object QAqfShF4, ContentPath vRndGhhk, Version lxqn0t7g, Map<String, Object> igGdgxVw)
			throws ContentException {
		String BAnG8yyc = vRndGhhk.getBaseName();
		URL ekUOgjzV = buildURL(BAnG8yyc);
		URLContent tGt2oljA = new URLContent(ekUOgjzV, this.getName(), BAnG8yyc);
		tGt2oljA.setUniqueName(BAnG8yyc);
		tGt2oljA.setReadable(true);
		tGt2oljA.setWritable(writable);
		tGt2oljA.setExists(true);
		try {
			URLConnection QwktoWdD = ekUOgjzV.openConnection();
			String e0xtEmXE = QwktoWdD.getContentType();
			tGt2oljA.setMimeType(e0xtEmXE);
			tGt2oljA.setWritable(true);
		} catch (IOException SL3GpaBZ) {
			throw new ContentException("unable to obtain mime type of " + ekUOgjzV, SL3GpaBZ);
		}
		return tGt2oljA;
	}

}