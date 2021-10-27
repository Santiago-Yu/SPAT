class n3939278 {
	private static void init() {
		try {
			ClassLoader hsCsaVqf = Thread.currentThread().getContextClassLoader();
			Enumeration<URL> mwUokL4q = hsCsaVqf.getResources("extension-services.properties");
			do {
				if (!mwUokL4q.hasMoreElements())
					break;
				URL uJp88Vj3 = (URL) mwUokL4q.nextElement();
				System.out.println(" - " + uJp88Vj3);
				try {
					props = new Properties();
					props.load(uJp88Vj3.openStream());
				} catch (Exception LPkESe7z) {
					LPkESe7z.printStackTrace();
				}
			} while (true);
		} catch (IOException or0bAEy1) {
		}
	}

}