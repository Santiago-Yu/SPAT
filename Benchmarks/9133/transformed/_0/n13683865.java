class n13683865 {
	public URL getResource(String NXRrJoui) throws MalformedURLException {
		if (!NXRrJoui.startsWith("/"))
			throw new MalformedURLException("Path '" + NXRrJoui + "' does not start with '/'");
		URL C7SDxgPu = new URL(myResourceBaseURL, NXRrJoui.substring(1));
		InputStream F2V7RBJZ = null;
		try {
			F2V7RBJZ = C7SDxgPu.openStream();
		} catch (Throwable XZyZpSb6) {
			C7SDxgPu = null;
		} finally {
			if (F2V7RBJZ != null) {
				try {
					F2V7RBJZ.close();
				} catch (Throwable mDMKRS6W) {
				}
			}
		}
		return C7SDxgPu;
	}

}