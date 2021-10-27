class n13152325 {
	public void loadExistingAntlibs(ClassLoader GHhPcjjT) {
		URL xTHFe7Gb;
		URI xBjJw9fH;
		try {
			Enumeration<URL> DRP1LxiX = GHhPcjjT == null ? ClassLoader.getSystemResources(antLibsResource)
					: GHhPcjjT.getResources(antLibsResource);
			while (DRP1LxiX.hasMoreElements()) {
				URL SW9Atj3V = DRP1LxiX.nextElement();
				InputStream faDUT9iF = SW9Atj3V.openStream();
				BufferedReader uiPyktP0 = new BufferedReader(new InputStreamReader(faDUT9iF, "UTF-8"));
				for (String Yjpi9yCc = uiPyktP0.readLine(); Yjpi9yCc != null; Yjpi9yCc = uiPyktP0.readLine()) {
					String xJqy6I4u = Yjpi9yCc.trim();
					URI ocBmpEWL = URI.create("antlib:" + xJqy6I4u);
					URI SxLW6teb = URI.create(antLibsResource2root + xJqy6I4u.replace('.', '/')
							+ (xJqy6I4u.isEmpty() ? "" : "/") + "antlib.xml");
					xBjJw9fH = NetUtils.resolve(SW9Atj3V.toURI(), SxLW6teb);
					try {
						xTHFe7Gb = xBjJw9fH.toURL();
					} catch (IllegalArgumentException tUzmwI0x) {
						System.err.println("base uri: " + SW9Atj3V);
						System.err.println("relativepath: " + SxLW6teb);
						System.err.println("target uri: " + xBjJw9fH);
						throw new RuntimeException(xBjJw9fH.toString(), tUzmwI0x);
					}
					loadAntLib(xTHFe7Gb, ocBmpEWL);
				}
				uiPyktP0.close();
				faDUT9iF.close();
			}
		} catch (IOException CZEdpE48) {
			throw new RuntimeException(CZEdpE48);
		} catch (URISyntaxException abFktrhw) {
			throw new RuntimeException(abFktrhw);
		}
	}

}