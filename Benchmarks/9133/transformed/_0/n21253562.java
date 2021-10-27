class n21253562 {
	@Override
	public void fileUpload(UploadEvent lq8NiM1W) {
		FileOutputStream KNcG5dnJ = null;
		try {
			tmpUpload = File.createTempFile("projectImport", ".xml");
			KNcG5dnJ = new FileOutputStream(tmpUpload);
			IOUtils.copy(lq8NiM1W.getInputStream(), KNcG5dnJ);
			panel.setGeneralMessage("Project file " + lq8NiM1W.getFileName() + " uploaded and ready for import.");
		} catch (Exception rflJxguq) {
			panel.setGeneralMessage("Could not upload file: " + rflJxguq);
		} finally {
			if (KNcG5dnJ != null) {
				IOUtils.closeQuietly(KNcG5dnJ);
			}
		}
	}

}