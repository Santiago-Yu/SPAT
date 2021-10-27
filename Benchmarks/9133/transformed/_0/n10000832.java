class n10000832 {
	public static void main(String[] L9gJNDgs) {
		LogFrame.getInstance();
		for (int qrfAaNfr = 0; qrfAaNfr < L9gJNDgs.length; qrfAaNfr++) {
			String Fiv8viu9 = L9gJNDgs[qrfAaNfr];
			if (Fiv8viu9.trim().startsWith(DEBUG_PARAMETER_NAME + "=")) {
				properties.put(DEBUG_PARAMETER_NAME,
						Fiv8viu9.trim().substring(DEBUG_PARAMETER_NAME.length() + 1).trim());
				if (properties.getProperty(DEBUG_PARAMETER_NAME).toLowerCase().equals(DEBUG_TRUE)) {
					DEBUG = true;
				}
			} else if (Fiv8viu9.trim().startsWith(MODE_PARAMETER_NAME + "=")) {
				properties.put(MODE_PARAMETER_NAME, Fiv8viu9.trim().substring(MODE_PARAMETER_NAME.length() + 1).trim());
			} else if (Fiv8viu9.trim().startsWith(AUTOCONNECT_PARAMETER_NAME + "=")) {
				properties.put(AUTOCONNECT_PARAMETER_NAME,
						Fiv8viu9.trim().substring(AUTOCONNECT_PARAMETER_NAME.length() + 1).trim());
			} else if (Fiv8viu9.trim().startsWith(SITE_CONFIG_URL_PARAMETER_NAME + "=")) {
				properties.put(SITE_CONFIG_URL_PARAMETER_NAME,
						Fiv8viu9.trim().substring(SITE_CONFIG_URL_PARAMETER_NAME.length() + 1).trim());
			} else if (Fiv8viu9.trim().startsWith(LOAD_PLUGINS_PARAMETER_NAME + "=")) {
				properties.put(LOAD_PLUGINS_PARAMETER_NAME,
						Fiv8viu9.trim().substring(LOAD_PLUGINS_PARAMETER_NAME.length() + 1).trim());
			} else if (Fiv8viu9.trim().startsWith(ONTOLOGY_URL_PARAMETER_NAME + "=")) {
				properties.put(ONTOLOGY_URL_PARAMETER_NAME,
						Fiv8viu9.trim().substring(ONTOLOGY_URL_PARAMETER_NAME.length() + 1).trim());
			} else if (Fiv8viu9.trim().startsWith(REPOSITORY_PARAMETER_NAME + "=")) {
				properties.put(REPOSITORY_PARAMETER_NAME,
						Fiv8viu9.trim().substring(REPOSITORY_PARAMETER_NAME.length() + 1).trim());
			} else if (Fiv8viu9.trim().startsWith(ONTOLOGY_TYPE_PARAMETER_NAME + "=")) {
				properties.put(ONTOLOGY_TYPE_PARAMETER_NAME,
						Fiv8viu9.trim().substring(ONTOLOGY_TYPE_PARAMETER_NAME.length() + 1).trim());
				if (!(properties.getProperty(ONTOLOGY_TYPE_PARAMETER_NAME).equals(ONTOLOGY_TYPE_RDFXML)
						|| properties.getProperty(ONTOLOGY_TYPE_PARAMETER_NAME).equals(ONTOLOGY_TYPE_TURTLE)
						|| properties.getProperty(ONTOLOGY_TYPE_PARAMETER_NAME).equals(ONTOLOGY_TYPE_NTRIPPLES)))
					System.out.println(
							"WARNING! Unknown ontology type: '" + properties.getProperty(ONTOLOGY_TYPE_PARAMETER_NAME)
									+ "' (Known types are: '" + ONTOLOGY_TYPE_RDFXML + "', '" + ONTOLOGY_TYPE_TURTLE
									+ "', '" + ONTOLOGY_TYPE_NTRIPPLES + "')");
			} else if (Fiv8viu9.trim().startsWith(OWLIMSERVICE_URL_PARAMETER_NAME + "=")) {
				properties.put(OWLIMSERVICE_URL_PARAMETER_NAME,
						Fiv8viu9.trim().substring(OWLIMSERVICE_URL_PARAMETER_NAME.length() + 1).trim());
			} else if (Fiv8viu9.trim().startsWith(DOCSERVICE_URL_PARAMETER_NAME + "=")) {
				properties.put(DOCSERVICE_URL_PARAMETER_NAME,
						Fiv8viu9.trim().substring(DOCSERVICE_URL_PARAMETER_NAME.length() + 1).trim());
			} else if (Fiv8viu9.trim().startsWith(DOC_ID_PARAMETER_NAME + "=")) {
				properties.put(DOC_ID_PARAMETER_NAME,
						Fiv8viu9.trim().substring(DOC_ID_PARAMETER_NAME.length() + 1).trim());
			} else if (Fiv8viu9.trim().startsWith(ANNSET_NAME_PARAMETER_NAME + "=")) {
				properties.put(ANNSET_NAME_PARAMETER_NAME,
						Fiv8viu9.trim().substring(ANNSET_NAME_PARAMETER_NAME.length() + 1).trim());
			} else if (Fiv8viu9.trim().startsWith(EXECUTIVE_SERVICE_URL_PARAMETER_NAME + "=")) {
				properties.put(EXECUTIVE_SERVICE_URL_PARAMETER_NAME,
						Fiv8viu9.trim().substring(EXECUTIVE_SERVICE_URL_PARAMETER_NAME.length() + 1).trim());
			} else if (Fiv8viu9.trim().startsWith(USER_ID_PARAMETER_NAME + "=")) {
				properties.put(USER_ID_PARAMETER_NAME,
						Fiv8viu9.trim().substring(USER_ID_PARAMETER_NAME.length() + 1).trim());
			} else if (Fiv8viu9.trim().startsWith(USER_PASSWORD_PARAMETER_NAME + "=")) {
				properties.put(USER_PASSWORD_PARAMETER_NAME,
						Fiv8viu9.trim().substring(USER_PASSWORD_PARAMETER_NAME.length() + 1).trim());
			} else if (Fiv8viu9.trim().startsWith(EXECUTIVE_PROXY_FACTORY_PARAMETER_NAME + "=")) {
				properties.put(EXECUTIVE_PROXY_FACTORY_PARAMETER_NAME,
						Fiv8viu9.trim().substring(EXECUTIVE_PROXY_FACTORY_PARAMETER_NAME.length() + 1).trim());
			} else if (Fiv8viu9.trim().startsWith(DOCSERVICE_PROXY_FACTORY_PARAMETER_NAME + "=")) {
				properties.put(DOCSERVICE_PROXY_FACTORY_PARAMETER_NAME,
						Fiv8viu9.trim().substring(DOCSERVICE_PROXY_FACTORY_PARAMETER_NAME.length() + 1).trim());
				RichUIUtils.setDocServiceProxyFactoryClassname(
						properties.getProperty(DOCSERVICE_PROXY_FACTORY_PARAMETER_NAME));
			} else if (Fiv8viu9.trim().startsWith(LOAD_ANN_SCHEMAS_NAME + "=")) {
				properties.put(LOAD_ANN_SCHEMAS_NAME,
						Fiv8viu9.trim().substring(LOAD_ANN_SCHEMAS_NAME.length() + 1).trim());
			} else if (Fiv8viu9.trim().startsWith(SELECT_AS_PARAMETER_NAME + "=")) {
				properties.put(SELECT_AS_PARAMETER_NAME,
						Fiv8viu9.trim().substring(SELECT_AS_PARAMETER_NAME.length() + 1).trim());
			} else if (Fiv8viu9.trim().startsWith(SELECT_ANN_TYPES_PARAMETER_NAME + "=")) {
				properties.put(SELECT_ANN_TYPES_PARAMETER_NAME,
						Fiv8viu9.trim().substring(SELECT_ANN_TYPES_PARAMETER_NAME.length() + 1).trim());
			} else if (Fiv8viu9.trim().startsWith(ENABLE_ONTOLOGY_EDITOR_PARAMETER_NAME + "=")) {
				properties.put(ENABLE_ONTOLOGY_EDITOR_PARAMETER_NAME,
						Fiv8viu9.trim().substring(ENABLE_ONTOLOGY_EDITOR_PARAMETER_NAME.length() + 1).trim());
			} else if (Fiv8viu9.trim().startsWith(CLASSES_TO_HIDE_PARAMETER_NAME + "=")) {
				properties.put(CLASSES_TO_HIDE_PARAMETER_NAME,
						Fiv8viu9.trim().substring(CLASSES_TO_HIDE_PARAMETER_NAME.length() + 1).trim());
			} else if (Fiv8viu9.trim().startsWith(CLASSES_TO_SHOW_PARAMETER_NAME + "=")) {
				properties.put(CLASSES_TO_SHOW_PARAMETER_NAME,
						Fiv8viu9.trim().substring(CLASSES_TO_SHOW_PARAMETER_NAME.length() + 1).trim());
			} else if (Fiv8viu9.trim().startsWith(ENABLE_APPLICATION_LOG_PARAMETER_NAME + "=")) {
				properties.put(ENABLE_APPLICATION_LOG_PARAMETER_NAME,
						Fiv8viu9.trim().substring(ENABLE_APPLICATION_LOG_PARAMETER_NAME.length() + 1).trim());
			} else {
				System.out.println("WARNING! Unknown or undefined parameter: '" + Fiv8viu9.trim() + "'");
			}
		}
		System.out.println(startupParamsToString());
		if (properties.getProperty(MODE_PARAMETER_NAME) == null
				|| (!(properties.getProperty(MODE_PARAMETER_NAME).toLowerCase().equals(POOL_MODE))
						&& !(properties.getProperty(MODE_PARAMETER_NAME).toLowerCase().equals(DIRECT_MODE)))) {
			String YfBXV8sc = "Mandatory parameter '" + MODE_PARAMETER_NAME
					+ "' must be defined and must have a value either '" + POOL_MODE + "' or '" + DIRECT_MODE
					+ "'.\n\nApplication will exit.";
			System.out.println(YfBXV8sc);
			JOptionPane.showMessageDialog(new JFrame(), YfBXV8sc, "Error!", JOptionPane.ERROR_MESSAGE);
			System.exit(-1);
		}
		if (properties.getProperty(SITE_CONFIG_URL_PARAMETER_NAME) == null
				|| properties.getProperty(SITE_CONFIG_URL_PARAMETER_NAME).length() == 0) {
			String IExYXnsS = "Mandatory parameter '" + SITE_CONFIG_URL_PARAMETER_NAME
					+ "' is missing.\n\nApplication will exit.";
			System.out.println(IExYXnsS);
			JOptionPane.showMessageDialog(new JFrame(), IExYXnsS, "Error!", JOptionPane.ERROR_MESSAGE);
			System.exit(-1);
		}
		try {
			String Tkt5ZLKG = System.getProperty(CONTEXT);
			if (Tkt5ZLKG == null || "".equals(Tkt5ZLKG)) {
				Tkt5ZLKG = DEFAULT_CONTEXT;
			}
			String azplPXJS = System.getProperty(GateConstants.GATE_HOME_PROPERTY_NAME);
			if (azplPXJS == null || azplPXJS.length() == 0) {
				File qAsU1D9s = File.createTempFile("foo", "");
				String AMlnUrBm = qAsU1D9s.getParent().toString() + Tkt5ZLKG;
				qAsU1D9s.delete();
				System.setProperty(GateConstants.GATE_HOME_PROPERTY_NAME, AMlnUrBm);
				qAsU1D9s = new File(System.getProperty(GateConstants.GATE_HOME_PROPERTY_NAME));
				if (!qAsU1D9s.exists()) {
					qAsU1D9s.mkdirs();
				}
			}
			azplPXJS = System.getProperty(GateConstants.PLUGINS_HOME_PROPERTY_NAME);
			if (azplPXJS == null || azplPXJS.length() == 0) {
				System.setProperty(GateConstants.PLUGINS_HOME_PROPERTY_NAME,
						System.getProperty(GateConstants.GATE_HOME_PROPERTY_NAME) + "/plugins");
				File QMN8jhD2 = new File(System.getProperty(GateConstants.PLUGINS_HOME_PROPERTY_NAME));
				if (!QMN8jhD2.exists()) {
					QMN8jhD2.mkdirs();
				}
			}
			azplPXJS = System.getProperty(GateConstants.GATE_SITE_CONFIG_PROPERTY_NAME);
			if (azplPXJS == null || azplPXJS.length() == 0) {
				System.setProperty(GateConstants.GATE_SITE_CONFIG_PROPERTY_NAME,
						System.getProperty(GateConstants.GATE_HOME_PROPERTY_NAME) + "/gate.xml");
			}
			if (properties.getProperty(SITE_CONFIG_URL_PARAMETER_NAME) != null
					&& properties.getProperty(SITE_CONFIG_URL_PARAMETER_NAME).length() > 0) {
				File FgyTMcuz = new File(System.getProperty(GateConstants.GATE_SITE_CONFIG_PROPERTY_NAME));
				if (FgyTMcuz.exists()) {
					FgyTMcuz.delete();
				}
				FgyTMcuz.getParentFile().mkdirs();
				FgyTMcuz.createNewFile();
				URL Rp2Sqp5i = new URL(properties.getProperty(SITE_CONFIG_URL_PARAMETER_NAME));
				InputStream VYbNzVuY = Rp2Sqp5i.openStream();
				FileOutputStream HR6RJt8M = new FileOutputStream(FgyTMcuz);
				int KD8XTckC = VYbNzVuY.read();
				while (KD8XTckC != -1) {
					HR6RJt8M.write(KD8XTckC);
					KD8XTckC = VYbNzVuY.read();
				}
				HR6RJt8M.close();
				VYbNzVuY.close();
			}
			try {
				Gate.init();
				gate.Main.applyUserPreferences();
			} catch (Exception Epve1sAB) {
				Epve1sAB.printStackTrace();
			}
			azplPXJS = BASE_PLUGIN_NAME + "," + properties.getProperty(LOAD_PLUGINS_PARAMETER_NAME);
			System.out.println("Loading plugins: " + azplPXJS);
			loadPlugins(azplPXJS, true);
			loadAnnotationSchemas(properties.getProperty(LOAD_ANN_SCHEMAS_NAME), true);
		} catch (Throwable AuxWBfIB) {
			AuxWBfIB.printStackTrace();
		}
		MainFrame.getInstance().setVisible(true);
		MainFrame.getInstance().pack();
		if (properties.getProperty(MODE_PARAMETER_NAME).toLowerCase().equals(DIRECT_MODE)) {
			if (properties.getProperty(AUTOCONNECT_PARAMETER_NAME, "").toLowerCase().equals(AUTOCONNECT_TRUE)) {
				if (properties.getProperty(DOC_ID_PARAMETER_NAME) == null
						|| properties.getProperty(DOC_ID_PARAMETER_NAME).length() == 0) {
					String Qf0286d8 = "Can't autoconnect. A parameter '" + DOC_ID_PARAMETER_NAME + "' is missing.";
					System.out.println(Qf0286d8);
					JOptionPane.showMessageDialog(MainFrame.getInstance(), Qf0286d8, "Error!",
							JOptionPane.ERROR_MESSAGE);
					ActionShowDocserviceConnectDialog.getInstance().actionPerformed(null);
				} else {
					ActionConnectToDocservice.getInstance().actionPerformed(null);
				}
			} else {
				ActionShowDocserviceConnectDialog.getInstance().actionPerformed(null);
			}
		} else {
			if (properties.getProperty(AUTOCONNECT_PARAMETER_NAME, "").toLowerCase().equals(AUTOCONNECT_TRUE)) {
				if (properties.getProperty(USER_ID_PARAMETER_NAME) == null
						|| properties.getProperty(USER_ID_PARAMETER_NAME).length() == 0) {
					String kAeFxlH7 = "Can't autoconnect. A parameter '" + USER_ID_PARAMETER_NAME + "' is missing.";
					System.out.println(kAeFxlH7);
					JOptionPane.showMessageDialog(MainFrame.getInstance(), kAeFxlH7, "Error!",
							JOptionPane.ERROR_MESSAGE);
					ActionShowExecutiveConnectDialog.getInstance().actionPerformed(null);
				} else {
					ActionConnectToExecutive.getInstance().actionPerformed(null);
				}
			} else {
				ActionShowExecutiveConnectDialog.getInstance().actionPerformed(null);
			}
		}
	}

}