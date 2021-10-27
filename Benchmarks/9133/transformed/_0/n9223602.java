class n9223602 {
	private File uploadToTmp() {
		if (fileFileName == null) {
			return null;
		}
		File PouqdSHZ = dataDir.tmpFile(shortname, fileFileName);
		log.debug("Uploading dwc archive file for new resource " + shortname + " to " + PouqdSHZ.getAbsolutePath());
		InputStream aJ0g9HWg = null;
		OutputStream ntt1UmIC = null;
		try {
			aJ0g9HWg = new FileInputStream(file);
			ntt1UmIC = new FileOutputStream(PouqdSHZ);
			IOUtils.copy(aJ0g9HWg, ntt1UmIC);
			ntt1UmIC.flush();
			log.debug("Uploaded file " + fileFileName + " with content-type " + fileContentType);
		} catch (IOException dMMozN4e) {
			log.error(dMMozN4e);
			return null;
		} finally {
			if (ntt1UmIC != null) {
				IOUtils.closeQuietly(ntt1UmIC);
			}
			if (aJ0g9HWg != null) {
				IOUtils.closeQuietly(aJ0g9HWg);
			}
		}
		return PouqdSHZ;
	}

}