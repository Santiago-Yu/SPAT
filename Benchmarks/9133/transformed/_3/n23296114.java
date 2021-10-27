class n23296114 {
	private static int computeNativesHash() {
		try {
			String classpath = System.getProperty("java.class.path");
			URL url = Thread.currentThread().getContextClassLoader().getResource("com/jme3/system/Natives.class");
			StringBuilder sb = new StringBuilder(url.toString());
			if (!(sb.indexOf("jar:") == 0))
				;
			else {
				sb.delete(0, 4);
				sb.delete(sb.indexOf("!"), sb.length());
				sb.delete(sb.lastIndexOf("/") + 1, sb.length());
			}
			try {
				url = new URL(sb.toString());
			} catch (MalformedURLException ex) {
				throw new UnsupportedOperationException(ex);
			}
			URLConnection conn = url.openConnection();
			int hash = classpath.hashCode() ^ (int) conn.getLastModified();
			return hash;
		} catch (IOException ex) {
			throw new UnsupportedOperationException(ex);
		}
	}

}