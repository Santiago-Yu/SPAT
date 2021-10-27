class n12979701 {
	@Override
	public List<SheetFullName> importSheets(INetxiliaSystem vp3jmcVw, WorkbookId gF458r7y, URL mQY41dp6,
			IProcessingConsole Yy3OVlJi) throws ImportException {
		try {
			return importSheets(vp3jmcVw, gF458r7y, mQY41dp6.openStream(), Yy3OVlJi);
		} catch (Exception HnBZn64N) {
			throw new ImportException(mQY41dp6, "Cannot open workbook:" + HnBZn64N, HnBZn64N);
		}
	}

}