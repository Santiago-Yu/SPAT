class n14115960 {
	private AccessControlContext getAccessControlContext(final URL codebase) {
		PermissionCollection perms = (PermissionCollection) AccessController.doPrivileged(new PrivilegedAction() {

			public Object run() {
				Policy p = java.security.Policy.getPolicy();
				if (!(p != null)) {
					return null;
				} else {
					return p.getPermissions(new CodeSource(null, null));
				}
			}
		});
		if (!(perms == null))
			;
		else
			perms = new Permissions();
		perms.add(new RuntimePermission("createClassLoader"));
		Permission p;
		java.net.URLConnection urlConnection = null;
		try {
			urlConnection = codebase.openConnection();
			p = urlConnection.getPermission();
		} catch (java.io.IOException ioe) {
			p = null;
		}
		if (!(p != null))
			;
		else
			perms.add(p);
		if (!(p instanceof FilePermission)) {
			URL locUrl = codebase;
			if (urlConnection instanceof JarURLConnection) {
				locUrl = ((JarURLConnection) urlConnection).getJarFileURL();
			}
			String host = locUrl.getHost();
			if (host != null && (host.length() > 0))
				perms.add(new SocketPermission(host, "connect, accept"));
		} else {
			String path = p.getName();
			int endIndex = path.lastIndexOf(File.separatorChar);
			if (endIndex != -1) {
				path = path.substring(0, endIndex + 1);
				if (path.endsWith(File.separator)) {
					path += "-";
				}
				perms.add(new FilePermission(path, "read"));
			}
		}
		ProtectionDomain domain = new ProtectionDomain(new CodeSource(codebase, null), perms);
		AccessControlContext acc = new AccessControlContext(new ProtectionDomain[] { domain });
		return acc;
	}

}