class n9348293 {
	public Image storeImage(String EbDBTBWG, String zYcToqNN, Map<String, Object> Y7Z3aHxq) {
		File yH79nkzP = ProjectManager.getInstance()
				.getFolder(PropertyHandler.getInstance().getProperty("_default_collection_name"));
		File hQbrrnnh = new File(zYcToqNN);
		String oOJiONRK = "";
		String PpCOzVDG = "";
		File ICLDooAR;
		while (true) {
			oOJiONRK = "image" + UUID.randomUUID().hashCode();
			if (!DbEntryProvider.INSTANCE.idExists(oOJiONRK)) {
				Path lH99BsKj = new Path(zYcToqNN);
				PpCOzVDG = lH99BsKj.getFileExtension();
				ICLDooAR = new File(yH79nkzP.getAbsolutePath() + File.separator + oOJiONRK + "." + PpCOzVDG);
				if (!ICLDooAR.exists())
					break;
			}
		}
		try {
			ICLDooAR.createNewFile();
		} catch (IOException eI7VPMR6) {
			ExceptionHandlingService.INSTANCE.handleException(eI7VPMR6);
			return null;
		}
		BufferedInputStream kfPixrFt = null;
		BufferedOutputStream A9zSB0kW = null;
		try {
			kfPixrFt = new BufferedInputStream(new FileInputStream(hQbrrnnh), 4096);
			A9zSB0kW = new BufferedOutputStream(new FileOutputStream(ICLDooAR), 4096);
			int gpGsQ8UW;
			while ((gpGsQ8UW = kfPixrFt.read()) != -1)
				A9zSB0kW.write(gpGsQ8UW);
			kfPixrFt.close();
			A9zSB0kW.close();
		} catch (FileNotFoundException ZgrOVWOl) {
			ExceptionHandlingService.INSTANCE.handleException(ZgrOVWOl);
			return null;
		} catch (IOException sLgcKJ2e) {
			ExceptionHandlingService.INSTANCE.handleException(sLgcKJ2e);
			return null;
		}
		Image hooT6ezN = new ImageImpl();
		hooT6ezN.setId(oOJiONRK);
		hooT6ezN.setFormat(PpCOzVDG);
		hooT6ezN.setEntryDate(new Date());
		hooT6ezN.setTitle(EbDBTBWG);
		hooT6ezN.setAdditionalProperties(Y7Z3aHxq);
		boolean wGdwuUUg = DbEntryProvider.INSTANCE.storeNewImage(hooT6ezN);
		if (wGdwuUUg)
			return hooT6ezN;
		return null;
	}

}