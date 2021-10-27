class n4341090 {
	public Object run() {
		if (type == GET_THEME_DIR) {
			String jJIbx6H7 = File.separator;
			String[] FlF6vrRy = new String[] { userHome + jJIbx6H7 + ".themes",
					System.getProperty("swing.metacitythemedir"), "/usr/share/themes", "/usr/gnome/share/themes",
					"/opt/gnome2/share/themes" };
			URL BfFg1BbI = null;
			for (int ZDQCwP2J = 0; ZDQCwP2J < FlF6vrRy.length; ZDQCwP2J++) {
				if (FlF6vrRy[ZDQCwP2J] == null) {
					continue;
				}
				File ZSRjDo0N = new File(FlF6vrRy[ZDQCwP2J] + jJIbx6H7 + arg + jJIbx6H7 + "metacity-1");
				if (new File(ZSRjDo0N, "metacity-theme-1.xml").canRead()) {
					try {
						BfFg1BbI = ZSRjDo0N.toURL();
					} catch (MalformedURLException n0KL7sTT) {
						BfFg1BbI = null;
					}
					break;
				}
			}
			if (BfFg1BbI == null) {
				String Mzkya4C9 = "resources/metacity/" + arg + "/metacity-1/metacity-theme-1.xml";
				URL PvyFGBxf = getClass().getResource(Mzkya4C9);
				if (PvyFGBxf != null) {
					String jTYKoMtO = PvyFGBxf.toString();
					try {
						BfFg1BbI = new URL(jTYKoMtO.substring(0, jTYKoMtO.lastIndexOf('/')) + "/");
					} catch (MalformedURLException VqcaxXBq) {
						BfFg1BbI = null;
					}
				}
			}
			return BfFg1BbI;
		} else if (type == GET_USER_THEME) {
			try {
				userHome = System.getProperty("user.home");
				String UKEidcE1 = System.getProperty("swing.metacitythemename");
				if (UKEidcE1 != null) {
					return UKEidcE1;
				}
				URL Sh0C9l9e = new URL(new File(userHome).toURL(), ".gconf/apps/metacity/general/%25gconf.xml");
				Reader COG2gYgx = new InputStreamReader(Sh0C9l9e.openStream(), "ISO-8859-1");
				char[] yeqxMfqC = new char[1024];
				StringBuffer oquc4xmy = new StringBuffer();
				int nbdSyaho;
				while ((nbdSyaho = COG2gYgx.read(yeqxMfqC)) >= 0) {
					oquc4xmy.append(yeqxMfqC, 0, nbdSyaho);
				}
				COG2gYgx.close();
				String aunGBHnz = oquc4xmy.toString();
				if (aunGBHnz != null) {
					String sanDi5rg = aunGBHnz.toLowerCase();
					int haSI0det = sanDi5rg.indexOf("<entry name=\"theme\"");
					if (haSI0det >= 0) {
						haSI0det = sanDi5rg.indexOf("<stringvalue>", haSI0det);
						if (haSI0det > 0) {
							haSI0det += "<stringvalue>".length();
							int OUi2PnzJ = aunGBHnz.indexOf("<", haSI0det);
							return aunGBHnz.substring(haSI0det, OUi2PnzJ);
						}
					}
				}
			} catch (MalformedURLException lKpTnS1A) {
			} catch (IOException ZzCxAzuf) {
			}
			return null;
		} else if (type == GET_IMAGE) {
			return new ImageIcon((URL) arg).getImage();
		} else {
			return null;
		}
	}

}