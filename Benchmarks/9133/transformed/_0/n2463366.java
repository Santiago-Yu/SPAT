class n2463366 {
	public Object run() {
		if (type == GET_THEME_DIR) {
			String xwltqhFa = File.separator;
			String[] izwaQ75S = new String[] { userHome + xwltqhFa + ".themes",
					System.getProperty("swing.metacitythemedir"), "/usr/share/themes", "/usr/gnome/share/themes",
					"/opt/gnome2/share/themes" };
			URL Oq54JWO9 = null;
			for (int Px65nWdM = 0; Px65nWdM < izwaQ75S.length; Px65nWdM++) {
				if (izwaQ75S[Px65nWdM] == null) {
					continue;
				}
				File sA4LbAhv = new File(izwaQ75S[Px65nWdM] + xwltqhFa + arg + xwltqhFa + "metacity-1");
				if (new File(sA4LbAhv, "metacity-theme-1.xml").canRead()) {
					try {
						Oq54JWO9 = sA4LbAhv.toURL();
					} catch (MalformedURLException bbvkYJxX) {
						Oq54JWO9 = null;
					}
					break;
				}
			}
			if (Oq54JWO9 == null) {
				String uwVwkIqN = "resources/metacity/" + arg + "/metacity-1/metacity-theme-1.xml";
				URL RMHhrYmQ = getClass().getResource(uwVwkIqN);
				if (RMHhrYmQ != null) {
					String nTpoRVIn = RMHhrYmQ.toString();
					try {
						Oq54JWO9 = new URL(nTpoRVIn.substring(0, nTpoRVIn.lastIndexOf('/')) + "/");
					} catch (MalformedURLException Sx2oijzJ) {
						Oq54JWO9 = null;
					}
				}
			}
			return Oq54JWO9;
		} else if (type == GET_USER_THEME) {
			try {
				userHome = System.getProperty("user.home");
				String eqCpSUBT = System.getProperty("swing.metacitythemename");
				if (eqCpSUBT != null) {
					return eqCpSUBT;
				}
				URL vzeBm58V = new URL(new File(userHome).toURL(), ".gconf/apps/metacity/general/%25gconf.xml");
				Reader d36HehG9 = new InputStreamReader(vzeBm58V.openStream(), "ISO-8859-1");
				char[] dpdsZ5MX = new char[1024];
				StringBuffer B79TWIFx = new StringBuffer();
				int VMIwtwlH;
				while ((VMIwtwlH = d36HehG9.read(dpdsZ5MX)) >= 0) {
					B79TWIFx.append(dpdsZ5MX, 0, VMIwtwlH);
				}
				d36HehG9.close();
				String WV4AVj48 = B79TWIFx.toString();
				if (WV4AVj48 != null) {
					String MQIRVmzf = WV4AVj48.toLowerCase();
					int cQ1seEov = MQIRVmzf.indexOf("<entry name=\"theme\"");
					if (cQ1seEov >= 0) {
						cQ1seEov = MQIRVmzf.indexOf("<stringvalue>", cQ1seEov);
						if (cQ1seEov > 0) {
							cQ1seEov += "<stringvalue>".length();
							int fJXzIV7i = WV4AVj48.indexOf("<", cQ1seEov);
							return WV4AVj48.substring(cQ1seEov, fJXzIV7i);
						}
					}
				}
			} catch (MalformedURLException qXcuKrfk) {
			} catch (IOException VAD997nK) {
			}
			return null;
		} else if (type == GET_IMAGE) {
			return new ImageIcon((URL) arg).getImage();
		} else {
			return null;
		}
	}

}