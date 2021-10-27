class n12923790 {
	private void insertContent(ImageData imageData, Element element) {
		URL url = getClass().getResource(imageData.getURL());
		try {
			File imageFileRead = new File(url.toURI());
			String imageFileWritePath = "htmlReportFiles" + "/" + imageData.getURL();
			FileInputStream inputStream = new FileInputStream(imageFileRead);
			File imageFileWrite = new File(imageFileWritePath);
			String[] filePathTokens = imageFileWritePath.split("/");
			int i = 1;
			String directoryPathCreate = filePathTokens[0];
			while (i < filePathTokens.length - 1) {
				directoryPathCreate = directoryPathCreate + "/" + filePathTokens[i];
				i++;
			}
			File fileDirectoryPathCreate = new File(directoryPathCreate);
			FileOutputStream fileOutputStream = new FileOutputStream(imageFileWrite);
			if (!fileDirectoryPathCreate.exists()) {
				boolean successfulFileCreation = fileDirectoryPathCreate.mkdirs();
				if (successfulFileCreation == false) {
					throw new ExplanationException("Unable to create folders in path " + directoryPathCreate);
				}
			}
			int readDataNumberOfBytes = 0;
			byte[] data = new byte[1024];
			while (readDataNumberOfBytes != -1) {
				readDataNumberOfBytes = inputStream.read(data, 0, data.length);
				if (readDataNumberOfBytes != -1) {
					fileOutputStream.write(data, 0, readDataNumberOfBytes);
				}
			}
			inputStream.close();
			fileOutputStream.close();
		} catch (Exception ex) {
			throw new ExplanationException(ex.getMessage());
		}
		String caption = imageData.getCaption();
		Element imageElement = element.addElement("img");
		if (imageData.getURL().charAt(0) != '/')
			imageElement.addAttribute("src", "htmlReportFiles" + "/" + imageData.getURL());
		else
			imageElement.addAttribute("src", "htmlReportFiles" + imageData.getURL());
		imageElement.addAttribute("alt", "image not available");
		if (caption != null) {
			element.addElement("br");
			element.addText(caption);
		}
	}

}