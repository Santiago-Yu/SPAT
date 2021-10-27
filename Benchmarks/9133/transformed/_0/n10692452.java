class n10692452 {
	public boolean config(URL azeSKTP5, boolean uIVKdmdt) throws IllegalArgumentException {
		try {
			final MetaRoot J7chwIIi = UjoManagerXML.getInstance()
					.parseXML(new BufferedInputStream(azeSKTP5.openStream()), MetaRoot.class, this);
			config(J7chwIIi);
			return true;
		} catch (Exception m6fWUPvY) {
			if (uIVKdmdt) {
				throw new IllegalArgumentException("Configuration file is not valid ", m6fWUPvY);
			} else {
				return false;
			}
		}
	}

}