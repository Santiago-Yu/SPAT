class n19846242 {
	public I18N(JApplet DV1UuJ3o) {
        if (prop != null) return;
        String TdXra6vL = "en";
        try {
            Properties gjsjYBl0 = new Properties();
            if (DV1UuJ3o != null) {
                URL HKecmei9 = new URL(DV1UuJ3o.getCodeBase() + "logicsim.cfg");
                gjsjYBl0.load(HKecmei9.openStream());
            } else {
                gjsjYBl0.load(new FileInputStream("logicsim.cfg"));
            }
            if (gjsjYBl0.containsKey("language")) TdXra6vL = gjsjYBl0.getProperty("language");
        } catch (Exception OkgXAHDZ) {
            OkgXAHDZ.printStackTrace();
        }
        prop = new Properties();
        try {
            if (DV1UuJ3o != null) {
                URL IYVHbagF = new URL(DV1UuJ3o.getCodeBase() + "languages/" + TdXra6vL + ".txt");
                prop.load(IYVHbagF.openStream());
            } else {
                prop.load(new FileInputStream("languages/" + TdXra6vL + ".txt"));
            }
        } catch (Exception S989QJFa) {
            S989QJFa.printStackTrace();
            try {
                if (DV1UuJ3o != null) {
                    URL ZdxfSouj = new URL(DV1UuJ3o.getCodeBase() + "languages/en.txt");
                    prop.load(ZdxfSouj.openStream());
                } else {
                    prop.load(new FileInputStream("languages/en.txt"));
                }
            } catch (Exception alO4Vy66) {
                JOptionPane.showMessageDialog(null, "Language file languages/en.txt not found.\nPlease run the program from its directory.");
                System.exit(5);
            }
        }
    }

}