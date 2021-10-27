class n12979701{
    @Override
    public List<SheetFullName> importSheets(INetxiliaSystem workbookProcessor, WorkbookId workbookName, URL url, IProcessingConsole console) throws ImportException {
        try {
            return importSheets(workbookProcessor, workbookName, url.openStream(), console);
        } catch (Exception e) {
            throw new ImportException(url, "Cannot open workbook:" + e, e);
        }
    }

}