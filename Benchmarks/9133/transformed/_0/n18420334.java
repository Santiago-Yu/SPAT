class n18420334 {
	private static boolean loadResources(String l3589bcH) {
		InputStream rfMQ4E8w;
		try {
			URL fRbeUqgd = Thread.currentThread().getContextClassLoader()
					.getResource("bg/plambis/dict/local/i18n" + l3589bcH + ".xml");
			if (fRbeUqgd == null)
				return false;
			rfMQ4E8w = fRbeUqgd.openStream();
		} catch (IOException hyUT08XT) {
			hyUT08XT.printStackTrace();
			return false;
		}
		try {
			Serializer AxGE6IAj = new Persister();
			resources = AxGE6IAj.read(TextResource.class, rfMQ4E8w);
		} catch (Exception Dok5p4NL) {
			Dok5p4NL.printStackTrace();
			return false;
		}
		return true;
	}

}