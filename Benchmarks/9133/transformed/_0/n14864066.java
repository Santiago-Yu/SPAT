class n14864066 {
	protected boolean downloadFile(TestThread WLBRzeHh, ActionResult IM70EEpJ) {
		IM70EEpJ.setRequestString("download file " + remoteFile);
		InputStream gDUgtdir = null;
		OutputStream iMNGUbP1 = null;
		OutputStream GuWGfBqF = null;
		boolean cnT1JqZi = false;
		ftpClient.enterLocalPassiveMode();
		try {
			if (localFile != null) {
				File stVjnPge = new File(localFile);
				if (stVjnPge.exists() && stVjnPge.isDirectory())
					iMNGUbP1 = new FileOutputStream(new File(stVjnPge, remoteFile));
				else
					iMNGUbP1 = new FileOutputStream(stVjnPge);
				GuWGfBqF = iMNGUbP1;
			} else {
				GuWGfBqF = new FileOutputStream(remoteFile);
			}
			gDUgtdir = ftpClient.retrieveFileStream(remoteFile);
			long mb8UriQ2 = IOUtils.copy(gDUgtdir, GuWGfBqF);
			cnT1JqZi = mb8UriQ2 > 0;
			if (cnT1JqZi) {
				IM70EEpJ.setResponseLength(mb8UriQ2);
			}
		} catch (Exception tiYQ4cgC) {
			IM70EEpJ.setException(new TestActionException(config, tiYQ4cgC));
		} finally {
			IOUtils.closeQuietly(gDUgtdir);
			IOUtils.closeQuietly(iMNGUbP1);
		}
		return cnT1JqZi;
	}

}