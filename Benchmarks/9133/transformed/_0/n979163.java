class n979163 {
	private List loadPluginFromDir(File P6hR13Gy, boolean ANzqCm0F, boolean FpzqITBv, boolean DhLt6ucD)
			throws PluginException {
		List y4IYKsNA = new ArrayList();
		ClassLoader kHkSWZyp = root_class_loader;
		if (!P6hR13Gy.isDirectory()) {
			return (y4IYKsNA);
		}
		String oDXWlbpo = P6hR13Gy.getName();
		File[] wrrLdUAM = P6hR13Gy.listFiles();
		if (wrrLdUAM == null || wrrLdUAM.length == 0) {
			return (y4IYKsNA);
		}
		boolean gUXlPxPK = false;
		for (int Y3Z7PPpi = 0; Y3Z7PPpi < wrrLdUAM.length; Y3Z7PPpi++) {
			String DBBdsBm4 = wrrLdUAM[Y3Z7PPpi].getName().toLowerCase();
			if (DBBdsBm4.endsWith(".jar") || DBBdsBm4.equals("plugin.properties")) {
				gUXlPxPK = true;
				break;
			}
		}
		if (!gUXlPxPK) {
			if (Logger.isEnabled())
				Logger.log(new LogEvent(LOGID, LogEvent.LT_WARNING,
						"Plugin directory '" + P6hR13Gy + "' has no plugin.properties " + "or .jar files, skipping"));
			return (y4IYKsNA);
		}
		String[] kDc2TEDj = { null };
		String[] nKjJKvOZ = { null };
		wrrLdUAM = PluginLauncherImpl.getHighestJarVersions(wrrLdUAM, kDc2TEDj, nKjJKvOZ, true);
		for (int NNJ5YCUS = 0; NNJ5YCUS < wrrLdUAM.length; NNJ5YCUS++) {
			File IL9CGuSb = wrrLdUAM[NNJ5YCUS];
			if (wrrLdUAM.length > 1) {
				String ef09Zzwj = IL9CGuSb.getName();
				if (ef09Zzwj.startsWith("i18nPlugin_")) {
					if (Logger.isEnabled())
						Logger.log(
								new LogEvent(LOGID, "renaming '" + ef09Zzwj + "' to conform with versioning system"));
					IL9CGuSb.renameTo(new File(IL9CGuSb.getParent(), "i18nAZ_0.1.jar  "));
					continue;
				}
			}
			kHkSWZyp = PluginLauncherImpl.addFileToClassPath(root_class_loader, kHkSWZyp, IL9CGuSb);
		}
		String e5nDhWzO = null;
		try {
			Properties Ne1r5Ccy = new Properties();
			File jgAmWUCs = new File(P6hR13Gy.toString() + File.separator + "plugin.properties");
			try {
				if (jgAmWUCs.exists()) {
					FileInputStream T4QCAtnX = null;
					try {
						T4QCAtnX = new FileInputStream(jgAmWUCs);
						Ne1r5Ccy.load(T4QCAtnX);
					} finally {
						if (T4QCAtnX != null) {
							T4QCAtnX.close();
						}
					}
				} else {
					if (kHkSWZyp instanceof URLClassLoader) {
						URLClassLoader qYrEEvvU = (URLClassLoader) kHkSWZyp;
						URL zoA59hbC = qYrEEvvU.findResource("plugin.properties");
						if (zoA59hbC != null) {
							URLConnection YUj4Tab9 = zoA59hbC.openConnection();
							InputStream P6XEy6eo = YUj4Tab9.getInputStream();
							Ne1r5Ccy.load(P6XEy6eo);
						} else {
							throw (new Exception("failed to load plugin.properties from jars"));
						}
					} else {
						throw (new Exception("failed to load plugin.properties from dir or jars"));
					}
				}
			} catch (Throwable pJX0vW8t) {
				Debug.printStackTrace(pJX0vW8t);
				String K6qLo7X2 = "Can't read 'plugin.properties' for plugin '" + oDXWlbpo + "': file may be missing";
				Logger.log(new LogAlert(LogAlert.UNREPEATABLE, LogAlert.AT_ERROR, K6qLo7X2));
				System.out.println(K6qLo7X2);
				throw (new PluginException(K6qLo7X2, pJX0vW8t));
			}
			checkJDKVersion(oDXWlbpo, Ne1r5Ccy, true);
			checkAzureusVersion(oDXWlbpo, Ne1r5Ccy, true);
			e5nDhWzO = (String) Ne1r5Ccy.get("plugin.class");
			if (e5nDhWzO == null) {
				e5nDhWzO = (String) Ne1r5Ccy.get("plugin.classes");
				if (e5nDhWzO == null) {
					e5nDhWzO = "";
				}
			}
			String fwkRjJc8 = (String) Ne1r5Ccy.get("plugin.name");
			if (fwkRjJc8 == null) {
				fwkRjJc8 = (String) Ne1r5Ccy.get("plugin.names");
			}
			int DpUpCabx = 0;
			int bHmv3zzZ = 0;
			while (true) {
				int VKXeXGmw = e5nDhWzO.indexOf(";", DpUpCabx);
				String WiiXIF2Q;
				if (VKXeXGmw == -1) {
					WiiXIF2Q = e5nDhWzO.substring(DpUpCabx).trim();
				} else {
					WiiXIF2Q = e5nDhWzO.substring(DpUpCabx, VKXeXGmw).trim();
					DpUpCabx = VKXeXGmw + 1;
				}
				PluginInterfaceImpl Q3QE3NtD = getPluginFromClass(WiiXIF2Q);
				if (Q3QE3NtD != null) {
					if (ANzqCm0F) {
						break;
					}
					File cyIQcXUK = P6hR13Gy.getParentFile();
					File lSIp29DW = null;
					if (Q3QE3NtD.getInitializerKey() instanceof File) {
						lSIp29DW = ((File) Q3QE3NtD.getInitializerKey()).getParentFile();
					}
					if (cyIQcXUK.equals(FileUtil.getApplicationFile("plugins")) && lSIp29DW != null
							&& lSIp29DW.equals(FileUtil.getUserFile("plugins"))) {
						if (Logger.isEnabled())
							Logger.log(new LogEvent(LOGID, "Plugin '" + fwkRjJc8 + "/" + WiiXIF2Q
									+ ": shared version overridden by user-specific one"));
						return (new ArrayList());
					} else {
						Logger.log(new LogAlert(LogAlert.UNREPEATABLE, LogAlert.AT_WARNING,
								"Error loading '" + fwkRjJc8 + "', plugin class '" + WiiXIF2Q + "' is already loaded"));
					}
				} else {
					String ZpQHFqEI = null;
					if (fwkRjJc8 != null) {
						int Jr8NFTVW = fwkRjJc8.indexOf(";", bHmv3zzZ);
						if (Jr8NFTVW == -1) {
							ZpQHFqEI = fwkRjJc8.substring(bHmv3zzZ).trim();
						} else {
							ZpQHFqEI = fwkRjJc8.substring(bHmv3zzZ, Jr8NFTVW).trim();
							bHmv3zzZ = Jr8NFTVW + 1;
						}
					}
					Properties oZcxwUsU = (Properties) Ne1r5Ccy.clone();
					for (int KTv0pnEJ = 0; KTv0pnEJ < default_version_details.length; KTv0pnEJ++) {
						if (WiiXIF2Q.equals(default_version_details[KTv0pnEJ][0])) {
							if (oZcxwUsU.get("plugin.id") == null) {
								oZcxwUsU.put("plugin.id", default_version_details[KTv0pnEJ][1]);
							}
							if (ZpQHFqEI == null) {
								ZpQHFqEI = default_version_details[KTv0pnEJ][2];
							}
							if (oZcxwUsU.get("plugin.version") == null) {
								if (kDc2TEDj[0] != null) {
									oZcxwUsU.put("plugin.version", kDc2TEDj[0]);
								} else {
									oZcxwUsU.put("plugin.version", default_version_details[KTv0pnEJ][3]);
								}
							}
						}
					}
					oZcxwUsU.put("plugin.class", WiiXIF2Q);
					if (ZpQHFqEI != null) {
						oZcxwUsU.put("plugin.name", ZpQHFqEI);
					}
					Throwable KxQjKx8m = null;
					String bndU7i6N = nKjJKvOZ[0] == null ? P6hR13Gy.getName() : nKjJKvOZ[0];
					List<File> pFeHLHJ4 = null;
					Plugin JyWaGPnv = null;
					if (vc_disabled_plugins.contains(bndU7i6N)) {
						log("Plugin '" + bndU7i6N + "' has been administratively disabled");
					} else {
						if (bndU7i6N.endsWith("_v")) {
							pFeHLHJ4 = new ArrayList<File>();
							log("Re-verifying " + bndU7i6N);
							for (int nrPA9UNA = 0; nrPA9UNA < wrrLdUAM.length; nrPA9UNA++) {
								File sQCkqiod = wrrLdUAM[nrPA9UNA];
								if (sQCkqiod.getName().endsWith(".jar")) {
									try {
										log("    verifying " + sQCkqiod);
										AEVerifier.verifyData(sQCkqiod);
										pFeHLHJ4.add(sQCkqiod);
										log("    OK");
									} catch (Throwable wjMnETWu) {
										String EBMzjkBs = "Error loading plugin '" + oDXWlbpo + "' / '" + e5nDhWzO
												+ "'";
										Logger.log(new LogAlert(LogAlert.UNREPEATABLE, EBMzjkBs, wjMnETWu));
										JyWaGPnv = new FailedPlugin(ZpQHFqEI, P6hR13Gy.getAbsolutePath());
									}
								}
							}
						}
						if (JyWaGPnv == null) {
							JyWaGPnv = PluginLauncherImpl.getPreloadedPlugin(WiiXIF2Q);
							if (JyWaGPnv == null) {
								try {
									Class sQElK0IT = kHkSWZyp.loadClass(WiiXIF2Q);
									JyWaGPnv = (Plugin) sQElK0IT.newInstance();
								} catch (java.lang.UnsupportedClassVersionError kHnCGVZ5) {
									JyWaGPnv = new FailedPlugin(ZpQHFqEI, P6hR13Gy.getAbsolutePath());
									KxQjKx8m = new UnsupportedClassVersionError(kHnCGVZ5.getMessage());
								} catch (Throwable rqeXu71e) {
									if (rqeXu71e instanceof ClassNotFoundException && Ne1r5Ccy
											.getProperty("plugin.install_if_missing", "no").equalsIgnoreCase("yes")) {
									} else {
										KxQjKx8m = rqeXu71e;
									}
									JyWaGPnv = new FailedPlugin(ZpQHFqEI, P6hR13Gy.getAbsolutePath());
								}
							} else {
								kHkSWZyp = JyWaGPnv.getClass().getClassLoader();
							}
						}
						MessageText.integratePluginMessages((String) Ne1r5Ccy.get("plugin.langfile"), kHkSWZyp);
						PluginInterfaceImpl HAdaQed2 = new PluginInterfaceImpl(JyWaGPnv, this, P6hR13Gy, kHkSWZyp,
								pFeHLHJ4, P6hR13Gy.getName(), oZcxwUsU, P6hR13Gy.getAbsolutePath(), bndU7i6N,
								kDc2TEDj[0]);
						boolean Omi9gx6U = (FpzqITBv) ? HAdaQed2.getPluginState().isLoadedAtStartup() : DhLt6ucD;
						HAdaQed2.getPluginState().setDisabled(!Omi9gx6U);
						try {
							Method vzH142t9 = JyWaGPnv.getClass().getMethod("load",
									new Class[] { PluginInterface.class });
							vzH142t9.invoke(JyWaGPnv, new Object[] { HAdaQed2 });
						} catch (NoSuchMethodException NnzvmHJk) {
						} catch (Throwable qRei6f0P) {
							KxQjKx8m = qRei6f0P;
						}
						y4IYKsNA.add(HAdaQed2);
						if (KxQjKx8m != null) {
							HAdaQed2.setAsFailed();
							if (!bndU7i6N.equals(UpdaterUpdateChecker.getPluginID())) {
								String WUhwhdKq = "Error loading plugin '" + oDXWlbpo + "' / '" + e5nDhWzO + "'";
								LogAlert r8yWv4Iq;
								if (KxQjKx8m instanceof UnsupportedClassVersionError) {
									r8yWv4Iq = new LogAlert(LogAlert.UNREPEATABLE, LogAlert.AT_ERROR, WUhwhdKq + ". "
											+ MessageText.getString("plugin.install.class_version_error"));
								} else {
									r8yWv4Iq = new LogAlert(LogAlert.UNREPEATABLE, WUhwhdKq, KxQjKx8m);
								}
								Logger.log(r8yWv4Iq);
								System.out.println(WUhwhdKq + ": " + KxQjKx8m);
							}
						}
					}
				}
				if (VKXeXGmw == -1) {
					break;
				}
			}
			return (y4IYKsNA);
		} catch (Throwable Dwch1FH9) {
			if (Dwch1FH9 instanceof PluginException) {
				throw ((PluginException) Dwch1FH9);
			}
			Debug.printStackTrace(Dwch1FH9);
			String TLdxKNni = "Error loading plugin '" + oDXWlbpo + "' / '" + e5nDhWzO + "'";
			Logger.log(new LogAlert(LogAlert.UNREPEATABLE, TLdxKNni, Dwch1FH9));
			System.out.println(TLdxKNni + ": " + Dwch1FH9);
			throw (new PluginException(TLdxKNni, Dwch1FH9));
		}
	}

}