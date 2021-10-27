class n19846242 {
	public I18N(JApplet applet) {
        if (prop != null) return;
        String lang = "en";
        try {
            Properties userProperties = new Properties();
            if (applet != null) {
                URL url = new URL(applet.getCodeBase() + "logicsim.cfg");
                userProperties.load(url.openStream());
            } else {
                userProperties.load(new FileInputStream("logicsim.cfg"));
            }
            lang = (userProperties.containsKey("language")) ? userProperties.getProperty("language") : lang;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        prop = new Properties();
        try {
            if (applet != null) {
                URL url = new URL(applet.getCodeBase() + "languages/" + lang + ".txt");
                prop.load(url.openStream());
            } else {
                prop.load(new FileInputStream("languages/" + lang + ".txt"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            try {
                if (applet != null) {
                    URL url = new URL(applet.getCodeBase() + "languages/en.txt");
                    prop.load(url.openStream());
                } else {
                    prop.load(new FileInputStream("languages/en.txt"));
                }
            } catch (Exception ex2) {
                JOptionPane.showMessageDialog(null, "Language file languages/en.txt not found.\nPlease run the program from its directory.");
                System.exit(5);
            }
        }
    }

}