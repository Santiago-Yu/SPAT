class n7109222 {
	public static void zipMapBos(DitaBoundedObjectSet mapBos, File outputZipFile, MapBosProcessorOptions options)
			throws Exception {
		log.debug("Determining zip file organization...");
		BosVisitor visitor = new DxpFileOrganizingBosVisitor();
		visitor.visit(mapBos);
		if (!options.isQuiet())
			log.info("Creating DXP package \"" + outputZipFile.getAbsolutePath() + "\"...");
		OutputStream outStream = new FileOutputStream(outputZipFile);
		ZipEntry entry = null;
		ZipOutputStream zipOutStream = new ZipOutputStream(outStream);
		URI baseUri = null;
		URI rootMapUri = mapBos.getRoot().getEffectiveUri();
		Set<String> dirs = new HashSet<String>();
		try {
			baseUri = AddressingUtil.getParent(rootMapUri);
		} catch (URISyntaxException e) {
			throw new BosException("URI syntax exception getting parent URI: " + e.getMessage());
		}
		if (!options.isQuiet())
			log.info("Constructing DXP package...");
		for (BosMember member : mapBos.getMembers()) {
			if (!options.isQuiet())
				log.info("Adding member " + member + " to zip...");
			URI relativeUri = baseUri.relativize(member.getEffectiveUri());
			File temp = new File(relativeUri.getPath());
			String parentPath = temp.getParent();
			if (parentPath != null && !"".equals(parentPath) && !parentPath.endsWith("/")) {
				parentPath += "/";
			}
			log.debug("parentPath=\"" + parentPath + "\"");
			if (!"".equals(parentPath) && parentPath != null && !dirs.contains(parentPath)) {
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