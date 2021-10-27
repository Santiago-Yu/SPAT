class n19080745 {
	public static Image getPluginImage(Object rN5tRKfZ, String obzpdiPY) {
		try {
			URL iSWzrvka = getPluginImageURL(rN5tRKfZ, obzpdiPY);
			InputStream cfbZZUle = iSWzrvka.openStream();
			Image Bsu6RXFC;
			try {
				Bsu6RXFC = getImage(cfbZZUle);
			} finally {
				cfbZZUle.close();
			}
			return Bsu6RXFC;
		} catch (Throwable bUrKv9oT) {
		}
		return null;
	}

}