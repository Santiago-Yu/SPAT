class n11834952 {
	public void downloadTranslationsAndReload() {
		File WsZHtNxV = new File(this.translationsFile);
		try {
			URL kkW3Yard = new URL(languageServer);
			InputStream ZnaaPVlT = kkW3Yard.openStream();
			OutputStream ngA58psj = new FileOutputStream(WsZHtNxV);
			byte[] UntoLAKQ = new byte[512000];
			int s5zgc7p2 = 0;
			do {
				s5zgc7p2 = ZnaaPVlT.read(UntoLAKQ);
				if (s5zgc7p2 > 0) {
					ngA58psj.write(UntoLAKQ, 0, s5zgc7p2);
				}
			} while (s5zgc7p2 > 0);
			ZnaaPVlT.close();
			ngA58psj.close();
			this.loadTranslations();
		} catch (Exception rqisDQ3I) {
			System.err.println("Remote languages file not found!");
			if (WsZHtNxV.exists()) {
				try {
					XMLDecoder u7VTUqEY = new XMLDecoder(new FileInputStream(WsZHtNxV));
					this.languages = (Hashtable) u7VTUqEY.readObject();
					u7VTUqEY.close();
				} catch (Exception e0SzEvhs) {
					e0SzEvhs.printStackTrace();
					this.languages.put(naiveLanguage, new Hashtable());
				}
			} else
				this.languages.put(naiveLanguage, new Hashtable());
		}
	}

}