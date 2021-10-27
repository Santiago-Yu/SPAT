class n10000832{
    public static void main(String[] args) {
        LogFrame.getInstance();
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            if (arg.trim().startsWith(DEBUG_PARAMETER_NAME + "=")) {
                properties.put(DEBUG_PARAMETER_NAME, arg.trim().substring(DEBUG_PARAMETER_NAME.length() + 1).trim());
                if (properties.getProperty(DEBUG_PARAMETER_NAME).toLowerCase().equals(DEBUG_TRUE)) {
                    DEBUG = true;
                }
            } else if (arg.trim().startsWith(MODE_PARAMETER_NAME + "=")) {
                properties.put(MODE_PARAMETER_NAME, arg.trim().substring(MODE_PARAMETER_NAME.length() + 1).trim());
            } else if (arg.trim().startsWith(AUTOCONNECT_PARAMETER_NAME + "=")) {
                properties.put(AUTOCONNECT_PARAMETER_NAME, arg.trim().substring(AUTOCONNECT_PARAMETER_NAME.length() + 1).trim());
            } else if (arg.trim().startsWith(SITE_CONFIG_URL_PARAMETER_NAME + "=")) {
                properties.put(SITE_CONFIG_URL_PARAMETER_NAME, arg.trim().substring(SITE_CONFIG_URL_PARAMETER_NAME.length() + 1).trim());
            } else if (arg.trim().startsWith(LOAD_PLUGINS_PARAMETER_NAME + "=")) {
                properties.put(LOAD_PLUGINS_PARAMETER_NAME, arg.trim().substring(LOAD_PLUGINS_PARAMETER_NAME.length() + 1).trim());
            } else if (arg.trim().startsWith(ONTOLOGY_URL_PARAMETER_NAME + "=")) {
                properties.put(ONTOLOGY_URL_PARAMETER_NAME, arg.trim().substring(ONTOLOGY_URL_PARAMETER_NAME.length() + 1).trim());
            } else if (arg.trim().startsWith(REPOSITORY_PARAMETER_NAME + "=")) {
                properties.put(REPOSITORY_PARAMETER_NAME, arg.trim().substring(REPOSITORY_PARAMETER_NAME.length() + 1).trim());
            } else if (arg.trim().startsWith(ONTOLOGY_TYPE_PARAMETER_NAME + "=")) {
                properties.put(ONTOLOGY_TYPE_PARAMETER_NAME, arg.trim().substring(ONTOLOGY_TYPE_PARAMETER_NAME.length() + 1).trim());
                if (!(properties.getProperty(ONTOLOGY_TYPE_PARAMETER_NAME).equals(ONTOLOGY_TYPE_RDFXML) || properties.getProperty(ONTOLOGY_TYPE_PARAMETER_NAME).equals(ONTOLOGY_TYPE_TURTLE) || properties.getProperty(ONTOLOGY_TYPE_PARAMETER_NAME).equals(ONTOLOGY_TYPE_NTRIPPLES))) System.out.println("WARNING! Unknown ontology type: '" + properties.getProperty(ONTOLOGY_TYPE_PARAMETER_NAME) + "' (Known types are: '" + ONTOLOGY_TYPE_RDFXML + "', '" + ONTOLOGY_TYPE_TURTLE + "', '" + ONTOLOGY_TYPE_NTRIPPLES + "')");
            } else if (arg.trim().startsWith(OWLIMSERVICE_URL_PARAMETER_NAME + "=")) {
                properties.put(OWLIMSERVICE_URL_PARAMETER_NAME, arg.trim().substring(OWLIMSERVICE_URL_PARAMETER_NAME.length() + 1).trim());
            } else if (arg.trim().startsWith(DOCSERVICE_URL_PARAMETER_NAME + "=")) {
                properties.put(DOCSERVICE_URL_PARAMETER_NAME, arg.trim().substring(DOCSERVICE_URL_PARAMETER_NAME.length() + 1).trim());
            } else if (arg.trim().startsWith(DOC_ID_PARAMETER_NAME + "=")) {
                properties.put(DOC_ID_PARAMETER_NAME, arg.trim().substring(DOC_ID_PARAMETER_NAME.length() + 1).trim());
            } else if (arg.trim().startsWith(ANNSET_NAME_PARAMETER_NAME + "=")) {
                properties.put(ANNSET_NAME_PARAMETER_NAME, arg.trim().substring(ANNSET_NAME_PARAMETER_NAME.length() + 1).trim());
            } else if (arg.trim().startsWith(EXECUTIVE_SERVICE_URL_PARAMETER_NAME + "=")) {
                properties.put(EXECUTIVE_SERVICE_URL_PARAMETER_NAME, arg.trim().substring(EXECUTIVE_SERVICE_URL_PARAMETER_NAME.length() + 1).trim());
            } else if (arg.trim().startsWith(USER_ID_PARAMETER_NAME + "=")) {
                properties.put(USER_ID_PARAMETER_NAME, arg.trim().substring(USER_ID_PARAMETER_NAME.length() + 1).trim());
            } else if (arg.trim().startsWith(USER_PASSWORD_PARAMETER_NAME + "=")) {
                properties.put(USER_PASSWORD_PARAMETER_NAME, arg.trim().substring(USER_PASSWORD_PARAMETER_NAME.length() + 1).trim());
            } else if (arg.trim().startsWith(EXECUTIVE_PROXY_FACTORY_PARAMETER_NAME + "=")) {
                properties.put(EXECUTIVE_PROXY_FACTORY_PARAMETER_NAME, arg.trim().substring(EXECUTIVE_PROXY_FACTORY_PARAMETER_NAME.length() + 1).trim());
            } else if (arg.trim().startsWith(DOCSERVICE_PROXY_FACTORY_PARAMETER_NAME + "=")) {
                properties.put(DOCSERVICE_PROXY_FACTORY_PARAMETER_NAME, arg.trim().substring(DOCSERVICE_PROXY_FACTORY_PARAMETER_NAME.length() + 1).trim());
                RichUIUtils.setDocServiceProxyFactoryClassname(properties.getProperty(DOCSERVICE_PROXY_FACTORY_PARAMETER_NAME));
            } else if (arg.trim().startsWith(LOAD_ANN_SCHEMAS_NAME + "=")) {
                properties.put(LOAD_ANN_SCHEMAS_NAME, arg.trim().substring(LOAD_ANN_SCHEMAS_NAME.length() + 1).trim());
            } else if (arg.trim().startsWith(SELECT_AS_PARAMETER_NAME + "=")) {
                properties.put(SELECT_AS_PARAMETER_NAME, arg.trim().substring(SELECT_AS_PARAMETER_NAME.length() + 1).trim());
            } else if (arg.trim().startsWith(SELECT_ANN_TYPES_PARAMETER_NAME + "=")) {
                properties.put(SELECT_ANN_TYPES_PARAMETER_NAME, arg.trim().substring(SELECT_ANN_TYPES_PARAMETER_NAME.length() + 1).trim());
            } else if (arg.trim().startsWith(ENABLE_ONTOLOGY_EDITOR_PARAMETER_NAME + "=")) {
                properties.put(ENABLE_ONTOLOGY_EDITOR_PARAMETER_NAME, arg.trim().substring(ENABLE_ONTOLOGY_EDITOR_PARAMETER_NAME.length() + 1).trim());
            } else if (arg.trim().startsWith(CLASSES_TO_HIDE_PARAMETER_NAME + "=")) {
                properties.put(CLASSES_TO_HIDE_PARAMETER_NAME, arg.trim().substring(CLASSES_TO_HIDE_PARAMETER_NAME.length() + 1).trim());
            } else if (arg.trim().startsWith(CLASSES_TO_SHOW_PARAMETER_NAME + "=")) {
                properties.put(CLASSES_TO_SHOW_PARAMETER_NAME, arg.trim().substring(CLASSES_TO_SHOW_PARAMETER_NAME.length() + 1).trim());
            } else if (arg.trim().startsWith(ENABLE_APPLICATION_LOG_PARAMETER_NAME + "=")) {
                properties.put(ENABLE_APPLICATION_LOG_PARAMETER_NAME, arg.trim().substring(ENABLE_APPLICATION_LOG_PARAMETER_NAME.length() + 1).trim());
            } else {
                System.out.println("WARNING! Unknown or undefined parameter: '" + arg.trim() + "'");
            }
        }
        System.out.println(startupParamsToString());
        if (properties.getProperty(MODE_PARAMETER_NAME) == null || (!(properties.getProperty(MODE_PARAMETER_NAME).toLowerCase().equals(POOL_MODE)) && !(properties.getProperty(MODE_PARAMETER_NAME).toLowerCase().equals(DIRECT_MODE)))) {
            String err = "Mandatory parameter '" + MODE_PARAMETER_NAME + "' must be defined and must have a value either '" + POOL_MODE + "' or '" + DIRECT_MODE + "'.\n\nApplication will exit.";
            System.out.println(err);
            JOptionPane.showMessageDialog(new JFrame(), err, "Error!", JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        }
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
            s = BASE_PLUGIN_NAME + "," + properties.getProperty(LOAD_PLUGINS_PARAMETER_NAME);
            System.out.println("Loading plugins: " + s);
            loadPlugins(s, true);
            loadAnnotationSchemas(properties.getProperty(LOAD_ANN_SCHEMAS_NAME), true);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        MainFrame.getInstance().setVisible(true);
        MainFrame.getInstance().pack();
        if (properties.getProperty(MODE_PARAMETER_NAME).toLowerCase().equals(DIRECT_MODE)) {
            if (properties.getProperty(AUTOCONNECT_PARAMETER_NAME, "").toLowerCase().equals(AUTOCONNECT_TRUE)) {
                if (properties.getProperty(DOC_ID_PARAMETER_NAME) == null || properties.getProperty(DOC_ID_PARAMETER_NAME).length() == 0) {
                    String err = "Can't autoconnect. A parameter '" + DOC_ID_PARAMETER_NAME + "' is missing.";
                    System.out.println(err);
                    JOptionPane.showMessageDialog(MainFrame.getInstance(), err, "Error!", JOptionPane.ERROR_MESSAGE);
                    ActionShowDocserviceConnectDialog.getInstance().actionPerformed(null);
                } else {
                    ActionConnectToDocservice.getInstance().actionPerformed(null);
                }
            } else {
                ActionShowDocserviceConnectDialog.getInstance().actionPerformed(null);
            }
        } else {
            if (properties.getProperty(AUTOCONNECT_PARAMETER_NAME, "").toLowerCase().equals(AUTOCONNECT_TRUE)) {
                if (properties.getProperty(USER_ID_PARAMETER_NAME) == null || properties.getProperty(USER_ID_PARAMETER_NAME).length() == 0) {
                    String err = "Can't autoconnect. A parameter '" + USER_ID_PARAMETER_NAME + "' is missing.";
                    System.out.println(err);
                    JOptionPane.showMessageDialog(MainFrame.getInstance(), err, "Error!", JOptionPane.ERROR_MESSAGE);
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