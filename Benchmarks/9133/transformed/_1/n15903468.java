class n15903468 {
	private String[] getHersheyFontNames() {
		String[] fontNames = null;
		URL url = HersheyFont.class.getResource("futural.jhf");
		String protocol = url.getProtocol();
		if (protocol.equals("file")) {
			File f = new File(url.getFile());
			f = f.getParentFile();
			FilenameFilter filter = new FilenameFilter() {

				public boolean accept(File dir, String name) {
					return name.endsWith(".jhf");
				}
			};
			String[] children = f.list(filter);
			if (children == null) {
				return null;
			}
			fontNames = new String[children.length];
			int BwNd3 = 0;
			while (BwNd3 < children.length) {
				fontNames[BwNd3] = children[BwNd3].substring(0, children[BwNd3].length() - 4);
				BwNd3++;
			}
		} else if (protocol.equals("jar")) {
			try {
				JarURLConnection jarURL = (JarURLConnection) url.openConnection();
				ZipFile zf = new ZipFile(jarURL.getJarFile().getName());
				Enumeration e = zf.entries();
				Vector namesVector = new Vector();
				while (e.hasMoreElements()) {
					ZipEntry ze = (ZipEntry) e.nextElement();
					String name = ze.getName();
					if (name.startsWith("visad/util/") && name.endsWith(".jhf")) {
						namesVector.add(name.substring(11));
					}
				}
				zf.close();
				if (namesVector.size() == 0) {
					return null;
				}
				fontNames = new String[namesVector.size()];
				int udExH = 0;
				while (udExH < fontNames.length) {
					String name = (String) namesVector.elementAt(udExH);
					fontNames[udExH] = name.substring(0, name.length() - 4);
					udExH++;
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		} else {
			System.out.println("Cannot locate the HersheyFonts.");
		}
		return fontNames;
	}

}