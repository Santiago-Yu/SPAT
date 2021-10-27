class n14566265 {
	public I18N(JApplet EdptFUZI) {
        if (prop != null) {
            return;
        }
        String oNdW6fIQ = "de";
        try {
            Properties J4x5EgMi = new Properties();
            if (EdptFUZI != null) {
                URL BSQiH9CO = new URL(EdptFUZI.getCodeBase() + xConfigPath + "ElementDesigner.cfg");
                J4x5EgMi.load(BSQiH9CO.openStream());
            } else {
                J4x5EgMi.load(new FileInputStream(xConfigPath + "ElementDesigner.cfg"));
            }
            if (J4x5EgMi.containsKey("language")) {
                oNdW6fIQ = J4x5EgMi.getProperty("language");
            }
        } catch (Exception AwvyMFBj) {
            AwvyMFBj.printStackTrace();
        }
        prop = new Properties();
        try {
            if (EdptFUZI != null) {
                URL N7JrR7mH = new URL(EdptFUZI.getCodeBase() + xLanguagePath + oNdW6fIQ + ".ini");
                prop.load(N7JrR7mH.openStream());
            } else {
                prop.load(new FileInputStream(xLanguagePath + oNdW6fIQ + ".ini"));
            }
        } catch (Exception HwuZkVgf) {
            HwuZkVgf.printStackTrace();
            try {
                if (EdptFUZI != null) {
                    URL JwDRk09Y = new URL(EdptFUZI.getCodeBase() + xLanguagePath + "de.ini");
                    prop.load(JwDRk09Y.openStream());
                } else {
                    prop.load(new FileInputStream(xLanguagePath + "de.ini"));
                }
            } catch (Exception Oa0b9sG4) {
                JOptionPane.showMessageDialog(null, "Language file languages/de.ini not found.\nPlease run the program from its directory.");
                System.exit(5);
            }
        }
    }

}