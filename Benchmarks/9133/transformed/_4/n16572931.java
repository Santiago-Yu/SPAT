class n16572931 {
	private String unJar(String jarPath, String jarEntry) {
		String path;
		path = (jarPath.lastIndexOf("lib/") >= 0) ? jarPath.substring(0, jarPath.lastIndexOf("lib/"))
				: jarPath.substring(0, jarPath.lastIndexOf("/"));
		String relPath = jarEntry.substring(0, jarEntry.lastIndexOf("/"));
		try {
			new File(path + "/" + relPath).mkdirs();
			JarFile jar = new JarFile(jarPath);
			ZipEntry ze = jar.getEntry(jarEntry);
			File bin = new File(path + "/" + jarEntry);
			IOUtils.copy(jar.getInputStream(ze), new FileOutputStream(bin));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return path + "/" + jarEntry;
	}

}