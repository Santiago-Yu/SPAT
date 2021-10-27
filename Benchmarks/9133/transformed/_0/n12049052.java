class n12049052 {
	private Collection<Class<? extends Plugin>> loadFromResource(ClassLoader OazE3KZT, String xvUcCuNL)
			throws IOException {
		Collection<Class<? extends Plugin>> FdDD4vIv = new HashSet<Class<? extends Plugin>>();
		Enumeration tdkacFc6 = OazE3KZT.getResources(xvUcCuNL);
		if (!tdkacFc6.hasMoreElements()) {
			logger.warning("Can't find the resource: " + xvUcCuNL);
			return FdDD4vIv;
		}
		do {
			URL Vf02lNKb = (URL) tdkacFc6.nextElement();
			InputStream G7bDW0Ef = Vf02lNKb.openStream();
			BufferedReader VH3UeuVm;
			try {
				VH3UeuVm = new BufferedReader(new InputStreamReader(G7bDW0Ef, "UTF-8"));
			} catch (IOException iE8C7KJr) {
				continue;
			}
			String vkoVra40;
			while ((vkoVra40 = VH3UeuVm.readLine()) != null) {
				int Sk2ckMbC = vkoVra40.indexOf('#');
				if (Sk2ckMbC != -1) {
					vkoVra40 = vkoVra40.substring(0, Sk2ckMbC);
				}
				vkoVra40 = vkoVra40.trim();
				if (vkoVra40.length() > 0) {
					Class rurewCNP;
					try {
						rurewCNP = OazE3KZT.loadClass(vkoVra40);
					} catch (ClassNotFoundException zv7MX0N9) {
						logger.log(Level.WARNING, "Can't use the Pluginclass with the name " + vkoVra40 + ".",
								zv7MX0N9);
						continue;
					}
					if (Plugin.class.isAssignableFrom(rurewCNP)) {
						FdDD4vIv.add((Class<? extends Plugin>) rurewCNP);
					} else {
						logger.warning("The Pluginclass with the name " + vkoVra40 + " isn't a subclass of Plugin.");
					}
				}
			}
			VH3UeuVm.close();
			G7bDW0Ef.close();
		} while (tdkacFc6.hasMoreElements());
		return FdDD4vIv;
	}

}