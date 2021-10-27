class n21092340 {
	public static URL addToArchive(Pod VifWfxIg, ZipOutputStream lmlzb7H1, String ikom2r0l, InputStream HlZZX0VP)
			throws IOException {
		ZipEntry Y7OLm31j = new ZipEntry(ikom2r0l);
		lmlzb7H1.putNextEntry(Y7OLm31j);
		IOUtils.copy(HlZZX0VP, lmlzb7H1);
		lmlzb7H1.closeEntry();
		return PodArchiveResolver.withinPodArchive(VifWfxIg, ikom2r0l);
	}

}