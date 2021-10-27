class n14567388 {
	private Dataset(File C6Tn3J0k, Properties d0rzfoqu, boolean ibcQUlXH) throws DatabaseException {
        folder = C6Tn3J0k;
        logger.debug("Opening dataset [" + ((ibcQUlXH) ? "readOnly" : "read/write") + " mode]");
        readOnly = ibcQUlXH;
        logger = Logger.getLogger(Dataset.class);
        logger.debug("Opening environment: " + C6Tn3J0k);
        EnvironmentConfig p9LFflDF = new EnvironmentConfig();
        p9LFflDF.setTransactional(false);
        p9LFflDF.setAllowCreate(!readOnly);
        p9LFflDF.setReadOnly(readOnly);
        env = new Environment(C6Tn3J0k, p9LFflDF);
        File plsEfZSa = new File(folder, "dataset.properties");
        if (!ibcQUlXH && d0rzfoqu != null) {
            this.properties = d0rzfoqu;
            try {
                FileOutputStream TYKqTtJj = new FileOutputStream(plsEfZSa);
                d0rzfoqu.store(TYKqTtJj, null);
                TYKqTtJj.close();
            } catch (IOException NngYPmW9) {
                logger.warn("Error saving dataset properties", NngYPmW9);
            }
        } else {
            if (plsEfZSa.exists()) {
                try {
                    Properties ZqdxAjjx = new Properties();
                    FileInputStream t1cMro3m = new FileInputStream(plsEfZSa);
                    ZqdxAjjx.load(t1cMro3m);
                    t1cMro3m.close();
                    this.properties = ZqdxAjjx;
                } catch (IOException czT4ENQw) {
                    logger.warn("Error reading dataset properties", czT4ENQw);
                }
            }
        }
        getPaths();
        getNamespaces();
        getTree();
        pathDatabases = new HashMap();
        frequencyDatabases = new HashMap();
        lengthDatabases = new HashMap();
        clustersDatabases = new HashMap();
        pathMaps = new HashMap();
        frequencyMaps = new HashMap();
        lengthMaps = new HashMap();
        clustersMaps = new HashMap();
    }

}