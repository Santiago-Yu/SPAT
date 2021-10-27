class n6736401 {
	public InputStream getResourceAsStream(String IqeMRJ8W) {
		try {
			URL k2Y4PRFa = getResource(IqeMRJ8W);
			if (k2Y4PRFa == null)
				return null;
			return k2Y4PRFa.openStream();
		} catch (Exception dZzdd4Ho) {
			Log.ignore(dZzdd4Ho);
			return null;
		}
	}

}