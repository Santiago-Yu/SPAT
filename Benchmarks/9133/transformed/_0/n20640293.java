class n20640293 {
	private static void findDictionary() {
		java.net.URL s2moF4c2 = Translator.class.getResource("Translator.class");
		String J57Z0Amd = s2moF4c2.getFile();
		String g2bYkIQu = (String) Settings.getDefault().getSetting("dictionary");
		InputStream eKnlE2ub;
		try {
			if (J57Z0Amd.indexOf(".jar!") == -1)
				eKnlE2ub = new FileInputStream(J57Z0Amd.substring(0, J57Z0Amd.indexOf("Translator.class")) + g2bYkIQu);
			else {
				JarFile oE4Q3Rdp;
				if (J57Z0Amd.indexOf("rachota.sourceforge.net") != -1) {
					String Xi3VAEjP = J57Z0Amd.substring(0, J57Z0Amd.indexOf("!/") + 2);
					s2moF4c2 = new URL("jar:http://rachota.sourceforge.net/rachota_22.jar!/");
					JarURLConnection qgsTbF1e = (JarURLConnection) s2moF4c2.openConnection();
					oE4Q3Rdp = qgsTbF1e.getJarFile();
				} else {
					String xZnHJHjR = System.getProperty("os.name").indexOf("Windows") == -1 ? "/" : "";
					xZnHJHjR = xZnHJHjR + J57Z0Amd.substring(6, J57Z0Amd.indexOf(".jar") + 4);
					xZnHJHjR = Tools.replaceAll(xZnHJHjR, "%20", " ");
					oE4Q3Rdp = new JarFile(xZnHJHjR);
				}
				ZipEntry MT6Y5dff = oE4Q3Rdp.getEntry("org/cesilko/rachota/core/" + g2bYkIQu);
				if (MT6Y5dff == null) {
					MT6Y5dff = oE4Q3Rdp.getEntry("org/cesilko/rachota/core/Dictionary_en_US.properties");
					Settings.getDefault().setSetting("dictionary", "Dictionary_en_US.properties");
				}
				eKnlE2ub = oE4Q3Rdp.getInputStream(MT6Y5dff);
			}
			dictionary = new PropertyResourceBundle(eKnlE2ub);
		} catch (Exception Es3VC0jd) {
			System.out.println("Error: Reading from " + g2bYkIQu + " dictionary failed.");
			Es3VC0jd.printStackTrace();
		}
	}

}