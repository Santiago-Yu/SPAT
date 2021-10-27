class n17019839 {
	public Set<Plugin<?>> loadPluginMetaData() throws PluginRegistryException {
		try {
			final Enumeration<URL> dSVNkBWR = JavaSystemHelper.getResources(pluginMetaInfPath);
			pluginsSet.clear();
			if (dSVNkBWR != null) {
				while (dSVNkBWR.hasMoreElements()) {
					final URL GfTaef3H = dSVNkBWR.nextElement();
					echoMessages.add(PluginMessageBundle.getMessage("plugin.info.visitor.resource.found", "interfaces",
							GfTaef3H.getPath()));
					InputStream DDOZAqyc = null;
					Reader Z3kmlCIS = null;
					BufferedReader AvLrX3vZ = null;
					String sYIOwpD9;
					try {
						DDOZAqyc = GfTaef3H.openStream();
						Z3kmlCIS = new InputStreamReader(DDOZAqyc);
						AvLrX3vZ = new BufferedReader(Z3kmlCIS);
						sYIOwpD9 = AvLrX3vZ.readLine();
						while (sYIOwpD9 != null) {
							try {
								if (!StringHelper.isEmpty(sYIOwpD9)) {
									echoMessages.add(PluginMessageBundle.getMessage(
											"plugin.info.visitor.resource.processing", "interface", sYIOwpD9));
									pluginsSet.add(inspectPlugin(Class.forName(sYIOwpD9.trim())));
								}
								sYIOwpD9 = AvLrX3vZ.readLine();
							} catch (final ClassNotFoundException gkKElhyu) {
								throw new PluginRegistryException("plugin.error.load.classnotfound", gkKElhyu,
										pluginMetaInfPath, sYIOwpD9);
							}
						}
					} catch (final IOException oOOebPvq) {
						throw new PluginRegistryException("plugin.error.load.ioe", oOOebPvq,
								GfTaef3H.getFile() + "\n" + GfTaef3H.toString(), oOOebPvq.getMessage());
					} finally {
						if (AvLrX3vZ != null) {
							AvLrX3vZ.close();
						}
						if (Z3kmlCIS != null) {
							Z3kmlCIS.close();
						}
						if (DDOZAqyc != null) {
							DDOZAqyc.close();
						}
					}
				}
			}
			return Collections.unmodifiableSet(pluginsSet);
		} catch (final IOException sfTwlAzh) {
			throw new PluginRegistryException("plugin.error.load.ioe", sfTwlAzh, pluginMetaInfPath,
					sfTwlAzh.getMessage());
		}
	}

}