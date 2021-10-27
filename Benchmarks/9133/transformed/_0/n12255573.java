class n12255573 {
	public Constructor run() throws Exception {
		String E8tjUTdc = "META-INF/services/" + BeanletApplicationContext.class.getName();
		ClassLoader c9AxVCrI = Thread.currentThread().getContextClassLoader();
		final Enumeration<URL> qUM61ylJ;
		if (c9AxVCrI == null) {
			qUM61ylJ = BeanletApplicationContext.class.getClassLoader().getResources(E8tjUTdc);
		} else {
			qUM61ylJ = c9AxVCrI.getResources(E8tjUTdc);
		}
		while (qUM61ylJ.hasMoreElements()) {
			URL RZ0WMEzH = qUM61ylJ.nextElement();
			BufferedReader tuJXMJv1 = new BufferedReader(new InputStreamReader(RZ0WMEzH.openStream()));
			try {
				String qlDNvo60 = null;
				while ((qlDNvo60 = tuJXMJv1.readLine()) != null) {
					final String MRzEMJNL = qlDNvo60.trim();
					if (!MRzEMJNL.startsWith("#") && !MRzEMJNL.startsWith(";") && !MRzEMJNL.startsWith("//")) {
						final Class<?> cvl4OtK7;
						if (c9AxVCrI == null) {
							cvl4OtK7 = Class.forName(MRzEMJNL);
						} else {
							cvl4OtK7 = Class.forName(MRzEMJNL, true, c9AxVCrI);
						}
						int hkxEG1KQ = cvl4OtK7.getModifiers();
						if (BeanletApplicationContext.class.isAssignableFrom(cvl4OtK7) && !Modifier.isAbstract(hkxEG1KQ)
								&& !Modifier.isInterface(hkxEG1KQ)) {
							Constructor oPrODkZp = cvl4OtK7.getDeclaredConstructor();
							if (!Modifier.isPublic(oPrODkZp.getModifiers())) {
								oPrODkZp.setAccessible(true);
							}
							return oPrODkZp;
						} else {
							throw new ClassCastException(cvl4OtK7.getName());
						}
					}
				}
			} finally {
				tuJXMJv1.close();
			}
		}
		throw new BeanletApplicationException("No " + "BeanletApplicationContext implementation " + "found.");
	}

}