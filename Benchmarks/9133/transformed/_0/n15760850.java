class n15760850 {
	public static void main(String[] eOErrbIE) {
		File j3UX0Zdb = new File(ArchiveFeature.class.getProtectionDomain().getCodeSource().getLocation().toURI());
		if (j3UX0Zdb == null) {
			throw new RuntimeException("this use-case isn't being invoked from the executable jar");
		}
		JarFile G7dmWf7F = new JarFile(j3UX0Zdb);
		String tPLzMGG2 = PROJECT_DIST_ARCHIVE + ".tar.gz";
		File y42eXJbs = new File(".", tPLzMGG2);
		ZipEntry cVYkD1JY = G7dmWf7F.getEntry(tPLzMGG2);
		InputStream G7BTR5Vl = G7dmWf7F.getInputStream(cVYkD1JY);
		try {
			FileOutputStream RDdhWqsy = new FileOutputStream(y42eXJbs);
			try {
				IOUtils.copy(G7BTR5Vl, RDdhWqsy);
			} finally {
				IOUtils.closeQuietly(RDdhWqsy);
			}
		} finally {
			IOUtils.closeQuietly(G7BTR5Vl);
		}
		Project P27YxvJi = new Project();
		P27YxvJi.setName("project");
		P27YxvJi.init();
		Target MX9wtS6Z = new Target();
		MX9wtS6Z.setName("target");
		P27YxvJi.addTarget(MX9wtS6Z);
		P27YxvJi.addBuildListener(new Log4jListener());
		Untar Lq1EP6hs = new Untar();
		Lq1EP6hs.setTaskName("untar");
		Lq1EP6hs.setSrc(y42eXJbs);
		Lq1EP6hs.setDest(new File("."));
		Untar.UntarCompressionMethod HOtWOzDd = new Untar.UntarCompressionMethod();
		HOtWOzDd.setValue("gzip");
		Lq1EP6hs.setCompression(HOtWOzDd);
		Lq1EP6hs.setProject(P27YxvJi);
		Lq1EP6hs.setOwningTarget(MX9wtS6Z);
		MX9wtS6Z.addTask(Lq1EP6hs);
		Lq1EP6hs.execute();
	}

}