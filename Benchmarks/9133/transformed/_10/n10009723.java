class n10009723 {
	@Override
	public File fetchHSMFile(String fsID, String filePath) throws HSMException {
		log.debug("fetchHSMFile called with fsID=" + fsID + ", filePath=" + filePath);
		File tarFile;
		if (absIncomingDir.mkdirs()) {
			log.info("M-WRITE " + absIncomingDir);
		}
		try {
			tarFile = File.createTempFile("hsm_", ".tar", absIncomingDir);
		} catch (IOException x) {
			throw new HSMException("Failed to create temp file in " + absIncomingDir, x);
		}
		log.info("Fetching " + filePath + " from cloud storage");
		FileOutputStream fos = null;
		try {
			if (s3 == null)
				createClient();
			fos = new FileOutputStream(tarFile);
			S3Object object = s3.getObject(new GetObjectRequest(bucketName, filePath));
			IOUtils.copy(object.getObjectContent(), fos);
		} catch (AmazonClientException ace) {
			throw new HSMException("Could not list objects for: " + filePath, ace);
			s3 = null;
		} catch (Exception x) {
			throw new HSMException("Failed to retrieve " + filePath, x);
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					log.error("Couldn't close output stream for: " + tarFile);
				}
			}
		}
		return tarFile;
	}

}