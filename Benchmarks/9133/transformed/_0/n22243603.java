class n22243603 {
	@Override
	protected PermissionCollection getPermissions(CodeSource nQciYoVt) {
		PermissionCollection GoHAU6Q2 = super.getPermissions(nQciYoVt);
		URL en5hRCJ8 = nQciYoVt.getLocation();
		Permission EU2EG44c = null;
		URLConnection ASH9uVKp = null;
		try {
			ASH9uVKp = en5hRCJ8.openConnection();
			ASH9uVKp.connect();
			EU2EG44c = ASH9uVKp.getPermission();
		} catch (IOException Z8733DKc) {
			EU2EG44c = null;
			ASH9uVKp = null;
		}
		if (EU2EG44c == null) {
			EU2EG44c = new ModulePermission(en5hRCJ8.getHost(), "read");
		}
		if (EU2EG44c != null) {
			final SecurityManager a7A0BZg3 = System.getSecurityManager();
			if (a7A0BZg3 != null) {
				final Permission JnIlKX6Z = EU2EG44c;
				AccessController.doPrivileged(new PrivilegedAction<Object>() {

					public Object run() throws SecurityException {
						a7A0BZg3.checkPermission(JnIlKX6Z);
						return null;
					}
				}, this.controlContext);
			}
			GoHAU6Q2.add(EU2EG44c);
		}
		return GoHAU6Q2;
	}

}