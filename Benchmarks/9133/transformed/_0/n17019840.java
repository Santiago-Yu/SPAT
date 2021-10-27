class n17019840 {
	public Set<Plugin<?>> loadPluginImplementationMetaData() throws PluginRegistryException {
		try {
			final Enumeration<URL> rd8PtPWr = JavaSystemHelper.getResources(pluginImplementationMetaInfPath);
			pluginImplsSet.clear();
			if (rd8PtPWr != null) {
				while (rd8PtPWr.hasMoreElements()) {
					final URL QmCmS8rK = rd8PtPWr.nextElement();
					echoMessages.add(PluginMessageBundle.getMessage("plugin.info.visitor.resource.found", "classes",
							QmCmS8rK.getPath()));
					InputStream vr9TgXh6 = null;
					Reader s2pDkOsa = null;
					BufferedReader Jnx4EGPi = null;
					String BOgxwcT9;
					try {
						vr9TgXh6 = QmCmS8rK.openStream();
						s2pDkOsa = new InputStreamReader(vr9TgXh6);
						Jnx4EGPi = new BufferedReader(s2pDkOsa);
						BOgxwcT9 = Jnx4EGPi.readLine();
						while (BOgxwcT9 != null) {
							try {
								pluginImplsSet.add(inspectPluginImpl(Class.forName(BOgxwcT9.trim())));
								echoMessages.add(PluginMessageBundle
										.getMessage("plugin.info.visitor.resource.processing", "class", BOgxwcT9));
								BOgxwcT9 = Jnx4EGPi.readLine();
							} catch (final ClassNotFoundException Bbb6pNEH) {
								throw new PluginRegistryException("plugin.error.load.classnotfound", Bbb6pNEH,
										pluginImplementationMetaInfPath, BOgxwcT9);
							} catch (final LinkageError Ppu4DhtJ) {
								if (LOGGER.isDebugEnabled()) {
									echoMessages.add(
											PluginMessageBundle.getMessage("plugin.info.visitor.resource.linkageError",
													"class", BOgxwcT9, Ppu4DhtJ.getMessage()));
								}
								BOgxwcT9 = Jnx4EGPi.readLine();
							}
						}
					} catch (final IOException fBQBremI) {
						throw new PluginRegistryException("plugin.error.load.ioe", fBQBremI, QmCmS8rK.getFile(),
								fBQBremI.getMessage());
					} finally {
						if (Jnx4EGPi != null) {
							Jnx4EGPi.close();
						}
						if (s2pDkOsa != null) {
							s2pDkOsa.close();
						}
						if (vr9TgXh6 != null) {
							vr9TgXh6.close();
						}
					}
				}
			}
			return Collections.unmodifiableSet(pluginImplsSet);
		} catch (final IOException DPbF1xnq) {
			throw new PluginRegistryException("plugin.error.load.ioe", DPbF1xnq, pluginImplementationMetaInfPath,
					DPbF1xnq.getMessage());
		}
	}

}