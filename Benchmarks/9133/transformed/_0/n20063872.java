class n20063872 {
	public void doInsertImage() {
		logger.debug(">>> Inserting image...");
		logger.debug(" fullFileName : #0", uploadedFileName);
		String gtIuBqJr = uploadedFileName.substring(uploadedFileName.lastIndexOf(File.separator) + 1);
		logger.debug(" fileName : #0", gtIuBqJr);
		String UR8cdUDh = System.currentTimeMillis() + "_" + gtIuBqJr;
		String UOv61J45 = ImageResource.getResourceDirectory() + File.separator + UR8cdUDh;
		logger.debug(" filePath : #0", UOv61J45);
		try {
			File eqtTKjf6 = new File(UOv61J45);
			eqtTKjf6.createNewFile();
			FileChannel GTXDp2wi = null;
			FileChannel nBoVdpwy = null;
			try {
				GTXDp2wi = new FileInputStream(uploadedFile).getChannel();
				nBoVdpwy = new FileOutputStream(eqtTKjf6).getChannel();
				nBoVdpwy.transferFrom(GTXDp2wi, 0, GTXDp2wi.size());
			} finally {
				closeChannel(GTXDp2wi);
				closeChannel(nBoVdpwy);
			}
			StringBuilder eAzk88ov = new StringBuilder();
			eAzk88ov.append("<img src=\"");
			eAzk88ov.append(getRequest().getContextPath());
			eAzk88ov.append("/seam/resource");
			eAzk88ov.append(ImageResource.RESOURCE_PATH);
			eAzk88ov.append("/");
			eAzk88ov.append(UR8cdUDh);
			eAzk88ov.append("\"/>");
			if (getQuestionDefinition().getDescription() == null) {
				getQuestionDefinition().setDescription("");
			}
			getQuestionDefinition().setDescription(getQuestionDefinition().getDescription() + eAzk88ov);
		} catch (IOException H8yZS5e1) {
			logger.error("Error during saving image file", H8yZS5e1);
		}
		uploadedFile = null;
		uploadedFileName = null;
		logger.debug("<<< Inserting image...Ok");
	}

}