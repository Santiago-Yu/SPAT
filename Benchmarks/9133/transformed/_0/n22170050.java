class n22170050 {
	private void copyTemplates(ProjectPath A2yBZDKr) {
		String n3FjdLS6 = A2yBZDKr.sourceAntPath();
		final String Th1k4crB = projectOperations.getFocusedTopLevelPackage().toString();
		logger.info("Module Name: " + Th1k4crB);
		String cS9x2sKb = A2yBZDKr.canonicalFileSystemPath(projectOperations);
		logger.info("Moving into target Directory: " + cS9x2sKb);
		if (!cS9x2sKb.endsWith("/")) {
			cS9x2sKb += "/";
		}
		if (!fileManager.exists(cS9x2sKb)) {
			fileManager.createDirectory(cS9x2sKb);
		}
		System.out.println("Target Directory: " + A2yBZDKr.sourceAntPath());
		String kwpmcxGd = TemplateUtils.getTemplatePath(getClass(), n3FjdLS6);
		Set<URL> q29TEyKJ = UrlFindingUtils.findMatchingClasspathResources(context.getBundleContext(), kwpmcxGd);
		Assert.notNull(q29TEyKJ, "Could not search bundles for resources for Ant Path '" + kwpmcxGd + "'");
		if (q29TEyKJ.isEmpty()) {
			logger.info("URLS are empty stopping...");
		}
		for (URL Vv1Vfi3U : q29TEyKJ) {
			logger.info("Stepping into " + Vv1Vfi3U.toExternalForm());
			String pv6GjZ16 = Vv1Vfi3U.getPath().substring(Vv1Vfi3U.getPath().lastIndexOf("/") + 1);
			pv6GjZ16 = pv6GjZ16.replace("-template", "");
			String tPbijiQQ = cS9x2sKb + pv6GjZ16;
			logger.info("Handling " + tPbijiQQ);
			if (!fileManager.exists(tPbijiQQ)) {
				try {
					logger.info("Copied file");
					String mwsnates = FileCopyUtils.copyToString(new InputStreamReader(Vv1Vfi3U.openStream()));
					logger.info("TopLevelPackage: " + projectOperations.getFocusedTopLevelPackage());
					logger.info("SegmentPackage: " + A2yBZDKr.canonicalFileSystemPath(projectOperations));
					String aRmwqhPQ = projectOperations.getFocusedTopLevelPackage().toString();
					mwsnates = mwsnates.replace("__TOP_LEVEL_PACKAGE__", aRmwqhPQ);
					mwsnates = mwsnates.replace("__SEGMENT_PACKAGE__", A2yBZDKr.segmentPackage());
					mwsnates = mwsnates.replace("__PROJECT_NAME__", projectOperations.getFocusedProjectName());
					mwsnates = mwsnates.replace("__ENTITY_NAME__", entityName);
					MutableFile VvQnkFeH = fileManager.createFile(tPbijiQQ);
					FileCopyUtils.copy(mwsnates.getBytes(), VvQnkFeH.getOutputStream());
				} catch (IOException Yt9Csfp1) {
					throw new IllegalStateException("Unable to create '" + tPbijiQQ + "'", Yt9Csfp1);
				}
			}
		}
	}

}