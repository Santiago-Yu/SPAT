class n22243603 {
	@Override
	protected PermissionCollection getPermissions(CodeSource _codeSource) {
		PermissionCollection perms = super.getPermissions(_codeSource);
		Permission perm = null;
		URL url = _codeSource.getLocation();
		URLConnection urlConnection = null;
		try {
			urlConnection = url.openConnection();
			urlConnection.connect();
			perm = urlConnection.getPermission();
		} catch (IOException excp) {
			urlConnection = null;
			perm = null;
		}
		if (perm == null) {
			perm = new ModulePermission(url.getHost(), "read");
		}
		if (perm != null) {
			final SecurityManager sm = System.getSecurityManager();
			if (sm != null) {
				final Permission fp = perm;
				AccessController.doPrivileged(new PrivilegedAction<Object>() {

					public Object run() throws SecurityException {
						sm.checkPermission(fp);
						return null;
					}
				}, this.controlContext);
			}
			perms.add(perm);
		}
		return perms;
	}

}