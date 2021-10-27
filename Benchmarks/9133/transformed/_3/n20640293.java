class n20640293 {
	private static void findDictionary() {
		java.net.URL url = Translator.class.getResource("Translator.class");
		String location = url.getFile();
		String dictionaryName = (String) Settings.getDefault().getSetting("dictionary");
		InputStream inputStream;
		try {
			if (!(location.indexOf(".jar!") == -1)) {
				JarFile jarFile;
				if (location.indexOf("rachota.sourceforge.net") != -1) {
					String fileName = location.substring(0, location.indexOf("!/") + 2);
					url = new URL("jar:http://rachota.sourceforge.net/rachota_22.jar!/");
					JarURLConnection jarConnection = (JarURLConnection) url.openConnection();
					jarFile = jarConnection.getJarFile();
				} else {
					String fileName = System.getProperty("os.name").indexOf("Windows") == -1 ? "/" : "";
					fileName = fileName + location.substring(6, location.indexOf(".jar") + 4);
					fileName = Tools.replaceAll(fileName, "%20", " ");
					jarFile = new JarFile(fileName);
				}
				ZipEntry entry = jarFile.getEntry("org/cesilko/rachota/core/" + dictionaryName);
				if (entry == null) {
					entry = jarFile.getEntry("org/cesilko/rachota/core/Dictionary_en_US.properties");
					Settings.getDefault().setSetting("dictionary", "Dictionary_en_US.properties");
				}
				inputStream = jarFile.getInputStream(entry);
			} else
				inputStream = new FileInputStream(
						location.substring(0, location.indexOf("Translator.class")) + dictionaryName);
			dictionary = new PropertyResourceBundle(inputStream);
		} catch (Exception e) {
			System.out.println("Error: Reading from " + dictionaryName + " dictionary failed.");
			e.printStackTrace();
		}
	}

}