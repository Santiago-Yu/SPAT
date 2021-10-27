class n9878215 {
	@Override
	public URLConnection getResourceConnection(String tdkRhUZq) throws ResourceException {
		try {
			URLConnection vFy9bhYy = super.getResourceConnection(tdkRhUZq);
			return vFy9bhYy;
		} catch (ResourceException giTtxLNG) {
			while (tdkRhUZq.startsWith(ServletHelpers.SCRIPT_DIR.getAbsolutePath()))
				tdkRhUZq = tdkRhUZq.substring(ServletHelpers.SCRIPT_DIR.getAbsolutePath().length());
			tdkRhUZq = tdkRhUZq.replaceAll("\\\\", "/");
			if (tdkRhUZq.startsWith("/"))
				tdkRhUZq = tdkRhUZq.substring(1);
			File vjxk592X = new File(ServletHelpers.SCRIPT_DIR, tdkRhUZq);
			if (vjxk592X.canRead()) {
				try {
					URL joz6WqjI = new URL("file", "", vjxk592X.getAbsolutePath());
					return joz6WqjI.openConnection();
				} catch (IOException FoUvEOWH) {
					throw new ResourceException("IOError", FoUvEOWH);
				}
			} else
				throw new ResourceException(String.format("Script not found! [%s]", vjxk592X.getAbsolutePath()));
		}
	}

}