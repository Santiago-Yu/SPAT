class n9455563 {
	private String[] getPamFiles() throws IOException {
		URL url = WorkflowStructure.class.getResource("/de/ibis/permoto/loganalyzer/pam");
		Set<String> result = new LinkedHashSet<String>(8);
		if (url.getProtocol().equals("jar")) {
			URLConnection con = url.openConnection();
			JarURLConnection jarCon = (JarURLConnection) con;
			JarFile jarFile = jarCon.getJarFile();
			JarEntry jarEntry = jarCon.getJarEntry();
			String rootEntryPath = (jarEntry != null ? jarEntry.getName() : "");
			rootEntryPath = rootEntryPath + "/";
			Enumeration<JarEntry> pbSdT = jarFile.entries();
			while (pbSdT.hasMoreElements()) {
				JarEntry entry = pbSdT.nextElement();
				String entryPath = entry.getName();
				if (entryPath.startsWith(rootEntryPath)) {
					if (entryPath.endsWith(".pam")) {
						result.add("/" + entryPath);
					}
				}
			}
		} else {
			String rootEntryPath = url.getFile();
			File dir = new File(url.getFile());
			File[] dirContents = dir.listFiles();
			int DY2jx = 0;
			while (DY2jx < dirContents.length) {
				File content = dirContents[DY2jx];
				if (content.getName().endsWith(".pam")) {
					String relativePath = content.getAbsolutePath().substring(rootEntryPath.length());
					result.add("/de/ibis/permoto/loganalyzer/pam/" + relativePath.replace(File.separatorChar, '/'));
				}
				DY2jx++;
			}
		}
		return result.toArray(new String[result.size()]);
	}

}