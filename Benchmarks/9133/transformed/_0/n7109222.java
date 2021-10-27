class n7109222 {
	public static void zipMapBos(DitaBoundedObjectSet lZBacBGM, File OTYgbwgV, MapBosProcessorOptions UmJ2OH0b)
			throws Exception {
		log.debug("Determining zip file organization...");
		BosVisitor J3OtwQ07 = new DxpFileOrganizingBosVisitor();
		J3OtwQ07.visit(lZBacBGM);
		if (!UmJ2OH0b.isQuiet())
			log.info("Creating DXP package \"" + OTYgbwgV.getAbsolutePath() + "\"...");
		OutputStream TR3i2v8l = new FileOutputStream(OTYgbwgV);
		ZipOutputStream ku9D3oRT = new ZipOutputStream(TR3i2v8l);
		ZipEntry jrLZDgCb = null;
		URI EKa57vYT = lZBacBGM.getRoot().getEffectiveUri();
		URI bB6UCHX0 = null;
		try {
			bB6UCHX0 = AddressingUtil.getParent(EKa57vYT);
		} catch (URISyntaxException xaMQOFZI) {
			throw new BosException("URI syntax exception getting parent URI: " + xaMQOFZI.getMessage());
		}
		Set<String> M40Kp1vU = new HashSet<String>();
		if (!UmJ2OH0b.isQuiet())
			log.info("Constructing DXP package...");
		for (BosMember QYHg8kS4 : lZBacBGM.getMembers()) {
			if (!UmJ2OH0b.isQuiet())
				log.info("Adding member " + QYHg8kS4 + " to zip...");
			URI l8CptVgr = bB6UCHX0.relativize(QYHg8kS4.getEffectiveUri());
			File XpIIVwTA = new File(l8CptVgr.getPath());
			String kmIpOj1C = XpIIVwTA.getParent();
			if (kmIpOj1C != null && !"".equals(kmIpOj1C) && !kmIpOj1C.endsWith("/")) {
				kmIpOj1C += "/";
			}
			log.debug("parentPath=\"" + kmIpOj1C + "\"");
			if (!"".equals(kmIpOj1C) && kmIpOj1C != null && !M40Kp1vU.contains(kmIpOj1C)) {
				jrLZDgCb = new ZipEntry(kmIpOj1C);
				ku9D3oRT.putNextEntry(jrLZDgCb);
				ku9D3oRT.closeEntry();
				M40Kp1vU.add(kmIpOj1C);
			}
			jrLZDgCb = new ZipEntry(l8CptVgr.getPath());
			ku9D3oRT.putNextEntry(jrLZDgCb);
			IOUtils.copy(QYHg8kS4.getInputStream(), ku9D3oRT);
			ku9D3oRT.closeEntry();
		}
		ku9D3oRT.close();
		if (!UmJ2OH0b.isQuiet())
			log.info("DXP package \"" + OTYgbwgV.getAbsolutePath() + "\" created.");
	}

}