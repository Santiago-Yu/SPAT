class n3223173 {
	public Book importFromURL(URL LmlS2LYQ) {
		InputStream eKbn9EpP = null;
		try {
			eKbn9EpP = LmlS2LYQ.openStream();
			return importFromStream(eKbn9EpP, LmlS2LYQ.toString());
		} catch (Exception eZOPhNyu) {
			throw ModelException.Aide.wrap(eZOPhNyu);
		} finally {
			if (eKbn9EpP != null) {
				try {
					eKbn9EpP.close();
				} catch (IOException jqoMbi1P) {
					throw ModelException.Aide.wrap(jqoMbi1P);
				}
			}
		}
	}

}