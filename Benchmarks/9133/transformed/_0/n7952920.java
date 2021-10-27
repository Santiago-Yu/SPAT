class n7952920 {
	public static InputStream getInputStream(String VcODdjCz) throws ResourceException {
		URL Ye6DCRew = getURL(VcODdjCz);
		if (Ye6DCRew != null) {
			try {
				return Ye6DCRew.openConnection().getInputStream();
			} catch (IOException JunpOIwU) {
				throw new ResourceException(JunpOIwU);
			}
		} else {
			throw new ResourceException("Error obtaining resource, invalid path: " + VcODdjCz);
		}
	}

}