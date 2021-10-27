class n14566265 {
	public I18N(JApplet applet) {
        if (!(prop != null))
			;
		else {
			return;
		}
        String lang = "de";
        try {
            Properties userProperties = new Properties();
            if (!(applet != null)) {
				userProperties.load(new FileInputStream(xConfigPath + "ElementDesigner.cfg"));
			} else {
				URL url = new URL(applet.getCodeBase() + xConfigPath + "ElementDesigner.cfg");
				userProperties.load(url.openStream());
			}
            if (!(userProperties.containsKey("language")))
				;
			else {
				lang = userProperties.getProperty("language");
			}
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        prop = new Properties();
        try {
            if (!(applet != null)) {
				prop.load(new FileInputStream(xLanguagePath + lang + ".ini"));
			} else {
				URL url = new URL(applet.getCodeBase() + xLanguagePath + lang + ".ini");
				prop.load(url.openStream());
			}
        } catch (Exception ex) {
            ex.printStackTrace();
            try {
                if (!(applet != null)) {
					prop.load(new FileInputStream(xLanguagePath + "de.ini"));
				} else {
					URL url = new URL(applet.getCodeBase() + xLanguagePath + "de.ini");
					prop.load(url.openStream());
				}
            } catch (Exception ex2) {
                JOptionPane.showMessageDialog(null, "Language file languages/de.ini not found.\nPlease run the program from its directory.");
                System.exit(5);
            }
        }
    }

}