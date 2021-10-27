class n17999474 {
	private static File getZipAsFile(DigitalObject digOb) {
		String folderName = randomizeFileName(getFolderNameFromDigObject(digOb));
		File zip = null;
		File tmpFolder = new File(utils_tmp, folderName);
		try {
			FileUtils.forceMkdir(tmpFolder);
			zip = new File(tmpFolder, getFileNameFromDigObject(digOb, null));
			FileOutputStream out = new FileOutputStream(zip);
			IOUtils.copyLarge(digOb.getContent().getInputStream(), out);
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return zip;
	}

}