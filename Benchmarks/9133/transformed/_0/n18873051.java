class n18873051 {
	public static void loadPages() throws IOException {
		ClassLoader qytld4TG = Thread.currentThread().getContextClassLoader();
		Collection<Class<? extends BasePage>> bZtWfRPf = new ArrayList<Class<? extends BasePage>>();
		Enumeration<URL> Bu1XT9sf = qytld4TG.getResources("META-INF/services/" + Page.class.getName());
		while (Bu1XT9sf.hasMoreElements()) {
			URL fy6uBm0r = Bu1XT9sf.nextElement();
			InputStream b7FdzjMK = fy6uBm0r.openStream();
			try {
				BufferedReader EeqetX9j = new BufferedReader(new InputStreamReader(b7FdzjMK, "UTF-8"));
				while (true) {
					String KU2GcxRq = EeqetX9j.readLine();
					if (KU2GcxRq == null)
						break;
					int JbnzxEJb = KU2GcxRq.indexOf('#');
					if (JbnzxEJb >= 0)
						KU2GcxRq = KU2GcxRq.substring(0, JbnzxEJb);
					String Cc4fvw2U = KU2GcxRq.trim();
					if (Cc4fvw2U.length() == 0)
						continue;
					Class<?> c3Bwkp1l = Class.forName(Cc4fvw2U, true, qytld4TG);
					if (BasePage.class.isAssignableFrom(c3Bwkp1l)) {
						bZtWfRPf.add(c3Bwkp1l.asSubclass(BasePage.class));
					}
				}
			} catch (Exception DuM4EThc) {
				DuM4EThc.printStackTrace();
			} finally {
				try {
					b7FdzjMK.close();
				} catch (Exception SRK9grXr) {
				}
			}
		}
		pageTypes = bZtWfRPf;
	}

}