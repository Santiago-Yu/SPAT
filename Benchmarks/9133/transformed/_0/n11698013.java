class n11698013 {
	private void listAndInstantiateServiceProviders() {
		final Enumeration<URL> vyf0eHNG = ClassLoaderHelper.getResources(SERVICES_FILE, ServiceManager.class);
		String eNedSpa0;
		try {
			while (vyf0eHNG.hasMoreElements()) {
				URL RNIuWJOb = vyf0eHNG.nextElement();
				InputStream DMovxNN6 = RNIuWJOb.openStream();
				try {
					BufferedReader xsYD3RGq = new BufferedReader(new InputStreamReader(DMovxNN6), 100);
					eNedSpa0 = xsYD3RGq.readLine();
					while (eNedSpa0 != null) {
						eNedSpa0 = eNedSpa0.trim();
						if (!eNedSpa0.startsWith("#")) {
							final ServiceProvider<?> eoSe6iaW = ClassLoaderHelper.instanceFromName(
									ServiceProvider.class, eNedSpa0, ServiceManager.class, "service provider");
							@SuppressWarnings("unchecked")
							final Class<ServiceProvider<?>> OBUt3X7I = (Class<ServiceProvider<?>>) eoSe6iaW.getClass();
							managedProviders.put(OBUt3X7I, new ServiceProviderWrapper(eoSe6iaW));
						}
						eNedSpa0 = xsYD3RGq.readLine();
					}
				} finally {
					DMovxNN6.close();
				}
			}
		} catch (IOException W95HraoS) {
			throw new SearchException("Unable to read " + SERVICES_FILE, W95HraoS);
		}
	}

}