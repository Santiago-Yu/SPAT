class n22627884 {
	private <T> Collection<T> loadProviders(final Class<T> providerClass) throws ModelException {
		try {
			final String providerNamePrefix = providerClass.getName() + ".";
			final File platformProviders = new File(this.getPlatformProviderLocation());
			final Map<String, T> providers = new TreeMap<String, T>(new Comparator<String>() {
				public int compare(final String key1, final String key2) {
					return key1.compareTo(key2);
				}
			});
			if (platformProviders.exists()) {
				InputStream in = null;
				if (this.isLoggable(Level.FINEST)) {
					this.log(Level.FINEST, getMessage("processing", platformProviders.getAbsolutePath()), null);
				}
				final java.util.Properties p = new java.util.Properties();
				boolean suppressExceptionOnClose = true;
				try {
					in = new FileInputStream(platformProviders);
					p.load(in);
					suppressExceptionOnClose = false;
				} finally {
					try {
						if (in != null) {
							in.close();
						}
					} catch (final IOException e) {
						if (suppressExceptionOnClose) {
							this.log(Level.SEVERE, getMessage(e), e);
						} else {
							throw e;
						}
					}
				}
				for (Map.Entry<Object, Object> e : p.entrySet()) {
					if (e.getKey().toString().startsWith(providerNamePrefix)) {
						final String configuration = e.getValue().toString();
						if (this.isLoggable(Level.FINEST)) {
							this.log(Level.FINEST, getMessage("providerInfo", platformProviders.getAbsolutePath(),
									providerClass.getName(), configuration), null);
						}
						providers.put(e.getKey().toString(), this.createProviderObject(providerClass, configuration,
								platformProviders.toURI().toURL()));
					}
				}
			}
			int count = 0;
			final Enumeration<URL> classpathProviders = this
					.findResources(this.getProviderLocation() + '/' + providerClass.getName());
			while (classpathProviders.hasMoreElements()) {
				count++;
				final URL url = classpathProviders.nextElement();
				if (this.isLoggable(Level.FINEST)) {
					this.log(Level.FINEST, getMessage("processing", url.toExternalForm()), null);
				}
				BufferedReader reader = null;
				boolean suppressExceptionOnClose = true;
				try {
					reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
					String line = null;
					while ((line = reader.readLine()) != null) {
						if (line.contains("#")) {
							continue;
						}
						if (this.isLoggable(Level.FINEST)) {
							this.log(Level.FINEST,
									getMessage("providerInfo", url.toExternalForm(), providerClass.getName(), line),
									null);
						}
						providers.put(providerNamePrefix + providers.size(),
								this.createProviderObject(providerClass, line, url));
					}
					suppressExceptionOnClose = false;
				} finally {
					try {
						if (reader != null) {
							reader.close();
						}
					} catch (final IOException e) {
						if (suppressExceptionOnClose) {
							this.log(Level.SEVERE, getMessage(e), e);
						} else {
							throw new ModelException(getMessage(e), e);
						}
					}
				}
			}
			final long t0 = System.currentTimeMillis();
			if (this.isLoggable(Level.FINE)) {
				this.log(Level.FINE,
						getMessage("contextReport", count, this.getProviderLocation() + '/' + providerClass.getName(),
								Long.valueOf(System.currentTimeMillis() - t0)),
						null);
			}
			return providers.values();
		} catch (final IOException e) {
			throw new ModelException(getMessage(e), e);
		}
	}

}