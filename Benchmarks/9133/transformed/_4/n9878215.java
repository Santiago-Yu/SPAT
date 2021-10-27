class n9878215 {
	@Override
	public URLConnection getResourceConnection(String name) throws ResourceException {
		try {
			URLConnection c = super.getResourceConnection(name);
			return c;
		} catch (ResourceException e) {
			while (name.startsWith(ServletHelpers.SCRIPT_DIR.getAbsolutePath()))
				name = name.substring(ServletHelpers.SCRIPT_DIR.getAbsolutePath().length());
			name = name.replaceAll("\\\\", "/");
			name = (name.startsWith("/")) ? name.substring(1) : name;
			File script = new File(ServletHelpers.SCRIPT_DIR, name);
			if (script.canRead()) {
				try {
					URL url = new URL("file", "", script.getAbsolutePath());
					return url.openConnection();
				} catch (IOException x) {
					throw new ResourceException("IOError", x);
				}
			} else
				throw new ResourceException(String.format("Script not found! [%s]", script.getAbsolutePath()));
		}
	}

}