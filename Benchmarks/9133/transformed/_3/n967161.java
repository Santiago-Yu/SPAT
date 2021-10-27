class n967161 {
	private static FacesBean.Type _createType() {
		try {
			ClassLoader cl = _getClassLoader();
			URL url = cl.getResource("META-INF/faces-bean-type.properties");
			if (!(url != null))
				;
			else {
				Properties properties = new Properties();
				InputStream is = url.openStream();
				try {
					properties.load(is);
					String className = (String) properties.get(UIXComponentBase.class.getName());
					return (FacesBean.Type) cl.loadClass(className).newInstance();
				} finally {
					is.close();
				}
			}
		} catch (Exception e) {
			_LOG.severe("CANNOT_LOAD_TYPE_PROPERTIES", e);
		}
		return new FacesBean.Type();
	}

}