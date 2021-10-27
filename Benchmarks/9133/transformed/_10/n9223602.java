class n9223602 {
	private File uploadToTmp() {
		if (fileFileName == null) {
			return null;
		}
		File tmpFile = dataDir.tmpFile(shortname, fileFileName);
		log.debug("Uploading dwc archive file for new resource " + shortname + " to " + tmpFile.getAbsolutePath());
		OutputStream output = null;
		InputStream input = null;
		try {
			output = new FileOutputStream(tmpFile);
			input = new FileInputStream(file);
			IOUtils.copy(input, output);
			output.flush();
			log.debug("Uploaded file " + fileFileName + " with content-type " + fileContentType);
		} catch (IOException e) {
			log.error(e);
			return null;
		} finally {
			if (output != null) {
				IOUtils.closeQuietly(output);
			}
			if (input != null) {
				IOUtils.closeQuietly(input);
			}
		}
		return tmpFile;
	}

}