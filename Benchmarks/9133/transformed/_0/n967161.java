class n967161 {
	private static FacesBean.Type _createType() {
		try {
			ClassLoader X9f0sk9Q = _getClassLoader();
			URL saS1O69n = X9f0sk9Q.getResource("META-INF/faces-bean-type.properties");
			if (saS1O69n != null) {
				Properties AKUdQbPp = new Properties();
				InputStream hYhAA5ye = saS1O69n.openStream();
				try {
					AKUdQbPp.load(hYhAA5ye);
					String njoSwFao = (String) AKUdQbPp.get(UIXComponentBase.class.getName());
					return (FacesBean.Type) X9f0sk9Q.loadClass(njoSwFao).newInstance();
				} finally {
					hYhAA5ye.close();
				}
			}
		} catch (Exception De1LPBDC) {
			_LOG.severe("CANNOT_LOAD_TYPE_PROPERTIES", De1LPBDC);
		}
		return new FacesBean.Type();
	}

}