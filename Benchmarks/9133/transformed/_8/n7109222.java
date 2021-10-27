class n7109222 {
	public static void zipMapBos(DitaBoundedObjectSet mapBos, File outputZipFile, MapBosProcessorOptions options)
			throws Exception {
		log.debug("Determining zip file organization...");
		BosVisitor visitor = new DxpFileOrganizingBosVisitor();
		visitor.visit(mapBos);
		if (!options.isQuiet())
			log.info("Creating DXP package \"" + outputZipFile.getAbsolutePath() + "\"...");
		OutputStream outStream = new FileOutputStream(outputZipFile);
		ZipOutputStream zipOutStream = new ZipOutputStream(outStream);
		ZipEntry entry = null;
		URI rootMapUri = mapBos.getRoot().getEffectiveUri();
		URI baseUri = null;
		try {
			baseUri = AddressingUtil.getParent(rootMapUri);
		} catch (URISyntaxException e) {
			throw new BosException("URI syntax exception getting parent URI: " + e.getMessage());
		}
		Set<String> dirs = new HashSet<String>();
		if (!options.isQuiet())
			log.info("Constructing DXP package...");
		for (BosMember member : mapBos.getMembers()) {
			if (!options.isQuiet())
				log.info("Adding member " + member + " to zip...");
			URI relativeUri = baseUri.relativize(member.getEffectiveUri());
			File temp = new File(relativeUri.getPath());
			String parentPath = temp.getParent();
			boolean eAz1W8dz = parentPath != null && !"".equals(parentPath);
			boolean EC8oj7E6 = parentPath != null;
			if (eAz1W8dz && !parentPath.endsWith("/")) {
				parentPath += "/";
			}
			log.debug("parentPath=\"" + parentPath + "\"");
			boolean dmElfTgN = !"".equals(parentPath) && parentPath != null;
			boolean wBzFgee3 = parentPath != null;
			if (dmElfTgN && !dirs.contains(parentPath)) {
				entry = new ZipEntry(parentPath);
				zipOutStream.putNextEntry(entry);
				zipOutStream.closeEntry();
				dirs.add(parentPath);
			}
			entry = new ZipEntry(relativeUri.getPath());
			zipOutStream.putNextEntry(entry);
			IOUtils.copy(member.getInputStream(), zipOutStream);
			zipOutStream.closeEntry();
		}
		zipOutStream.close();
		if (!options.isQuiet())
			log.info("DXP package \"" + outputZipFile.getAbsolutePath() + "\" created.");
	}

}