class n10047344{
    public static void main(String[] args) {
        LogFrame.getInstance();
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            if (arg.trim().startsWith(DEBUG_PARAMETER_NAME + "=")) {
                properties.put(DEBUG_PARAMETER_NAME, arg.trim().substring(DEBUG_PARAMETER_NAME.length() + 1).trim());
                if (properties.getProperty(DEBUG_PARAMETER_NAME).toLowerCase().equals(DEBUG_TRUE)) {
                    DEBUG = true;
                }
            } else if (arg.trim().startsWith(AUTOCONNECT_PARAMETER_NAME + "=")) {
                properties.put(AUTOCONNECT_PARAMETER_NAME, arg.trim().substring(AUTOCONNECT_PARAMETER_NAME.length() + 1).trim());
            } else if (arg.trim().startsWith(SITE_CONFIG_URL_PARAMETER_NAME + "=")) {
                properties.put(SITE_CONFIG_URL_PARAMETER_NAME, arg.trim().substring(SITE_CONFIG_URL_PARAMETER_NAME.length() + 1).trim());
            } else if (arg.trim().startsWith(DOCSERVICE_URL_PARAMETER_NAME + "=")) {
                properties.put(DOCSERVICE_URL_PARAMETER_NAME, arg.trim().substring(DOCSERVICE_URL_PARAMETER_NAME.length() + 1).trim());
            } else if (arg.trim().startsWith(DOC_ID_PARAMETER_NAME + "=")) {
                properties.put(DOC_ID_PARAMETER_NAME, arg.trim().substring(DOC_ID_PARAMETER_NAME.length() + 1).trim());
            } else if (arg.trim().startsWith(DOCSERVICE_PROXY_FACTORY_PARAMETER_NAME + "=")) {
                properties.put(DOCSERVICE_PROXY_FACTORY_PARAMETER_NAME, arg.trim().substring(DOCSERVICE_PROXY_FACTORY_PARAMETER_NAME.length() + 1).trim());
                RichUIUtils.setDocServiceProxyFactoryClassname(properties.getProperty(DOCSERVICE_PROXY_FACTORY_PARAMETER_NAME));
            } else {
                System.out.println("WARNING! Unknown or undefined parameter: '" + arg.trim() + "'");
            }
        }
        System.out.println("Annotation Diff GUI startup parameters:");
        System.out.println("------------------------------");
        for (Object propName : properties.keySet()) {
            System.out.println(propName.toString() + "=" + properties.getProperty((String) propName));
        }
        System.out.println("------------------------------");
        if (properties.getProperty(SITE_CONFIG_URL_PARAMETER_NAME) == null || properties.getProperty(SITE_CONFIG_URL_PARAMETER_NAME).length() == 0) {
            String err = "Mandatory parameter '" + SITE_CONFIG_URL_PARAMETER_NAME + "' is missing.\n\nApplication will exit.";
            System.out.println(err);
            JOptionPane.showMessageDialog(new JFrame(), err, "Error!", JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        }
        try {
            String context = System.getProperty(CONTEXT);
            if (context == null || "".equals(context)) {
                context = DEFAULT_CONTEXT;
            }
            String s = System.getProperty(GateConstants.GATE_HOME_PROPERTY_NAME);
            if (s == null || s.length() == 0) {
                File f = File.createTempFile("foo", "");
                String gateHome = f.getParent().toString() + context;
                f.delete();
                System.setProperty(GateConstants.GATE_HOME_PROPERTY_NAME, gateHome);
                f = new File(System.getProperty(GateConstants.GATE_HOME_PROPERTY_NAME));
                if (!f.exists()) {
                    f.mkdirs();
                }
            }
            s = System.getProperty(GateConstants.PLUGINS_HOME_PROPERTY_NAME);
            if (s == null || s.length() == 0) {
                System.setProperty(GateConstants.PLUGINS_HOME_PROPERTY_NAME, System.getProperty(GateConstants.GATE_HOME_PROPERTY_NAME) + "/plugins");
                File f = new File(System.getProperty(GateConstants.PLUGINS_HOME_PROPERTY_NAME));
                if (!f.exists()) {
                    f.mkdirs();
                }
            }
            s = System.getProperty(GateConstants.GATE_SITE_CONFIG_PROPERTY_NAME);
            if (s == null || s.length() == 0) {
                System.setProperty(GateConstants.GATE_SITE_CONFIG_PROPERTY_NAME, System.getProperty(GateConstants.GATE_HOME_PROPERTY_NAME) + "/gate.xml");
            }
            if (properties.getProperty(SITE_CONFIG_URL_PARAMETER_NAME) != null && properties.getProperty(SITE_CONFIG_URL_PARAMETER_NAME).length() > 0) {
                File f = new File(System.getProperty(GateConstants.GATE_SITE_CONFIG_PROPERTY_NAME));
                if (f.exists()) {
                    f.delete();
                }
                f.getParentFile().mkdirs();
                f.createNewFile();
                URL url = new URL(properties.getProperty(SITE_CONFIG_URL_PARAMETER_NAME));
                InputStream is = url.openStream();
                FileOutputStream fos = new FileOutputStream(f);
                int i = is.read();
                while (i != -1) {
                    fos.write(i);
                    i = is.read();
                }
                fos.close();
                is.close();
            }
            try {
                Gate.init();
                gate.Main.applyUserPreferences();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        MainFrame.getInstance().setVisible(true);
        MainFrame.getInstance().pack();
        if (properties.getProperty(AUTOCONNECT_PARAMETER_NAME, "").toLowerCase().equals(AUTOCONNECT_TRUE)) {
            if (properties.getProperty(DOC_ID_PARAMETER_NAME) == null || properties.getProperty(DOC_ID_PARAMETER_NAME).length() == 0) {
                String err = "Can't autoconnect. A parameter '" + DOC_ID_PARAMETER_NAME + "' is missing.";
                System.out.println(err);
                JOptionPane.showMessageDialog(new JFrame(), err, "Error!", JOptionPane.ERROR_MESSAGE);
                ActionShowAnnDiffConnectDialog.getInstance().actionPerformed(null);
            } else {
                ActionConnectToAnnDiffGUI.getInstance().actionPerformed(null);
            }
        } else {
            ActionShowAnnDiffConnectDialog.getInstance().actionPerformed(null);
        }
    }

}