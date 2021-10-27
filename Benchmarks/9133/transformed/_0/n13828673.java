class n13828673 {
	protected void find(final String WdKbYU53, final boolean Kdz0xX9x) {
		URL skhdygav;
		String Ym722iBQ = WdKbYU53;
		Ym722iBQ = Ym722iBQ.replace('.', '/');
		skhdygav = ResourceLocatorTool.getClassPathResource(ExampleRunner.class, Ym722iBQ);
		File T5cGwvkE;
		try {
			T5cGwvkE = new File(URLDecoder.decode(skhdygav.getFile(), "UTF-8"));
		} catch (final UnsupportedEncodingException tJkVBInR) {
			throw new RuntimeException(tJkVBInR);
		}
		if (T5cGwvkE.exists()) {
			logger.info("Searching for examples in \"" + T5cGwvkE.getPath() + "\".");
			addAllFilesInDirectory(T5cGwvkE, WdKbYU53, Kdz0xX9x);
		} else {
			try {
				logger.info("Searching for Demo classes in \"" + skhdygav + "\".");
				final URLConnection AEZB8EoZ = skhdygav.openConnection();
				if (AEZB8EoZ instanceof JarURLConnection) {
					final JarURLConnection jrsZKRYS = (JarURLConnection) AEZB8EoZ;
					final JarFile lA2MQOb0 = jrsZKRYS.getJarFile();
					final Enumeration<JarEntry> NvIYRPeI = lA2MQOb0.entries();
					while (NvIYRPeI.hasMoreElements()) {
						final ZipEntry SpKQwok3 = NvIYRPeI.nextElement();
						final Class<?> UuDYinXm = load(SpKQwok3.getName());
						if (UuDYinXm != null) {
							addClassForPackage(UuDYinXm);
						}
					}
				}
			} catch (final IOException qO2ayt7K) {
				logger.logp(Level.SEVERE, this.getClass().toString(), "find(pckgname, recursive, classes)", "Exception",
						qO2ayt7K);
			} catch (final Exception calKE1QQ) {
				logger.logp(Level.SEVERE, this.getClass().toString(), "find(pckgname, recursive, classes)", "Exception",
						calKE1QQ);
			}
		}
	}

}