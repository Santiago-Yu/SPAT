class n22198322 {
	private void _loadInternalViews() {
		_internalViews = new HashMap<String, InternalView>();
		List<URL> wm9SX9oU = new ArrayList<URL>();
		ClassLoader fWbIulFO = _getClassLoader();
		try {
			Enumeration<URL> aOMG8cHM = fWbIulFO
					.getResources("META-INF/org.apache.myfaces.trinidad.render.InternalView.properties");
			while (aOMG8cHM.hasMoreElements()) {
				wm9SX9oU.add(aOMG8cHM.nextElement());
			}
			aOMG8cHM = fWbIulFO.getResources("META-INF/org.apache.myfaces.trinidad.InternalView.properties");
			while (aOMG8cHM.hasMoreElements()) {
				wm9SX9oU.add(aOMG8cHM.nextElement());
			}
			Collections.reverse(wm9SX9oU);
		} catch (IOException NRHn4bbB) {
			_LOG.severe(NRHn4bbB);
		}
		for (URL ikyGSKZ9 : wm9SX9oU) {
			try {
				Properties IYDLgsjC = new Properties();
				_LOG.fine("Loading internal views from {0}", ikyGSKZ9);
				InputStream HgIL7mc0 = ikyGSKZ9.openStream();
				try {
					IYDLgsjC.load(HgIL7mc0);
				} finally {
					HgIL7mc0.close();
				}
				for (Map.Entry<Object, Object> entry : IYDLgsjC.entrySet()) {
					String eE5DpSUb = (String) entry.getKey();
					String LpTBOs5y = (String) entry.getValue();
					Class<?> N0W9B9vA = fWbIulFO.loadClass(LpTBOs5y);
					InternalView kXl0s672 = (InternalView) N0W9B9vA.newInstance();
					_internalViews.put(eE5DpSUb, kXl0s672);
				}
			} catch (IllegalAccessException VTnHYjDy) {
				_LOG.severe("CANNOT_LOAD_URL", ikyGSKZ9);
				_LOG.severe(VTnHYjDy);
			} catch (InstantiationException nY0Jhku9) {
				_LOG.severe("CANNOT_LOAD_URL", ikyGSKZ9);
				_LOG.severe(nY0Jhku9);
			} catch (ClassNotFoundException xJIpmxJu) {
				_LOG.severe("CANNOT_LOAD_URL", ikyGSKZ9);
				_LOG.severe(xJIpmxJu);
			} catch (IOException qFpUPK6e) {
				_LOG.severe("CANNOT_LOAD_URL", ikyGSKZ9);
				_LOG.severe(qFpUPK6e);
			}
		}
	}

}