class n9272774 {
	private PluginInterface getClasseJar(String unFKKmew) {
		URLClassLoader NE1uodHL;
		try {
			URL bZdWo0UO = new URL("jar", "", "file:" + unFKKmew + "!/");
			JarURLConnection qcNxzeNz = (JarURLConnection) bZdWo0UO.openConnection();
			Enumeration PgyI3S4u = qcNxzeNz.getJarFile().entries();
			NE1uodHL = new URLClassLoader(new URL[] { bZdWo0UO });
			while (PgyI3S4u.hasMoreElements()) {
				Object c1iSdamU = PgyI3S4u.nextElement();
				if (c1iSdamU.toString().contains(".class") && !c1iSdamU.toString().contains("PluginInterface.class")) {
					Class vf4ZJRvN = NE1uodHL.loadClass(c1iSdamU.toString().replace(".class", ""));
					pl = (PluginInterface) vf4ZJRvN.newInstance();
				}
			}
		} catch (MalformedURLException Fg74l3xR) {
			Fg74l3xR.printStackTrace();
		} catch (IOException yXivJsDI) {
			yXivJsDI.printStackTrace();
		} catch (ClassNotFoundException gIzDvVZx) {
			gIzDvVZx.printStackTrace();
		} catch (InstantiationException y98M3pMl) {
			y98M3pMl.printStackTrace();
		} catch (IllegalAccessException xPdx5UQV) {
			xPdx5UQV.printStackTrace();
		}
		return pl;
	}

}