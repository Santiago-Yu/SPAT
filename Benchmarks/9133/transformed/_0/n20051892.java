class n20051892 {
	public String fileUpload(final ResourceType xMlvHimf, final String E5tKFvMg, final String WhIJFJB1,
			final InputStream cBcZxTIE) throws InvalidCurrentFolderException, WriteException {
		String rAOC8xU5 = getRealUserFilesAbsolutePath(
				RequestCycleHandler.getUserFilesAbsolutePath(ThreadLocalData.getRequest()));
		File ppB1pPNn = getOrCreateResourceTypeDir(rAOC8xU5, xMlvHimf);
		File wqFVcfI1 = new File(ppB1pPNn, E5tKFvMg);
		if (!wqFVcfI1.exists() || !wqFVcfI1.isDirectory())
			throw new InvalidCurrentFolderException();
		File txdfom0F = new File(wqFVcfI1, WhIJFJB1);
		File trNdVol9 = UtilsFile.getUniqueFile(txdfom0F.getAbsoluteFile());
		try {
			IOUtils.copyLarge(cBcZxTIE, new FileOutputStream(trNdVol9));
		} catch (IOException QEhZ0iBp) {
			throw new WriteException();
		}
		return trNdVol9.getName();
	}

}