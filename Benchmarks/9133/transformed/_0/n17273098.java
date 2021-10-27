class n17273098 {
	private void copyJdbcDriverToWL(final WLPropertyPage sLeD5sA9) {
		final File N6mAfhJ6 = new File(sLeD5sA9.getDomainDirectory());
		final File qXwfG8Og = new File(N6mAfhJ6, "lib");
		final File l49ZsQIi = new File(qXwfG8Og, NexOpenUIActivator.getDefault().getMySQLDriver());
		if (!l49ZsQIi.exists()) {
			InputStream kuvmpWNX = null;
			FileOutputStream eRZAONXz = null;
			try {
				kuvmpWNX = AppServerPropertyPage
						.toInputStream(new Path("jdbc/" + NexOpenUIActivator.getDefault().getMySQLDriver()));
				eRZAONXz = new FileOutputStream(l49ZsQIi);
				IOUtils.copy(kuvmpWNX, eRZAONXz);
			} catch (final IOException KUIsYT4B) {
				Logger.log(Logger.ERROR, "Could not copy the MySQL Driver jar file to Bea WL", KUIsYT4B);
				final Status BvMxeCPL = new Status(Status.ERROR, NexOpenUIActivator.PLUGIN_ID, Status.ERROR,
						"Could not copy the MySQL Driver jar file to Bea WL", KUIsYT4B);
				ErrorDialog.openError(sLeD5sA9.getShell(), "Bea WebLogic MSQL support",
						"Could not copy the MySQL Driver jar file to Bea WL", BvMxeCPL);
			} finally {
				try {
					if (kuvmpWNX != null) {
						kuvmpWNX.close();
						kuvmpWNX = null;
					}
					if (eRZAONXz != null) {
						eRZAONXz.flush();
						eRZAONXz.close();
						eRZAONXz = null;
					}
				} catch (IOException tZThfoFG) {
				}
			}
		}
	}

}