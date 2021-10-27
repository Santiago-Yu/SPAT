class n5317769 {
	private <T> Collection<Class<? extends T>> loadProviders(final Class<T> providerClass) throws BootstrapException {
		try {
			final String providerNamePrefix = providerClass.getName() + ".";
			final Map<String, Class<? extends T>> providers = new TreeMap<String, Class<? extends T>>(
					new Comparator<String>() {

						public int compare(final String key1, final String key2) {
							return key1.compareTo(key2);
						}
					});
			final File platformProviders = new File(this.getPlatformProviderLocation());
			if (platformProviders.exists()) {
				InputStream in = null;
				final java.util.Properties p = new java.util.Properties();
				try {
					in = new FileInputStream(platformProviders);
					p.load(in);
				} finally {
					if (in != null) {
						in.close();
					}
				}
				for (Map.Entry e : p.entrySet()) {
					if (e.getKey().toString().startsWith(providerNamePrefix)) {
						final Class<?> provider = this.findClass(e.getValue().toString());
						if (provider == null) {
							throw new BootstrapException(getMessage("implementationNotFound", providerClass.getName(),
									e.getValue().toString(), platformProviders.getAbsolutePath()));
						}
						if (!providerClass.isAssignableFrom(provider)) {
							throw new BootstrapException(getMessage("illegalImplementation", providerClass.getName(),
									e.getValue().toString(), platformProviders.getAbsolutePath()));
						}
						providers.put(e.getKey().toString(), provider.asSubclass(providerClass));
					}
				}
			}
			final Enumeration<URL> classpathProviders = this
					.findResources(this.getProviderLocation() + '/' + providerClass.getName());
			for (; classpathProviders.hasMoreElements();) {
				final URL url = classpathProviders.nextElement();
				final BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
				String line = null;
				while ((line = reader.readLine()) != null) {
					if (line.contains("#")) {
						continue;
					}
					final Class<?> provider = this.findClass(line);
					if (provider == null) {
						throw new BootstrapException(getMessage("implementationNotFound", providerClass.getName(), line,
								url.toExternalForm()));
					}
					if (!providerClass.isAssignableFrom(provider)) {
						throw new BootstrapException(getMessage("illegalImplementation", providerClass.getName(), line,
								url.toExternalForm()));
					}
					providers.put(providerNamePrefix + providers.size(), provider.asSubclass(providerClass));
				}
				reader.close();
			}
			return providers.values();
		} catch (final IOException e) {
			throw new BootstrapException(e.getMessage(), e);
		}
	}

}