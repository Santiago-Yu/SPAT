class n18051587 {
	public static void run(File targetFolder, URL url) throws UpdateException {
		try {
			run(targetFolder, new ZipInputStream(url.openStream()));
		} catch (Exception e) {
			if (!(e instanceof UpdateException))
				throw new UpdateException(e);
			else
				throw (UpdateException) e;
		}
	}

}