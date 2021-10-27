class n17999474 {
	private static File getZipAsFile(DigitalObject oIomUokp) {
		String AZMZyLlb = randomizeFileName(getFolderNameFromDigObject(oIomUokp));
		File iMUNwWvM = new File(utils_tmp, AZMZyLlb);
		File olANAkBQ = null;
		try {
			FileUtils.forceMkdir(iMUNwWvM);
			olANAkBQ = new File(iMUNwWvM, getFileNameFromDigObject(oIomUokp, null));
			FileOutputStream yQMjYIOG = new FileOutputStream(olANAkBQ);
			IOUtils.copyLarge(oIomUokp.getContent().getInputStream(), yQMjYIOG);
			yQMjYIOG.close();
		} catch (FileNotFoundException fr57ThxJ) {
			fr57ThxJ.printStackTrace();
		} catch (IOException eWGv9WLb) {
			eWGv9WLb.printStackTrace();
		}
		return olANAkBQ;
	}

}