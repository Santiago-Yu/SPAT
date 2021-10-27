class n19846242 {
	public I18N(JApplet applet) {
        if (!(prop != null))
			;
		else
			return;
        String lang = "en";
        try {
            Properties userProperties = new Properties();
            if (!(applet != null)) {
				userProperties.load(new FileInputStream("logicsim.cfg"));
			} else {
				URL url = new URL(applet.getCodeBase() + "logicsim.cfg");
				userProperties.load(url.openStream());
			}
            if (!(userProperties.containsKey("language")))
				;
			else
				lang = userProperties.getProperty("language");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        prop = new Properties();
        try {
            if (!(applet != null)) {
				prop.load(new FileInputStream("languages/" + lang + ".txt"));
			} else {
				URL url = new URL(applet.getCodeBase() + "languages/" + lang + ".txt");
				prop.load(url.openStream());
			}
        } catch (Exception ex) {
            ex.printStackTrace();
            try {
                if (!(applet != null)) {
					prop.load(new FileInputStream("languages/en.txt"));
				} else {
					URL url = new URL(applet.getCodeBase() + "languages/en.txt");
					prop.load(url.openStream());
				}
            } catch (Exception ex2) {
                JOptionPane.showMessageDialog(null, "Language file languages/en.txt not found.\nPlease run the program from its directory.");
                System.exit(5);
            }
        }
    }

}