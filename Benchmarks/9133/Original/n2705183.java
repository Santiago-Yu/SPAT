class n2705183{
    public HSSFWorkbook callRules(URL urlOfExcelDataFile, RuleSource ruleSource, String excelLogSheet) throws DroolsParserException, IOException, ClassNotFoundException {
        InputStream inputFromExcel = null;
        try {
            log.info("Looking for url:" + urlOfExcelDataFile);
            inputFromExcel = urlOfExcelDataFile.openStream();
            log.info("found url:" + urlOfExcelDataFile);
        } catch (MalformedURLException e) {
            log.log(Level.SEVERE, "Malformed URL Exception Loading rules", e);
            throw e;
        } catch (IOException e) {
            log.log(Level.SEVERE, "IO Exception Loading rules", e);
            throw e;
        }
        return callRules(inputFromExcel, ruleSource, excelLogSheet);
    }

}