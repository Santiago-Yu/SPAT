class n4369694{
    private void loadProperties() throws IOException {
        if (properties == null) {
            return;
        }
        printDebugIfEnabled("Loading properties");
        InputStream inputStream = configurationSource.openStream();
        Properties newProperties = new Properties();
        try {
            newProperties.load(inputStream);
        } finally {
            inputStream.close();
        }
        String importList = newProperties.getProperty(KEY_IMPORT);
        if (importList != null) {
            importList = importList.trim();
            if (importList.length() > 0) {
                String[] filesToImport = importList.split(",");
                if (filesToImport != null && filesToImport.length != 0) {
                    String configurationContext = configurationSource.toExternalForm();
                    int lastSlash = configurationContext.lastIndexOf('/');
                    lastSlash += 1;
                    configurationContext = configurationContext.substring(0, lastSlash);
                    for (int i = 0; i < filesToImport.length; i++) {
                        String filenameToImport = filesToImport[i];
                        URL urlToImport = new URL(configurationContext + filenameToImport);
                        InputStream importStream = null;
                        try {
                            printDebugIfEnabled("Importing file", urlToImport);
                            importStream = urlToImport.openStream();
                            newProperties.load(importStream);
                        } catch (IOException e) {
                            printError("Error importing properties file: " + filenameToImport + "(" + urlToImport + ")", e, true);
                        } finally {
                            if (importStream != null) importStream.close();
                        }
                    }
                }
            }
        }
        if (devDebug) {
            Set properties = newProperties.entrySet();
            printDebugIfEnabled("_____ Properties List START _____");
            for (Iterator iterator = properties.iterator(); iterator.hasNext(); ) {
                Map.Entry entry = (Map.Entry) iterator.next();
                printDebugIfEnabled((String) entry.getKey(), entry.getValue());
            }
            printDebugIfEnabled("______ Properties List END ______");
        }
        properties.clear();
        properties.putAll(newProperties);
    }

}