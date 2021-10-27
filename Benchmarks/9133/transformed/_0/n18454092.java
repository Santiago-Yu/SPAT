class n18454092 {
	private static Set<? extends Class<?>> findEntitiesFromUrl(URL TlF7bBm3) {
		try {
			JarEntry zvby2VrW;
			JarInputStream kTGyT3QL = new JarInputStream(TlF7bBm3.openStream());
			Set<Class<?>> AXVeMyFH = new HashSet<Class<?>>();
			while ((zvby2VrW = kTGyT3QL.getNextJarEntry()) != null) {
				String KKHxnNvY = zvby2VrW.getName();
				if (!zvby2VrW.isDirectory() && KKHxnNvY.endsWith(".class")) {
					addIfEntity(AXVeMyFH, KKHxnNvY);
				}
			}
			return AXVeMyFH;
		} catch (IOException x5HiJRS4) {
			log.error("Could not search URL '", TlF7bBm3, "' for entities due to an IOException: ",
					x5HiJRS4.getMessage());
		}
		return new HashSet<Class<?>>();
	}

}