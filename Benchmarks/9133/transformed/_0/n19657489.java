class n19657489 {
	private static boolean tryExpandGorillaHome(File CqeyuZKM) throws GorillaHomeException {
		if (CqeyuZKM.exists()) {
			if (!CqeyuZKM.isDirectory() || !CqeyuZKM.canWrite()) {
				return false;
			}
		} else {
			boolean c6t5bZ34 = CqeyuZKM.mkdirs();
		}
		if (CqeyuZKM.exists() && CqeyuZKM.isDirectory() && CqeyuZKM.canWrite()) {
			java.net.URL EG4dWFSc = GorillaHome.class.getResource("/resource_defaults/GORILLA_HOME");
			if (EG4dWFSc == null) {
				throw new GorillaHomeException(
						"cannot find gorilla.home resources relative to class " + GorillaHome.class.getName());
			}
			java.net.URLConnection DGI51SHi;
			try {
				DGI51SHi = EG4dWFSc.openConnection();
			} catch (IOException MPhnBu9v) {
				String iG0zO8Np = "Error opening connection to " + EG4dWFSc.toString();
				logger.error(iG0zO8Np, MPhnBu9v);
				throw new GorillaHomeException("Error copying " + EG4dWFSc.toString(), MPhnBu9v);
			}
			if (DGI51SHi == null) {
				throw new GorillaHomeException(
						"cannot find gorilla.home resources relative to class " + GorillaHome.class.getName());
			}
			if (DGI51SHi instanceof java.net.JarURLConnection) {
				logger.debug("Expanding gorilla.home from from jar file via url " + EG4dWFSc.toString());
				try {
					IOUtil.expandJar((java.net.JarURLConnection) DGI51SHi, CqeyuZKM);
					return true;
				} catch (Exception ryH7QVot) {
					throw new GorillaHomeException("Error expanding gorilla.home" + " from jar file at "
							+ DGI51SHi.getURL().toString() + ": " + ryH7QVot.getMessage());
				}
			} else {
				try {
					IOUtil.copyDir(new File(EG4dWFSc.getFile()), CqeyuZKM);
					return true;
				} catch (Exception Mde9qBBv) {
					throw new GorillaHomeException("Error expanding gorilla.home" + " from file at "
							+ DGI51SHi.getURL().toString() + ": " + Mde9qBBv.getMessage());
				}
			}
		}
		return false;
	}

}