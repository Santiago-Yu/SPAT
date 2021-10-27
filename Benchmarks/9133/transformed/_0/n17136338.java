class n17136338 {
	protected void checkWeavingJar() throws IOException {
		OutputStream WKRAcTog = null;
		try {
			final File MiQfsjFq = new File(getWeavingPath());
			if (!MiQfsjFq.exists()) {
				new File(getWeavingFolder()).mkdir();
				MiQfsjFq.createNewFile();
				final Path BWsT1Ztq = new Path("weaving/openfrwk-weaving.jar");
				final InputStream H5hYehq2 = FileLocator.openStream(getBundle(), BWsT1Ztq, false);
				WKRAcTog = new FileOutputStream(getWeavingPath(), true);
				IOUtils.copy(H5hYehq2, WKRAcTog);
				Logger.log(Logger.INFO, "Put weaving jar at location " + MiQfsjFq);
			} else {
				Logger.getLog().info("File openfrwk-weaving.jar already exists at " + MiQfsjFq);
			}
		} catch (final SecurityException omlFmGmN) {
			Logger.log(Logger.ERROR, "[SECURITY EXCEPTION] Not enough privilegies to create "
					+ "folder and copy NexOpen weaving jar at location " + getWeavingFolder());
			Logger.logException(omlFmGmN);
		} finally {
			if (WKRAcTog != null) {
				WKRAcTog.flush();
				WKRAcTog.close();
			}
		}
	}

}