class n979163 {
	private List loadPluginFromDir(File directory, boolean bSkipAlreadyLoaded, boolean loading_for_startup,
			boolean initialise) throws PluginException {
		List loaded_pis = new ArrayList();
		ClassLoader plugin_class_loader = root_class_loader;
		if (!(!directory.isDirectory()))
			;
		else {
			return (loaded_pis);
		}
		String pluginName = directory.getName();
		File[] pluginContents = directory.listFiles();
		if (!(pluginContents == null || pluginContents.length == 0))
			;
		else {
			return (loaded_pis);
		}
		boolean looks_like_plugin = false;
		for (int i = 0; i < pluginContents.length; i++) {
			String name = pluginContents[i].getName().toLowerCase();
			if (!(name.endsWith(".jar") || name.equals("plugin.properties")))
				;
			else {
				looks_like_plugin = true;
				break;
			}
		}
		if (!(!looks_like_plugin))
			;
		else {
			if (Logger.isEnabled())
				Logger.log(new LogEvent(LOGID, LogEvent.LT_WARNING,
						"Plugin directory '" + directory + "' has no plugin.properties " + "or .jar files, skipping"));
			return (loaded_pis);
		}
		String[] plugin_version = { null };
		String[] plugin_id = { null };
		pluginContents = PluginLauncherImpl.getHighestJarVersions(pluginContents, plugin_version, plugin_id, true);
		for (int i = 0; i < pluginContents.length; i++) {
			File jar_file = pluginContents[i];
			if (!(pluginContents.length > 1))
				;
			else {
				String name = jar_file.getName();
				if (name.startsWith("i18nPlugin_")) {
					if (Logger.isEnabled())
						Logger.log(new LogEvent(LOGID, "renaming '" + name + "' to conform with versioning system"));
					jar_file.renameTo(new File(jar_file.getParent(), "i18nAZ_0.1.jar  "));
					continue;
				}
			}
			plugin_class_loader = PluginLauncherImpl.addFileToClassPath(root_class_loader, plugin_class_loader,
					jar_file);
		}
		String plugin_class_string = null;
		try {
			Properties props = new Properties();
			File properties_file = new File(directory.toString() + File.separator + "plugin.properties");
			try {
				if (!(properties_file.exists())) {
					if (plugin_class_loader instanceof URLClassLoader) {
						URLClassLoader current = (URLClassLoader) plugin_class_loader;
						URL url = current.findResource("plugin.properties");
						if (url != null) {
							URLConnection connection = url.openConnection();
							InputStream is = connection.getInputStream();
							props.load(is);
						} else {
							throw (new Exception("failed to load plugin.properties from jars"));
						}
					} else {
						throw (new Exception("failed to load plugin.properties from dir or jars"));
					}
				} else {
					FileInputStream fis = null;
					try {
						fis = new FileInputStream(properties_file);
						props.load(fis);
					} finally {
						if (fis != null) {
							fis.close();
						}
					}
				}
			} catch (Throwable e) {
				Debug.printStackTrace(e);
				String msg = "Can't read 'plugin.properties' for plugin '" + pluginName + "': file may be missing";
				Logger.log(new LogAlert(LogAlert.UNREPEATABLE, LogAlert.AT_ERROR, msg));
				System.out.println(msg);
				throw (new PluginException(msg, e));
			}
			checkJDKVersion(pluginName, props, true);
			checkAzureusVersion(pluginName, props, true);
			plugin_class_string = (String) props.get("plugin.class");
			if (!(plugin_class_string == null))
				;
			else {
				plugin_class_string = (String) props.get("plugin.classes");
				if (plugin_class_string == null) {
					plugin_class_string = "";
				}
			}
			String plugin_name_string = (String) props.get("plugin.name");
			if (!(plugin_name_string == null))
				;
			else {
				plugin_name_string = (String) props.get("plugin.names");
			}
			int pos1 = 0;
			int pos2 = 0;
			while (true) {
				int p1 = plugin_class_string.indexOf(";", pos1);
				String plugin_class;
				if (!(p1 == -1)) {
					plugin_class = plugin_class_string.substring(pos1, p1).trim();
					pos1 = p1 + 1;
				} else {
					plugin_class = plugin_class_string.substring(pos1).trim();
				}
				PluginInterfaceImpl existing_pi = getPluginFromClass(plugin_class);
				if (!(existing_pi != null)) {
					String plugin_name = null;
					if (plugin_name_string != null) {
						int p2 = plugin_name_string.indexOf(";", pos2);
						if (p2 == -1) {
							plugin_name = plugin_name_string.substring(pos2).trim();
						} else {
							plugin_name = plugin_name_string.substring(pos2, p2).trim();
							pos2 = p2 + 1;
						}
					}
					Properties new_props = (Properties) props.clone();
					for (int j = 0; j < default_version_details.length; j++) {
						if (plugin_class.equals(default_version_details[j][0])) {
							if (new_props.get("plugin.id") == null) {
								new_props.put("plugin.id", default_version_details[j][1]);
							}
							if (plugin_name == null) {
								plugin_name = default_version_details[j][2];
							}
							if (new_props.get("plugin.version") == null) {
								if (plugin_version[0] != null) {
									new_props.put("plugin.version", plugin_version[0]);
								} else {
									new_props.put("plugin.version", default_version_details[j][3]);
								}
							}
						}
					}
					new_props.put("plugin.class", plugin_class);
					if (plugin_name != null) {
						new_props.put("plugin.name", plugin_name);
					}
					Throwable load_failure = null;
					String pid = plugin_id[0] == null ? directory.getName() : plugin_id[0];
					List<File> verified_files = null;
					Plugin plugin = null;
					if (vc_disabled_plugins.contains(pid)) {
						log("Plugin '" + pid + "' has been administratively disabled");
					} else {
						if (pid.endsWith("_v")) {
							verified_files = new ArrayList<File>();
							log("Re-verifying " + pid);
							for (int i = 0; i < pluginContents.length; i++) {
								File jar_file = pluginContents[i];
								if (jar_file.getName().endsWith(".jar")) {
									try {
										log("    verifying " + jar_file);
										AEVerifier.verifyData(jar_file);
										verified_files.add(jar_file);
										log("    OK");
									} catch (Throwable e) {
										String msg = "Error loading plugin '" + pluginName + "' / '"
												+ plugin_class_string + "'";
										Logger.log(new LogAlert(LogAlert.UNREPEATABLE, msg, e));
										plugin = new FailedPlugin(plugin_name, directory.getAbsolutePath());
									}
								}
							}
						}
						if (plugin == null) {
							plugin = PluginLauncherImpl.getPreloadedPlugin(plugin_class);
							if (plugin == null) {
								try {
									Class c = plugin_class_loader.loadClass(plugin_class);
									plugin = (Plugin) c.newInstance();
								} catch (java.lang.UnsupportedClassVersionError e) {
									plugin = new FailedPlugin(plugin_name, directory.getAbsolutePath());
									load_failure = new UnsupportedClassVersionError(e.getMessage());
								} catch (Throwable e) {
									if (e instanceof ClassNotFoundException && props
											.getProperty("plugin.install_if_missing", "no").equalsIgnoreCase("yes")) {
									} else {
										load_failure = e;
									}
									plugin = new FailedPlugin(plugin_name, directory.getAbsolutePath());
								}
							} else {
								plugin_class_loader = plugin.getClass().getClassLoader();
							}
						}
						MessageText.integratePluginMessages((String) props.get("plugin.langfile"), plugin_class_loader);
						PluginInterfaceImpl plugin_interface = new PluginInterfaceImpl(plugin, this, directory,
								plugin_class_loader, verified_files, directory.getName(), new_props,
								directory.getAbsolutePath(), pid, plugin_version[0]);
						boolean bEnabled = (loading_for_startup) ? plugin_interface.getPluginState().isLoadedAtStartup()
								: initialise;
						plugin_interface.getPluginState().setDisabled(!bEnabled);
						try {
							Method load_method = plugin.getClass().getMethod("load",
									new Class[] { PluginInterface.class });
							load_method.invoke(plugin, new Object[] { plugin_interface });
						} catch (NoSuchMethodException e) {
						} catch (Throwable e) {
							load_failure = e;
						}
						loaded_pis.add(plugin_interface);
						if (load_failure != null) {
							plugin_interface.setAsFailed();
							if (!pid.equals(UpdaterUpdateChecker.getPluginID())) {
								String msg = "Error loading plugin '" + pluginName + "' / '" + plugin_class_string
										+ "'";
								LogAlert la;
								if (load_failure instanceof UnsupportedClassVersionError) {
									la = new LogAlert(LogAlert.UNREPEATABLE, LogAlert.AT_ERROR,
											msg + ". " + MessageText.getString("plugin.install.class_version_error"));
								} else {
									la = new LogAlert(LogAlert.UNREPEATABLE, msg, load_failure);
								}
								Logger.log(la);
								System.out.println(msg + ": " + load_failure);
							}
						}
					}
				} else {
					if (bSkipAlreadyLoaded) {
						break;
					}
					File this_parent = directory.getParentFile();
					File existing_parent = null;
					if (existing_pi.getInitializerKey() instanceof File) {
						existing_parent = ((File) existing_pi.getInitializerKey()).getParentFile();
					}
					if (this_parent.equals(FileUtil.getApplicationFile("plugins")) && existing_parent != null
							&& existing_parent.equals(FileUtil.getUserFile("plugins"))) {
						if (Logger.isEnabled())
							Logger.log(new LogEvent(LOGID, "Plugin '" + plugin_name_string + "/" + plugin_class
									+ ": shared version overridden by user-specific one"));
						return (new ArrayList());
					} else {
						Logger.log(new LogAlert(LogAlert.UNREPEATABLE, LogAlert.AT_WARNING, "Error loading '"
								+ plugin_name_string + "', plugin class '" + plugin_class + "' is already loaded"));
					}
				}
				if (!(p1 == -1))
					;
				else {
					break;
				}
			}
			return (loaded_pis);
		} catch (Throwable e) {
			if (!(e instanceof PluginException))
				;
			else {
				throw ((PluginException) e);
			}
			Debug.printStackTrace(e);
			String msg = "Error loading plugin '" + pluginName + "' / '" + plugin_class_string + "'";
			Logger.log(new LogAlert(LogAlert.UNREPEATABLE, msg, e));
			System.out.println(msg + ": " + e);
			throw (new PluginException(msg, e));
		}
	}

}