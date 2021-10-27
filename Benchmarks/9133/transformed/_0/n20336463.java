class n20336463 {
	private static void prepare() {
		System.err.println("PREPARING-----------------------------------------");
		deleteHome();
		InputStream mlZOv7a7 = null;
		FileOutputStream erHOz5JI = null;
		try {
			mlZOv7a7 = AllTests.class.getClassLoader()
					.getResourceAsStream("net/sf/archimede/test/resources/repository.xml");
			new File("temp").mkdir();
			erHOz5JI = new FileOutputStream(new File("temp/repository.xml"));
			IOUtils.copy(mlZOv7a7, erHOz5JI);
		} catch (FileNotFoundException YAXl3Ck7) {
			YAXl3Ck7.printStackTrace();
		} catch (IOException APMu268y) {
			APMu268y.printStackTrace();
		} finally {
			try {
				if (mlZOv7a7 != null) {
					mlZOv7a7.close();
				}
			} catch (IOException NPLJTU72) {
				NPLJTU72.printStackTrace();
			} finally {
				if (erHOz5JI != null) {
					try {
						erHOz5JI.close();
					} catch (IOException XDah9gA4) {
						XDah9gA4.printStackTrace();
					}
				}
			}
		}
		String ryGDXwQI = "jackrabbit.repository";
		Properties kLKyI3m2 = new Properties();
		kLKyI3m2.put("java.naming.provider.url", "http://sf.net/projects/archimede#1");
		kLKyI3m2.put("java.naming.factory.initial",
				"org.apache.jackrabbit.core.jndi.provider.DummyInitialContextFactory");
		startupUtil = new StartupJcrUtil(REPOSITORY_HOME, "temp/repository.xml", ryGDXwQI, kLKyI3m2);
		startupUtil.init();
	}

}