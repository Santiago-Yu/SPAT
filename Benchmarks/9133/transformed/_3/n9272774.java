class n9272774 {
	private PluginInterface getClasseJar(String arquivo) {
		URLClassLoader load;
		try {
			URL url = new URL("jar", "", "file:" + arquivo + "!/");
			JarURLConnection jar = (JarURLConnection) url.openConnection();
			Enumeration arq = jar.getJarFile().entries();
			load = new URLClassLoader(new URL[] { url });
			while (arq.hasMoreElements()) {
				Object object = arq.nextElement();
				if (!(object.toString().contains(".class") && !object.toString().contains("PluginInterface.class")))
					;
				else {
					Class cl = load.loadClass(object.toString().replace(".class", ""));
					pl = (PluginInterface) cl.newInstance();
				}
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return pl;
	}

}