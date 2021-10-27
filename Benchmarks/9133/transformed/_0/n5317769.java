class n5317769 {
	private <T> Collection<Class<? extends T>> loadProviders(final Class<T> qTG5GwJA) throws BootstrapException {
		try {
			final String q8CH4lrO = qTG5GwJA.getName() + ".";
			final Map<String, Class<? extends T>> L2TifdhR = new TreeMap<String, Class<? extends T>>(
					new Comparator<String>() {

						public int compare(final String gYeuRlmE, final String qYrb72Mv) {
							return gYeuRlmE.compareTo(qYrb72Mv);
						}
					});
			final File A7C7sWgp = new File(this.getPlatformProviderLocation());
			if (A7C7sWgp.exists()) {
				InputStream iUXwPJf7 = null;
				final java.util.Properties CTPuhsGj = new java.util.Properties();
				try {
					iUXwPJf7 = new FileInputStream(A7C7sWgp);
					CTPuhsGj.load(iUXwPJf7);
				} finally {
					if (iUXwPJf7 != null) {
						iUXwPJf7.close();
					}
				}
				for (Map.Entry w1yTd5IF : CTPuhsGj.entrySet()) {
					if (w1yTd5IF.getKey().toString().startsWith(q8CH4lrO)) {
						final Class<?> l0SBwxwx = this.findClass(w1yTd5IF.getValue().toString());
						if (l0SBwxwx == null) {
							throw new BootstrapException(getMessage("implementationNotFound", qTG5GwJA.getName(),
									w1yTd5IF.getValue().toString(), A7C7sWgp.getAbsolutePath()));
						}
						if (!qTG5GwJA.isAssignableFrom(l0SBwxwx)) {
							throw new BootstrapException(getMessage("illegalImplementation", qTG5GwJA.getName(),
									w1yTd5IF.getValue().toString(), A7C7sWgp.getAbsolutePath()));
						}
						L2TifdhR.put(w1yTd5IF.getKey().toString(), l0SBwxwx.asSubclass(qTG5GwJA));
					}
				}
			}
			final Enumeration<URL> uWvUgD4X = this.findResources(this.getProviderLocation() + '/' + qTG5GwJA.getName());
			while (uWvUgD4X.hasMoreElements()) {
				final URL OxaExKa6 = uWvUgD4X.nextElement();
				final BufferedReader SWDzwgKY = new BufferedReader(
						new InputStreamReader(OxaExKa6.openStream(), "UTF-8"));
				String iqcoyURr = null;
				while ((iqcoyURr = SWDzwgKY.readLine()) != null) {
					if (iqcoyURr.contains("#")) {
						continue;
					}
					final Class<?> p5JCJ6bL = this.findClass(iqcoyURr);
					if (p5JCJ6bL == null) {
						throw new BootstrapException(getMessage("implementationNotFound", qTG5GwJA.getName(), iqcoyURr,
								OxaExKa6.toExternalForm()));
					}
					if (!qTG5GwJA.isAssignableFrom(p5JCJ6bL)) {
						throw new BootstrapException(getMessage("illegalImplementation", qTG5GwJA.getName(), iqcoyURr,
								OxaExKa6.toExternalForm()));
					}
					L2TifdhR.put(q8CH4lrO + L2TifdhR.size(), p5JCJ6bL.asSubclass(qTG5GwJA));
				}
				SWDzwgKY.close();
			}
			return L2TifdhR.values();
		} catch (final IOException RWNRlYfV) {
			throw new BootstrapException(RWNRlYfV.getMessage(), RWNRlYfV);
		}
	}

}