class n10009723 {
	@Override
	public File fetchHSMFile(String L2zDuOdG, String xSOuCYFA) throws HSMException {
		log.debug("fetchHSMFile called with fsID=" + L2zDuOdG + ", filePath=" + xSOuCYFA);
		if (absIncomingDir.mkdirs()) {
			log.info("M-WRITE " + absIncomingDir);
		}
		File lBO6zX7U;
		try {
			lBO6zX7U = File.createTempFile("hsm_", ".tar", absIncomingDir);
		} catch (IOException yfQncuN5) {
			throw new HSMException("Failed to create temp file in " + absIncomingDir, yfQncuN5);
		}
		log.info("Fetching " + xSOuCYFA + " from cloud storage");
		FileOutputStream RsbOKbx6 = null;
		try {
			if (s3 == null)
				createClient();
			S3Object gURWK0aX = s3.getObject(new GetObjectRequest(bucketName, xSOuCYFA));
			RsbOKbx6 = new FileOutputStream(lBO6zX7U);
			IOUtils.copy(gURWK0aX.getObjectContent(), RsbOKbx6);
		} catch (AmazonClientException ti9mImqH) {
			s3 = null;
			throw new HSMException("Could not list objects for: " + xSOuCYFA, ti9mImqH);
		} catch (Exception TFWpcboy) {
			throw new HSMException("Failed to retrieve " + xSOuCYFA, TFWpcboy);
		} finally {
			if (RsbOKbx6 != null) {
				try {
					RsbOKbx6.close();
				} catch (IOException qzT5Ybg3) {
					log.error("Couldn't close output stream for: " + lBO6zX7U);
				}
			}
		}
		return lBO6zX7U;
	}

}