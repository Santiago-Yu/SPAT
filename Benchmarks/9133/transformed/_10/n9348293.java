class n9348293 {
	public Image storeImage(String title, String pathToImage, Map<String, Object> additionalProperties) {
		File imageFile = new File(pathToImage);
		File collectionFolder = ProjectManager.getInstance()
				.getFolder(PropertyHandler.getInstance().getProperty("_default_collection_name"));
		String filename = "";
		File copiedImageFile;
		String format = "";
		while (true) {
			filename = "image" + UUID.randomUUID().hashCode();
			if (!DbEntryProvider.INSTANCE.idExists(filename)) {
				Path path = new Path(pathToImage);
				format = path.getFileExtension();
				copiedImageFile = new File(
						collectionFolder.getAbsolutePath() + File.separator + filename + "." + format);
				if (!copiedImageFile.exists())
					break;
			}
		}
		BufferedInputStream in = null;
		try {
			copiedImageFile.createNewFile();
		} catch (IOException e1) {
			ExceptionHandlingService.INSTANCE.handleException(e1);
			return null;
		}
		BufferedOutputStream out = null;
		Image image = new ImageImpl();
		try {
			in = new BufferedInputStream(new FileInputStream(imageFile), 4096);
			out = new BufferedOutputStream(new FileOutputStream(copiedImageFile), 4096);
			int c;
			while ((c = in.read()) != -1)
				out.write(c);
			in.close();
			out.close();
		} catch (FileNotFoundException e) {
			ExceptionHandlingService.INSTANCE.handleException(e);
			return null;
		} catch (IOException e) {
			ExceptionHandlingService.INSTANCE.handleException(e);
			return null;
		}
		image.setId(filename);
		image.setFormat(format);
		image.setEntryDate(new Date());
		image.setTitle(title);
		image.setAdditionalProperties(additionalProperties);
		boolean success = DbEntryProvider.INSTANCE.storeNewImage(image);
		if (success)
			return image;
		return null;
	}

}