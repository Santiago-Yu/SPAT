class n21923044 {
	private String copy(PluginVersionDetail usePluginVersion, File runtimeRepository) {
		try {
			File tmpFile = null;
			try {
				tmpFile = File.createTempFile("tmpPlugin_", ".zip");
				tmpFile.deleteOnExit();
				URL url = new URL(usePluginVersion.getUri());
				String destFilename = new File(url.getFile()).getName();
				InputStream in = null;
				File destFile = new File(runtimeRepository, destFilename);
				int bytesDownload = 0;
				FileOutputStream out = null;
				long endTime = 0;
				long startTime = 0;
				String downloadSpeedInfo = null;
				try {
					URLConnection urlConnection = url.openConnection();
					bytesDownload = urlConnection.getContentLength();
					in = urlConnection.getInputStream();
					out = new FileOutputStream(tmpFile);
					startTime = System.currentTimeMillis();
					IOUtils.copy(in, out);
					endTime = System.currentTimeMillis();
				} finally {
					if (out != null) {
						out.close();
					}
					if (in != null) {
						in.close();
					}
				}
				long downloadSpeed = 0;
				if ((endTime - startTime) > 0) {
					downloadSpeed = 1000L * bytesDownload / (endTime - startTime);
				}
				String tmpFileMessageDigest = getMessageDigest(tmpFile.toURI().toURL()).getValue();
				if (downloadSpeed == 0) {
					downloadSpeedInfo = "? B/s";
				} else if (downloadSpeed < 1000) {
					downloadSpeedInfo = downloadSpeed + " B/s";
				} else if (downloadSpeed < 1000000) {
					downloadSpeedInfo = downloadSpeed / 1000 + " KB/s";
				} else if (downloadSpeed < 1000000000) {
					downloadSpeedInfo = downloadSpeed / 1000000 + " MB/s";
				} else {
					downloadSpeedInfo = downloadSpeed / 1000000000 + " GB/s";
				}
				if (!tmpFileMessageDigest.equals(usePluginVersion.getMessageDigest().getValue())) {
					throw new RuntimeException(
							"Downloaded file: " + usePluginVersion.getUri() + " does not have required message digest: "
									+ usePluginVersion.getMessageDigest().getValue());
				}
				if (!isNoop()) {
					FileUtils.copyFile(tmpFile, destFile);
				}
				return bytesDownload + " Bytes " + downloadSpeedInfo;
			} finally {
				if (tmpFile != null) {
					tmpFile.delete();
				}
			}
		} catch (Exception ex) {
			throw new RuntimeException("Could not download " + usePluginVersion.getUri() + " to " + runtimeRepository,
					ex);
		}
	}

}