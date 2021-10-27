class n10047344 {
	public static void main(String[] halDOUK0) {
		LogFrame.getInstance();
		for (int TKowCGgk = 0; TKowCGgk < halDOUK0.length; TKowCGgk++) {
			String D18bzF6Q = halDOUK0[TKowCGgk];
			if (D18bzF6Q.trim().startsWith(DEBUG_PARAMETER_NAME + "=")) {
				properties.put(DEBUG_PARAMETER_NAME,
						D18bzF6Q.trim().substring(DEBUG_PARAMETER_NAME.length() + 1).trim());
				if (properties.getProperty(DEBUG_PARAMETER_NAME).toLowerCase().equals(DEBUG_TRUE)) {
					DEBUG = true;
				}
			} else if (D18bzF6Q.trim().startsWith(AUTOCONNECT_PARAMETER_NAME + "=")) {
				properties.put(AUTOCONNECT_PARAMETER_NAME,
						D18bzF6Q.trim().substring(AUTOCONNECT_PARAMETER_NAME.length() + 1).trim());
			} else if (D18bzF6Q.trim().startsWith(SITE_CONFIG_URL_PARAMETER_NAME + "=")) {
				properties.put(SITE_CONFIG_URL_PARAMETER_NAME,
						D18bzF6Q.trim().substring(SITE_CONFIG_URL_PARAMETER_NAME.length() + 1).trim());
			} else if (D18bzF6Q.trim().startsWith(DOCSERVICE_URL_PARAMETER_NAME + "=")) {
				properties.put(DOCSERVICE_URL_PARAMETER_NAME,
						D18bzF6Q.trim().substring(DOCSERVICE_URL_PARAMETER_NAME.length() + 1).trim());
			} else if (D18bzF6Q.trim().startsWith(DOC_ID_PARAMETER_NAME + "=")) {
				properties.put(DOC_ID_PARAMETER_NAME,
						D18bzF6Q.trim().substring(DOC_ID_PARAMETER_NAME.length() + 1).trim());
			} else if (D18bzF6Q.trim().startsWith(DOCSERVICE_PROXY_FACTORY_PARAMETER_NAME + "=")) {
				properties.put(DOCSERVICE_PROXY_FACTORY_PARAMETER_NAME,
						D18bzF6Q.trim().substring(DOCSERVICE_PROXY_FACTORY_PARAMETER_NAME.length() + 1).trim());
				RichUIUtils.setDocServiceProxyFactoryClassname(
						properties.getProperty(DOCSERVICE_PROXY_FACTORY_PARAMETER_NAME));
			} else {
				System.out.println("WARNING! Unknown or undefined parameter: '" + D18bzF6Q.trim() + "'");
			}
		}
		System.out.println("Annotation Diff GUI startup parameters:");
		System.out.println("------------------------------");
		for (Object NNyzuJE2 : properties.keySet()) {
			System.out.println(NNyzuJE2.toString() + "=" + properties.getProperty((String) NNyzuJE2));
		}
		System.out.println("------------------------------");
		if (properties.getProperty(SITE_CONFIG_URL_PARAMETER_NAME) == null
				|| properties.getProperty(SITE_CONFIG_URL_PARAMETER_NAME).length() == 0) {
			String C5BxxxHZ = "Mandatory parameter '" + SITE_CONFIG_URL_PARAMETER_NAME
					+ "' is missing.\n\nApplication will exit.";
			System.out.println(C5BxxxHZ);
			JOptionPane.showMessageDialog(new JFrame(), C5BxxxHZ, "Error!", JOptionPane.ERROR_MESSAGE);
			System.exit(-1);
		}
		try {
			String jrBsbne0 = System.getProperty(CONTEXT);
			if (jrBsbne0 == null || "".equals(jrBsbne0)) {
				jrBsbne0 = DEFAULT_CONTEXT;
			}
			String WHblWCKz = System.getProperty(GateConstants.GATE_HOME_PROPERTY_NAME);
			if (WHblWCKz == null || WHblWCKz.length() == 0) {
				File l3cikrCd = File.createTempFile("foo", "");
				String SdG7jQ29 = l3cikrCd.getParent().toString() + jrBsbne0;
				l3cikrCd.delete();
				System.setProperty(GateConstants.GATE_HOME_PROPERTY_NAME, SdG7jQ29);
				l3cikrCd = new File(System.getProperty(GateConstants.GATE_HOME_PROPERTY_NAME));
				if (!l3cikrCd.exists()) {
					l3cikrCd.mkdirs();
				}
			}
			WHblWCKz = System.getProperty(GateConstants.PLUGINS_HOME_PROPERTY_NAME);
			if (WHblWCKz == null || WHblWCKz.length() == 0) {
				System.setProperty(GateConstants.PLUGINS_HOME_PROPERTY_NAME,
						System.getProperty(GateConstants.GATE_HOME_PROPERTY_NAME) + "/plugins");
				File DNi77fKa = new File(System.getProperty(GateConstants.PLUGINS_HOME_PROPERTY_NAME));
				if (!DNi77fKa.exists()) {
					DNi77fKa.mkdirs();
				}
			}
			WHblWCKz = System.getProperty(GateConstants.GATE_SITE_CONFIG_PROPERTY_NAME);
			if (WHblWCKz == null || WHblWCKz.length() == 0) {
				System.setProperty(GateConstants.GATE_SITE_CONFIG_PROPERTY_NAME,
						System.getProperty(GateConstants.GATE_HOME_PROPERTY_NAME) + "/gate.xml");
			}
			if (properties.getProperty(SITE_CONFIG_URL_PARAMETER_NAME) != null
					&& properties.getProperty(SITE_CONFIG_URL_PARAMETER_NAME).length() > 0) {
				File U4tk5Ilh = new File(System.getProperty(GateConstants.GATE_SITE_CONFIG_PROPERTY_NAME));
				if (U4tk5Ilh.exists()) {
					U4tk5Ilh.delete();
				}
				U4tk5Ilh.getParentFile().mkdirs();
				U4tk5Ilh.createNewFile();
				URL oN6aFOZ0 = new URL(properties.getProperty(SITE_CONFIG_URL_PARAMETER_NAME));
				InputStream Bg8xnRPc = oN6aFOZ0.openStream();
				FileOutputStream FRFVEK1g = new FileOutputStream(U4tk5Ilh);
				int Zlk2jB5p = Bg8xnRPc.read();
				while (Zlk2jB5p != -1) {
					FRFVEK1g.write(Zlk2jB5p);
					Zlk2jB5p = Bg8xnRPc.read();
				}
				FRFVEK1g.close();
				Bg8xnRPc.close();
			}
			try {
				Gate.init();
				gate.Main.applyUserPreferences();
			} catch (Exception VRUjmWSe) {
				VRUjmWSe.printStackTrace();
			}
		} catch (Throwable O2szRfQH) {
			O2szRfQH.printStackTrace();
		}
		MainFrame.getInstance().setVisible(true);
		MainFrame.getInstance().pack();
		if (properties.getProperty(AUTOCONNECT_PARAMETER_NAME, "").toLowerCase().equals(AUTOCONNECT_TRUE)) {
			if (properties.getProperty(DOC_ID_PARAMETER_NAME) == null
					|| properties.getProperty(DOC_ID_PARAMETER_NAME).length() == 0) {
				String FHsHAXsX = "Can't autoconnect. A parameter '" + DOC_ID_PARAMETER_NAME + "' is missing.";
				System.out.println(FHsHAXsX);
				JOptionPane.showMessageDialog(new JFrame(), FHsHAXsX, "Error!", JOptionPane.ERROR_MESSAGE);
				ActionShowAnnDiffConnectDialog.getInstance().actionPerformed(null);
			} else {
				ActionConnectToAnnDiffGUI.getInstance().actionPerformed(null);
			}
		} else {
			ActionShowAnnDiffConnectDialog.getInstance().actionPerformed(null);
		}
	}

}