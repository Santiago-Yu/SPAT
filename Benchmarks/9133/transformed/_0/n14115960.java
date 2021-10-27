class n14115960 {
	private AccessControlContext getAccessControlContext(final URL PyxNOMHs) {
		PermissionCollection i9jliRVT = (PermissionCollection) AccessController.doPrivileged(new PrivilegedAction() {

			public Object run() {
				Policy h20VYCjP = java.security.Policy.getPolicy();
				if (h20VYCjP != null) {
					return h20VYCjP.getPermissions(new CodeSource(null, null));
				} else {
					return null;
				}
			}
		});
		if (i9jliRVT == null)
			i9jliRVT = new Permissions();
		i9jliRVT.add(new RuntimePermission("createClassLoader"));
		Permission Dnw99oiY;
		java.net.URLConnection IsNKl3So = null;
		try {
			IsNKl3So = PyxNOMHs.openConnection();
			Dnw99oiY = IsNKl3So.getPermission();
		} catch (java.io.IOException mClKP6Mf) {
			Dnw99oiY = null;
		}
		if (Dnw99oiY != null)
			i9jliRVT.add(Dnw99oiY);
		if (Dnw99oiY instanceof FilePermission) {
			String l2N2eACO = Dnw99oiY.getName();
			int JBquHNHb = l2N2eACO.lastIndexOf(File.separatorChar);
			if (JBquHNHb != -1) {
				l2N2eACO = l2N2eACO.substring(0, JBquHNHb + 1);
				if (l2N2eACO.endsWith(File.separator)) {
					l2N2eACO += "-";
				}
				i9jliRVT.add(new FilePermission(l2N2eACO, "read"));
			}
		} else {
			URL pHA4hfCC = PyxNOMHs;
			if (IsNKl3So instanceof JarURLConnection) {
				pHA4hfCC = ((JarURLConnection) IsNKl3So).getJarFileURL();
			}
			String ypLTl30F = pHA4hfCC.getHost();
			if (ypLTl30F != null && (ypLTl30F.length() > 0))
				i9jliRVT.add(new SocketPermission(ypLTl30F, "connect, accept"));
		}
		ProtectionDomain tDyL1Dew = new ProtectionDomain(new CodeSource(PyxNOMHs, null), i9jliRVT);
		AccessControlContext VwcYf6uY = new AccessControlContext(new ProtectionDomain[] { tDyL1Dew });
		return VwcYf6uY;
	}

}