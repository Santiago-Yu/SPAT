class n254039 {
	protected void doDownload(S3Bucket bucket, S3Object s3object) throws Exception {
		String key = s3object.getKey();
		key = trimPrefix(key);
		String[] path = key.split("/");
		String fileName = path[path.length - 1];
		String dirPath = "";
		for (int i = 0; i < path.length - 1; i++) {
			dirPath += path[i] + "/";
		}
		File outputDir = new File(downloadFileOutputDir + "/" + dirPath);
		if (outputDir.exists() == false) {
			outputDir.mkdirs();
		}
		long size = s3object.getContentLength();
		File outputFile = new File(outputDir, fileName);
		long startTime = System.currentTimeMillis();
		if (outputFile.exists() && outputFile.length() == size) {
			return;
		}
		log.info("Download start.S3 file=" + s3object.getKey() + " local file=" + outputFile.getAbsolutePath());
		S3Object dataObject = null;
		FileOutputStream fout = null;
		try {
			dataObject = s3.getObject(bucket, s3object.getKey());
			fout = new FileOutputStream(outputFile);
			InputStream is = dataObject.getDataInputStream();
			IOUtils.copyStream(is, fout);
			downloadedFileList.add(key);
			long downloadTime = System.currentTimeMillis() - startTime;
			log.info("Download complete.Estimete time=" + downloadTime + "ms " + IOUtils.toBPSText(downloadTime, size));
		} catch (Exception e) {
			log.error("Download fail. s3 file=" + key, e);
			outputFile.delete();
			throw e;
		} finally {
			IOUtils.closeNoException(fout);
			if (dataObject != null) {
				dataObject.closeDataInputStream();
			}
		}
	}

}