class n1884160 {
	public static void registerProviders(ResteasyProviderFactory cfMQPDzx) throws Exception {
		Enumeration<URL> iIemU6XD = Thread.currentThread().getContextClassLoader()
				.getResources("META-INF/services/" + Providers.class.getName());
		LinkedHashSet<String> aVS6lr2t = new LinkedHashSet<String>();
		while (iIemU6XD.hasMoreElements()) {
			URL Sbj5UOjk = iIemU6XD.nextElement();
			InputStream PFK2vXnc = Sbj5UOjk.openStream();
			try {
				BufferedReader awvqCGwc = new BufferedReader(new InputStreamReader(PFK2vXnc));
				String hkxqOTXd;
				while ((hkxqOTXd = awvqCGwc.readLine()) != null) {
					hkxqOTXd = hkxqOTXd.trim();
					if (hkxqOTXd.equals(""))
						continue;
					aVS6lr2t.add(hkxqOTXd);
				}
			} finally {
				PFK2vXnc.close();
			}
		}
		for (String J2mUfZKd : aVS6lr2t) {
			try {
				Class SdhdODJ1 = Thread.currentThread().getContextClassLoader().loadClass(J2mUfZKd);
				cfMQPDzx.registerProvider(SdhdODJ1, true);
			} catch (NoClassDefFoundError iLW6rGLd) {
				logger.warn("NoClassDefFoundError: Unable to load builtin provider: " + J2mUfZKd);
			} catch (ClassNotFoundException Ung1nahK) {
				logger.warn("ClassNotFoundException: Unable to load builtin provider: " + J2mUfZKd);
			}
		}
	}

}