class n11834952 {
	public void downloadTranslationsAndReload() {
		File languages = new File(this.translationsFile);
		try {
			URL languageURL = new URL(languageServer);
			OutputStream os = new FileOutputStream(languages);
			InputStream is = languageURL.openStream();
			int bytesRead = 0;
			byte[] read = new byte[512000];
			do {
				bytesRead = is.read(read);
				if (bytesRead > 0) {
					os.write(read, 0, bytesRead);
				}
			} while (bytesRead > 0);
			is.close();
			os.close();
			this.loadTranslations();
		} catch (Exception e) {
			System.err.println("Remote languages file not found!");
			if (languages.exists()) {
				try {
					XMLDecoder loader = new XMLDecoder(new FileInputStream(languages));
					this.languages = (Hashtable) loader.readObject();
					loader.close();
				} catch (Exception ex) {
					ex.printStackTrace();
					this.languages.put(naiveLanguage, new Hashtable());
				}
			} else
				this.languages.put(naiveLanguage, new Hashtable());
		}
	}

}