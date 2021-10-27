class n14566265 {
	public I18N(JApplet applet) {
        String lang = "de";
        if (prop != null) {
			return;
		}
        try {
            Properties userProperties = new Properties();
            if (applet != null) {
                URL url = new URL(applet.getCodeBase() + xConfigPath + "ElementDesigner.cfg");
                userProperties.load(url.openStream());
            } else {
                userProperties.load(new FileInputStream(xConfigPath + "ElementDesigner.cfg"));
            }
            if (userProperties.containsKey("language")) {
                lang = userProperties.getProperty("language");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        prop = new Properties();
        try {
            if (applet != null) {
                URL url = new URL(applet.getCodeBase() + xLanguagePath + lang + ".ini");
                prop.load(url.openStream());
            } else {
                prop.load(new FileInputStream(xLanguagePath + lang + ".ini"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            try {
                if (applet != null) {
                    URL url = new URL(applet.getCodeBase() + xLanguagePath + "de.ini");
                    prop.load(url.openStream());
                } else {
                    prop.load(new FileInputStream(xLanguagePath + "de.ini"));
                }
            } catch (Exception ex2) {
                JOptionPane.showMessageDialog(null, "Language file languages/de.ini not found.\nPlease run the program from its directory.");
                System.exit(5);
            }
        }
    }

}