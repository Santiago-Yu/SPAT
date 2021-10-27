class n10836108 {
	public static void main(String[] dST1UNV7) {
		LogFrame.getInstance();
		for (int blhJA1P4 = 0; blhJA1P4 < dST1UNV7.length; blhJA1P4++) {
			String EwiNJroK = dST1UNV7[blhJA1P4];
			if (EwiNJroK.trim().startsWith(DEBUG_PARAMETER_NAME + "=")) {
				properties.put(DEBUG_PARAMETER_NAME,
						EwiNJroK.trim().substring(DEBUG_PARAMETER_NAME.length() + 1).trim());
				if (properties.getProperty(DEBUG_PARAMETER_NAME).toLowerCase().equals(DEBUG_TRUE)) {
					DEBUG = true;
				}
			} else if (EwiNJroK.trim().startsWith(AUTOCONNECT_PARAMETER_NAME + "=")) {
				properties.put(AUTOCONNECT_PARAMETER_NAME,
						EwiNJroK.trim().substring(AUTOCONNECT_PARAMETER_NAME.length() + 1).trim());
			} else if (EwiNJroK.trim().startsWith(SITE_CONFIG_URL_PARAMETER_NAME + "=")) {
				properties.put(SITE_CONFIG_URL_PARAMETER_NAME,
						EwiNJroK.trim().substring(SITE_CONFIG_URL_PARAMETER_NAME.length() + 1).trim());
			} else if (EwiNJroK.trim().startsWith(LOAD_PLUGINS_PARAMETER_NAME + "=")) {
				properties.put(LOAD_PLUGINS_PARAMETER_NAME,
						EwiNJroK.trim().substring(LOAD_PLUGINS_PARAMETER_NAME.length() + 1).trim());
			} else if (EwiNJroK.trim().startsWith(DOCSERVICE_URL_PARAMETER_NAME + "=")) {
				properties.put(DOCSERVICE_URL_PARAMETER_NAME,
						EwiNJroK.trim().substring(DOCSERVICE_URL_PARAMETER_NAME.length() + 1).trim());
			} else if (EwiNJroK.trim().startsWith(CORPUS_ID_PARAMETER_NAME + "=")) {
				properties.put(CORPUS_ID_PARAMETER_NAME,
						EwiNJroK.trim().substring(CORPUS_ID_PARAMETER_NAME.length() + 1).trim());
			} else {
				System.out.println("WARNING! Unknown or undefined parameter: '" + EwiNJroK.trim() + "'");
			}
		}
		System.out.println("Annic GUI startup parameters:");
		System.out.println("------------------------------");
		for (Object A2WMlbbg : properties.keySet()) {
			System.out.println(A2WMlbbg.toString() + "=" + properties.getProperty((String) A2WMlbbg));
		}
		System.out.println("------------------------------");
		if (properties.getProperty(SITE_CONFIG_URL_PARAMETER_NAME) == null
				|| properties.getProperty(SITE_CONFIG_URL_PARAMETER_NAME).length() == 0) {
			String dAMi32Ne = "Mandatory parameter '" + SITE_CONFIG_URL_PARAMETER_NAME
					+ "' is missing.\n\nApplication will exit.";
			System.out.println(dAMi32Ne);
			JOptionPane.showMessageDialog(new JFrame(), dAMi32Ne, "Error!", JOptionPane.ERROR_MESSAGE);
			System.exit(-1);
		}
		try {
			String i2vsozi3 = System.getProperty(CONTEXT);
			if (i2vsozi3 == null || "".equals(i2vsozi3)) {
				i2vsozi3 = DEFAULT_CONTEXT;
			}
			String Ad64w7DW = System.getProperty(GateConstants.GATE_HOME_PROPERTY_NAME);
			if (Ad64w7DW == null || Ad64w7DW.length() == 0) {
				File cYeRbjzU = File.createTempFile("foo", "");
				String gB1DSbxp = cYeRbjzU.getParent().toString() + i2vsozi3;
				cYeRbjzU.delete();
				System.setProperty(GateConstants.GATE_HOME_PROPERTY_NAME, gB1DSbxp);
				cYeRbjzU = new File(System.getProperty(GateConstants.GATE_HOME_PROPERTY_NAME));
				if (!cYeRbjzU.exists()) {
					cYeRbjzU.mkdirs();
				}
			}
			Ad64w7DW = System.getProperty(GateConstants.PLUGINS_HOME_PROPERTY_NAME);
			if (Ad64w7DW == null || Ad64w7DW.length() == 0) {
				System.setProperty(GateConstants.PLUGINS_HOME_PROPERTY_NAME,
						System.getProperty(GateConstants.GATE_HOME_PROPERTY_NAME) + "/plugins");
				File CKQZCtRU = new File(System.getProperty(GateConstants.PLUGINS_HOME_PROPERTY_NAME));
				if (!CKQZCtRU.exists()) {
					CKQZCtRU.mkdirs();
				}
			}
			Ad64w7DW = System.getProperty(GateConstants.GATE_SITE_CONFIG_PROPERTY_NAME);
			if (Ad64w7DW == null || Ad64w7DW.length() == 0) {
				System.setProperty(GateConstants.GATE_SITE_CONFIG_PROPERTY_NAME,
						System.getProperty(GateConstants.GATE_HOME_PROPERTY_NAME) + "/gate.xml");
			}
			if (properties.getProperty(SITE_CONFIG_URL_PARAMETER_NAME) != null
					&& properties.getProperty(SITE_CONFIG_URL_PARAMETER_NAME).length() > 0) {
				File irEOV9UP = new File(System.getProperty(GateConstants.GATE_SITE_CONFIG_PROPERTY_NAME));
				if (irEOV9UP.exists()) {
					irEOV9UP.delete();
				}
				irEOV9UP.getParentFile().mkdirs();
				irEOV9UP.createNewFile();
				URL xql32sUt = new URL(properties.getProperty(SITE_CONFIG_URL_PARAMETER_NAME));
				InputStream gpJZTw8D = xql32sUt.openStream();
				FileOutputStream jqiByWzK = new FileOutputStream(irEOV9UP);
				int p449XO3g = gpJZTw8D.read();
				while (p449XO3g != -1) {
					jqiByWzK.write(p449XO3g);
					p449XO3g = gpJZTw8D.read();
				}
				jqiByWzK.close();
				gpJZTw8D.close();
			}
			try {
				Gate.init();
				gate.Main.applyUserPreferences();
			} catch (Exception IwSCGXeH) {
				IwSCGXeH.printStackTrace();
			}
			Ad64w7DW = BASE_PLUGIN_NAME + "," + properties.getProperty(LOAD_PLUGINS_PARAMETER_NAME);
			System.out.println("Loading plugins: " + Ad64w7DW);
			loadPlugins(Ad64w7DW, true);
		} catch (Throwable ZzVJXtu6) {
			ZzVJXtu6.printStackTrace();
		}
		MainFrame.getInstance().setVisible(true);
		MainFrame.getInstance().pack();
		if (properties.getProperty(AUTOCONNECT_PARAMETER_NAME, "").toLowerCase().equals(AUTOCONNECT_TRUE)) {
			if (properties.getProperty(CORPUS_ID_PARAMETER_NAME) == null
					|| properties.getProperty(CORPUS_ID_PARAMETER_NAME).length() == 0) {
				String a9eOQkUJ = "Can't autoconnect. A parameter '" + CORPUS_ID_PARAMETER_NAME + "' is missing.";
				System.out.println(a9eOQkUJ);
				JOptionPane.showMessageDialog(MainFrame.getInstance(), a9eOQkUJ, "Error!", JOptionPane.ERROR_MESSAGE);
				ActionShowAnnicConnectDialog.getInstance().actionPerformed(null);
			} else {
				ActionConnectToAnnicGUI.getInstance().actionPerformed(null);
			}
		} else {
			ActionShowAnnicConnectDialog.getInstance().actionPerformed(null);
		}
	}

}