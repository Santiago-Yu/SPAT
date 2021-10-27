class n12085127 {
	public final void navigate(final URL cbm5ffej) {
		try {
			EncogLogging.log(EncogLogging.LEVEL_INFO, "Navigating to page:" + cbm5ffej);
			final URLConnection lND8YNoM = cbm5ffej.openConnection();
			final InputStream PiSCLvxQ = lND8YNoM.getInputStream();
			navigate(cbm5ffej, PiSCLvxQ);
			PiSCLvxQ.close();
		} catch (final IOException dEppbLsa) {
			EncogLogging.log(EncogLogging.LEVEL_ERROR, dEppbLsa);
			throw new BrowseError(dEppbLsa);
		}
	}

}