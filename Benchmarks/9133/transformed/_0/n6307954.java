class n6307954 {
	@Override
	public List<SheetFullName> importSheets(INetxiliaSystem OjiX2RET, WorkbookId pIGyo9xt, URL uOUr59MG,
			IProcessingConsole cZTaK2uZ) throws ImportException {
		try {
			return importSheets(OjiX2RET, pIGyo9xt, uOUr59MG.openStream(), cZTaK2uZ);
		} catch (IOException CWUvl8Jx) {
			throw new ImportException(uOUr59MG, "Cannot open workbook:" + CWUvl8Jx, CWUvl8Jx);
		}
	}

}