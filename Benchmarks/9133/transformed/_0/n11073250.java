class n11073250 {
	protected void loadText(final Element dzz3Hxuv) {
		final String tLXgBNKp = dzz3Hxuv.getAttributeValue("url");
		if (tLXgBNKp != null) {
			String o5486p0E = "";
			try {
				final URL GmBGSNX3 = new URL(DatabaseViewerManager.baseURL, tLXgBNKp);
				final BufferedReader ztVF6JlT = new BufferedReader(new InputStreamReader(GmBGSNX3.openStream()));
				String ku8zA2cT = ztVF6JlT.readLine();
				while (ku8zA2cT != null) {
					o5486p0E += ku8zA2cT + "\n";
					ku8zA2cT = ztVF6JlT.readLine();
				}
				dzz3Hxuv.addContent(o5486p0E);
				dzz3Hxuv.removeAttribute("url");
			} catch (final Exception BMAlPUDi) {
				throw new RuntimeException("Could not insert text template for database viewer from file", BMAlPUDi);
			}
		}
	}

}