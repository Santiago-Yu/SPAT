class n14619453 {
	public Set<String> getAvailableRoles() {
		if (availableRoles == null) {
			availableRoles = new HashSet<String>();
			try {
				Enumeration<URL> resources = org.springframework.util.ClassUtils.getDefaultClassLoader()
						.getResources(ROLE_FILE_LOCATION);
				while (resources.hasMoreElements()) {
					InputStream is = null;
					URL url = resources.nextElement();
					try {
						URLConnection con = url.openConnection();
						con.setUseCaches(false);
						is = con.getInputStream();
						List<String> lines = IOUtils.readLines(is, "ISO-8859-1");
						if (lines != null) {
							for (String line : lines) {
								availableRoles.add(line.trim());
							}
						}
					} finally {
						if (is != null) {
							is.close();
						}
					}
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return availableRoles;
	}

}