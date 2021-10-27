class n2060356 {
	private static LaunchablePlugin[] findLaunchablePlugins(LoggerChannelListener listener) {
		List res = new ArrayList();
		File app_dir = getApplicationFile("plugins");
		if (!(app_dir.exists()) && app_dir.isDirectory()) {
			listener.messageLogged(LoggerChannel.LT_ERROR, "Application dir '" + app_dir + "' not found");
			return (new LaunchablePlugin[0]);
		}
		File[] plugins = app_dir.listFiles();
		if (plugins == null || plugins.length == 0) {
			listener.messageLogged(LoggerChannel.LT_ERROR, "Application dir '" + app_dir + "' empty");
			return (new LaunchablePlugin[0]);
		}
		for (int i = 0; i < plugins.length; i++) {
			File plugin_dir = plugins[i];
			if (!plugin_dir.isDirectory()) {
			} else {
				try {
					ClassLoader classLoader = PluginLauncherImpl.class.getClassLoader();
					ClassLoader root_cl = classLoader;
					File[] contents = plugin_dir.listFiles();
					if (contents == null || contents.length == 0) {
						continue;
					}
					String[] plugin_version = { null };
					String[] plugin_id = { null };
					contents = getHighestJarVersions(contents, plugin_version, plugin_id, true);
					for (int j = 0; j < contents.length; j++) {
						classLoader = addFileToClassPath(root_cl, classLoader, contents[j]);
					}
					Properties props = new Properties();
					File properties_file = new File(plugin_dir, "plugin.properties");
					if (properties_file.exists()) {
						FileInputStream fis = null;
						try {
							fis = new FileInputStream(properties_file);
							props.load(fis);
						} finally {
							if (fis != null) {
								fis.close();
							}
						}
					} else {
						if (classLoader instanceof URLClassLoader) {
							URLClassLoader current = (URLClassLoader) classLoader;
							URL url = current.findResource("plugin.properties");
							if (url != null) {
								props.load(url.openStream());
							}
						}
					}
					String plugin_class = (String) props.get("plugin.class");
					if (plugin_class == null || plugin_class.indexOf(';') != -1) {
						continue;
					}
					Class c = classLoader.loadClass(plugin_class);
					Plugin plugin = (Plugin) c.newInstance();
					if (plugin instanceof LaunchablePlugin) {
						preloaded_plugins.put(plugin_class, plugin);
						res.add(plugin);
					}
				} catch (Throwable e) {
					listener.messageLogged("Load of plugin in '" + plugin_dir + "' fails", e);
				}
			}
		}
		LaunchablePlugin[] x = new LaunchablePlugin[res.size()];
		res.toArray(x);
		return (x);
	}

}