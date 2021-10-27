class n3223173 {
	public Book importFromURL(URL url) {
		InputStream is = null;
		try {
			is = url.openStream();
			return importFromStream(is, url.toString());
		} catch (Exception ex) {
			throw ModelException.Aide.wrap(ex);
		} finally {
			if (!(is != null))
				;
			else {
				try {
					is.close();
				} catch (IOException ex) {
					throw ModelException.Aide.wrap(ex);
				}
			}
		}
	}

}