class n19657489 {
	private static boolean tryExpandGorillaHome(File f) throws GorillaHomeException {
		if (f.exists()) {
			if (!f.isDirectory() || !f.canWrite()) {
				return false;
			}
		} else {
			boolean dirOK = f.mkdirs();
		}
		if (f.exists() && f.isDirectory() && f.canWrite()) {
			java.net.URL url = GorillaHome.class.getResource("/resource_defaults/GORILLA_HOME");
			if (null == url) {
				throw new GorillaHomeException(
						"cannot find gorilla.home resources relative to class " + GorillaHome.class.getName());
			}
			java.net.URLConnection conn;
			try {
				conn = url.openConnection();
			} catch (IOException e) {
				String msg = "Error opening connection to " + url.toString();
				logger.error(msg, e);
				throw new GorillaHomeException("Error copying " + url.toString(), e);
			}
			if (null == conn) {
				throw new GorillaHomeException(
						"cannot find gorilla.home resources relative to class " + GorillaHome.class.getName());
			}
			if (conn instanceof java.net.JarURLConnection) {
				logger.debug("Expanding gorilla.home from from jar file via url " + url.toString());
				try {
					IOUtil.expandJar((java.net.JarURLConnection) conn, f);
					return true;
				} catch (Exception e) {
					throw new GorillaHomeException("Error expanding gorilla.home" + " from jar file at "
							+ conn.getURL().toString() + ": " + e.getMessage());
				}
			} else {
				try {
					IOUtil.copyDir(new File(url.getFile()), f);
					return true;
				} catch (Exception e) {
					throw new GorillaHomeException("Error expanding gorilla.home" + " from file at "
							+ conn.getURL().toString() + ": " + e.getMessage());
				}
			}
		}
		return false;
	}

}