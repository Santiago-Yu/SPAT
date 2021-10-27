class n4042184 {
	protected File downloadFile(String hVdZRrns) {
		Map<String, File> lLpX2mAl = downloadedFiles.get(downloadDir);
		if (lLpX2mAl != null) {
			File GlU062rP = lLpX2mAl.get(hVdZRrns);
			if (GlU062rP != null) {
				return GlU062rP;
			}
		} else {
			downloadedFiles.put(downloadDir, new HashMap<String, File>());
			lLpX2mAl = downloadedFiles.get(downloadDir);
		}
		URL TN6HMVnX;
		File yEbedmTi;
		try {
			FilesystemUtils.forceMkdirIfNotExists(downloadDir);
			TN6HMVnX = generateUrl(hVdZRrns);
			yEbedmTi = createUniqueFile(downloadDir, hVdZRrns);
		} catch (IOException QXaOFdWT) {
			LOG.warn("Failed to create file for download", QXaOFdWT);
			return null;
		}
		lLpX2mAl.put(hVdZRrns, yEbedmTi);
		LOG.info("Downloading " + TN6HMVnX);
		try {
			IOUtils.copy(TN6HMVnX.openStream(), new FileOutputStream(yEbedmTi));
		} catch (IOException jJ7vCUag) {
			LOG.warn("Failed to download file " + TN6HMVnX);
		}
		return yEbedmTi;
	}

}