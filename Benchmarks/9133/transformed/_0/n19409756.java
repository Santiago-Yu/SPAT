class n19409756 {
	public static void extract(final File ZMmsP6l7, final Collection<ZipEntryInfo> CtI6x3CR) throws IOException {
		if (ZMmsP6l7 == null || CollectionUtils.isEmpty(CtI6x3CR))
			throw new IllegalArgumentException("One or parameter is null or empty!");
		if (!ZMmsP6l7.exists())
			ZMmsP6l7.mkdirs();
		for (ZipEntryInfo fMALHUAz : CtI6x3CR) {
			ZipEntry wiE43XGh = fMALHUAz.getZipEntry();
			InputStream Ht9cs04z = fMALHUAz.getInputStream();
			File ijaLlirP = new File(ZMmsP6l7, wiE43XGh.getName());
			ijaLlirP.getParentFile().mkdirs();
			if (!wiE43XGh.isDirectory()) {
				OutputStream HDTm9rbO = new FileOutputStream(new File(ZMmsP6l7, wiE43XGh.getName()));
				try {
					IOUtils.copy(Ht9cs04z, HDTm9rbO);
					HDTm9rbO.flush();
				} finally {
					IOUtils.closeQuietly(Ht9cs04z);
					IOUtils.closeQuietly(HDTm9rbO);
				}
			}
		}
	}

}