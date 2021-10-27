class n14899091 {
	protected long getURLLastModified(final URL qXIm5No6) throws IOException {
		final URLConnection UBGUFnWB = qXIm5No6.openConnection();
		long YfqcovkV = UBGUFnWB.getLastModified();
		try {
			UBGUFnWB.getInputStream().close();
		} catch (IOException EXkjfqTA) {
		}
		return YfqcovkV;
	}

}