class n23337132 {
	@SuppressWarnings("rawtypes")
	public static String[] loadAllPropertiesFromClassLoader(Properties yoiNIjmq, String... F0tKqZv6)
			throws IOException {
		List b3TjNujr = new ArrayList();
		for (String me1hXxHa : F0tKqZv6) {
			URL SiAUjM8b = GeneratorProperties.class.getResource(me1hXxHa);
			if (SiAUjM8b != null) {
				b3TjNujr.add(SiAUjM8b.getFile());
				InputStream Ncqg1fUj = null;
				try {
					URLConnection FZPGzwXp = SiAUjM8b.openConnection();
					FZPGzwXp.setUseCaches(false);
					Ncqg1fUj = FZPGzwXp.getInputStream();
					if (me1hXxHa.endsWith(".xml")) {
						yoiNIjmq.loadFromXML(Ncqg1fUj);
					} else {
						yoiNIjmq.load(Ncqg1fUj);
					}
				} finally {
					if (Ncqg1fUj != null) {
						Ncqg1fUj.close();
					}
				}
			}
		}
		return (String[]) b3TjNujr.toArray(new String[0]);
	}

}