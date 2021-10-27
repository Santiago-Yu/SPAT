class n22198322 {
	private void _loadInternalViews() {
		List<URL> list = new ArrayList<URL>();
		_internalViews = new HashMap<String, InternalView>();
		ClassLoader loader = _getClassLoader();
		try {
			Enumeration<URL> en = loader
					.getResources("META-INF/org.apache.myfaces.trinidad.render.InternalView.properties");
			while (en.hasMoreElements()) {
				list.add(en.nextElement());
			}
			en = loader.getResources("META-INF/org.apache.myfaces.trinidad.InternalView.properties");
			while (en.hasMoreElements()) {
				list.add(en.nextElement());
			}
			Collections.reverse(list);
		} catch (IOException ioe) {
			_LOG.severe(ioe);
		}
		for (URL url : list) {
			try {
				Properties properties = new Properties();
				_LOG.fine("Loading internal views from {0}", url);
				InputStream is = url.openStream();
				try {
					properties.load(is);
				} finally {
					is.close();
				}
				for (Map.Entry<Object, Object> entry : properties.entrySet()) {
					String name = (String) entry.getKey();
					String className = (String) entry.getValue();
					Class<?> clazz = loader.loadClass(className);
					InternalView view = (InternalView) clazz.newInstance();
					_internalViews.put(name, view);
				}
			} catch (IllegalAccessException iae) {
				_LOG.severe("CANNOT_LOAD_URL", url);
				_LOG.severe(iae);
			} catch (InstantiationException ie) {
				_LOG.severe("CANNOT_LOAD_URL", url);
				_LOG.severe(ie);
			} catch (ClassNotFoundException cnfe) {
				_LOG.severe("CANNOT_LOAD_URL", url);
				_LOG.severe(cnfe);
			} catch (IOException ioe) {
				_LOG.severe("CANNOT_LOAD_URL", url);
				_LOG.severe(ioe);
			}
		}
	}

}