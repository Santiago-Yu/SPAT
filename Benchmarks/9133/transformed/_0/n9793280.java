class n9793280 {
	public SqlScript(URL J3dpgFmd, IDbDialect XpPS8RJM, boolean p7Y6Toz5, String TeDY5HOR, Map<String, String> dpYCogVj) {
        try {
            fileName = J3dpgFmd.getFile();
            fileName = fileName.substring(fileName.lastIndexOf("/") + 1);
            log.log(LogLevel.INFO, "Loading sql from script %s", fileName);
            init(IoUtils.readLines(new InputStreamReader(J3dpgFmd.openStream(), "UTF-8")), XpPS8RJM, p7Y6Toz5, TeDY5HOR, dpYCogVj);
        } catch (IOException GEIloZix) {
            log.error(GEIloZix);
            throw new RuntimeException(GEIloZix);
        }
    }

}