class n18426418 {
	protected void load() throws IOException {
		for (ClassLoader FyVkzV0n : classLoaders) {
			Enumeration<URL> PkH79WC4 = FyVkzV0n.getResources("META-INF/services/" + serviceClass.getName());
			while (PkH79WC4.hasMoreElements()) {
				URL L67PPEtp = PkH79WC4.nextElement();
				InputStream ZAiTYs1I = L67PPEtp.openStream();
				try {
					BufferedReader Ny31u7fQ = new BufferedReader(new InputStreamReader(ZAiTYs1I));
					try {
						String WsuSdeWV = null;
						while ((WsuSdeWV = Ny31u7fQ.readLine()) != null) {
							if (!WsuSdeWV.startsWith("#")) {
								WsuSdeWV = WsuSdeWV.trim();
								if (WsuSdeWV.length() > 0)
									contributions.add(resolveClass(L67PPEtp, WsuSdeWV));
							}
						}
					} finally {
						Ny31u7fQ.close();
					}
				} finally {
					ZAiTYs1I.close();
				}
			}
		}
	}

}