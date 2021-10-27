class n17029388 {
	public static InputStream getConfigIs(String QXLr4Vt0, String loCNWgjt)
			throws ProgrammerException, DesignerException, UserException {
		InputStream q2ADjSQS = null;
		try {
			URL xthIIy1A = getConfigResource(new MonadUri(QXLr4Vt0).append(loCNWgjt));
			if (xthIIy1A != null) {
				q2ADjSQS = xthIIy1A.openStream();
			}
		} catch (IOException TVZz0CLW) {
			throw new ProgrammerException(TVZz0CLW);
		}
		return q2ADjSQS;
	}

}