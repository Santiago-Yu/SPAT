class n5112157 {
	public File mergeDoc(URL urlDoc, File fOutput, boolean bMulti) throws Exception {
		File fOut = null;
		if (s_log.isTraceEnabled())
			trace(0, "Copying from " + urlDoc.toString() + " to " + fOutput.toString());
		InputStream is = null;
		try {
			is = urlDoc.openStream();
			fOut = mergeDoc(is, fOutput, bMulti);
		} finally {
			is.close();
		}
		return fOut;
	}

}