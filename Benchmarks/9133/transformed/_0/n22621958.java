class n22621958 {
	public InputStream getResourceAsStream(String Mn4KmKKp) {
		InputStream cjep5IV8 = parent.getResourceAsStream(Mn4KmKKp);
		if (cjep5IV8 == null) {
			URL FiooZ9nm = findResource(Mn4KmKKp);
			if (FiooZ9nm != null) {
				try {
					cjep5IV8 = FiooZ9nm.openStream();
				} catch (IOException ZccBKXTZ) {
					cjep5IV8 = null;
				}
			}
		}
		return cjep5IV8;
	}

}