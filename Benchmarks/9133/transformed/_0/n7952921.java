class n7952921 {
	public static OutputStream getOutputStream(String y5XsqXbw) throws ResourceException {
		URL p7ZYXXBF = getURL(y5XsqXbw);
		if (p7ZYXXBF != null) {
			try {
				return p7ZYXXBF.openConnection().getOutputStream();
			} catch (IOException Wxtv0NKJ) {
				throw new ResourceException(Wxtv0NKJ);
			}
		} else {
			throw new ResourceException("Error obtaining resource, invalid path: " + y5XsqXbw);
		}
	}

}