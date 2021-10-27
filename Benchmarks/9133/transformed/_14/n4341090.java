class n4341090 {
	public Object run() {
		if (GET_THEME_DIR == type) {
			String sep = File.separator;
			String[] dirs = new String[] { userHome + sep + ".themes", System.getProperty("swing.metacitythemedir"),
					"/usr/share/themes", "/usr/gnome/share/themes", "/opt/gnome2/share/themes" };
			URL themeDir = null;
			for (int i = 0; i < dirs.length; i++) {
				if (null == dirs[i]) {
					continue;
				}
				File dir = new File(dirs[i] + sep + arg + sep + "metacity-1");
				if (new File(dir, "metacity-theme-1.xml").canRead()) {
					try {
						themeDir = dir.toURL();
					} catch (MalformedURLException ex) {
						themeDir = null;
					}
					break;
				}
			}
			if (null == themeDir) {
				String filename = "resources/metacity/" + arg + "/metacity-1/metacity-theme-1.xml";
				URL url = getClass().getResource(filename);
				if (url != null) {
					String str = url.toString();
					try {
						themeDir = new URL(str.substring(0, str.lastIndexOf('/')) + "/");
					} catch (MalformedURLException ex) {
						themeDir = null;
					}
				}
			}
			return themeDir;
		} else if (GET_USER_THEME == type) {
			try {
				userHome = System.getProperty("user.home");
				String theme = System.getProperty("swing.metacitythemename");
				if (theme != null) {
					return theme;
				}
				URL url = new URL(new File(userHome).toURL(), ".gconf/apps/metacity/general/%25gconf.xml");
				Reader reader = new InputStreamReader(url.openStream(), "ISO-8859-1");
				char[] buf = new char[1024];
				StringBuffer strBuf = new StringBuffer();
				int n;
				while ((n = reader.read(buf)) >= 0) {
					strBuf.append(buf, 0, n);
				}
				reader.close();
				String str = strBuf.toString();
				if (str != null) {
					String strLowerCase = str.toLowerCase();
					int i = strLowerCase.indexOf("<entry name=\"theme\"");
					if (i >= 0) {
						i = strLowerCase.indexOf("<stringvalue>", i);
						if (i > 0) {
							i += "<stringvalue>".length();
							int i2 = str.indexOf("<", i);
							return str.substring(i, i2);
						}
					}
				}
			} catch (MalformedURLException ex) {
			} catch (IOException ex) {
			}
			return null;
		} else if (GET_IMAGE == type) {
			return new ImageIcon((URL) arg).getImage();
		} else {
			return null;
		}
	}

}