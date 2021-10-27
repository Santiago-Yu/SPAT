class n6686537{
    private static Map<String, File> loadServiceCache() {
        ArrayList<String> preferredOrder = new ArrayList<String>();
        HashMap<String, File> serviceFileMapping = new HashMap<String, File>();
        File file = new File(IsqlToolkit.getBaseDirectory(), CACHE_FILE);
        if (!file.exists()) {
            return serviceFileMapping;
        }
        if (file.canRead()) {
            FileReader fileReader = null;
            try {
                fileReader = new FileReader(file);
                BufferedReader lineReader = new BufferedReader(fileReader);
                while (lineReader.ready()) {
                    String data = lineReader.readLine();
                    if (data.charAt(0) == '#') {
                        continue;
                    }
                    int idx0 = 0;
                    int idx1 = data.indexOf(SERVICE_FIELD_SEPERATOR);
                    String name = StringUtilities.decodeASCII(data.substring(idx0, idx1));
                    String uri = StringUtilities.decodeASCII(data.substring(idx1 + 1));
                    if (name.equalsIgnoreCase(KEY_SERVICE_LIST)) {
                        StringTokenizer st = new StringTokenizer(uri, SERVICE_SEPERATOR);
                        while (st.hasMoreTokens()) {
                            String serviceName = st.nextToken();
                            preferredOrder.add(serviceName.toLowerCase().trim());
                        }
                        continue;
                    }
                    try {
                        URL url = new URL(uri);
                        File serviceFile = new File(url.getFile());
                        if (serviceFile.isDirectory()) {
                            logger.warn(messages.format("compatability_kit.service_mapped_to_directory", name, uri));
                            continue;
                        } else if (!serviceFile.canRead()) {
                            logger.warn(messages.format("compatability_kit.service_not_readable", name, uri));
                            continue;
                        } else if (!serviceFile.exists()) {
                            logger.warn(messages.format("compatability_kit.service_does_not_exist", name, uri));
                            continue;
                        }
                        String bindName = name.toLowerCase().trim();
                        InputStream inputStream = null;
                        try {
                            inputStream = url.openStream();
                            InputSource inputSource = new InputSource(inputStream);
                            bindName = ServiceDigester.parseService(inputSource, IsqlToolkit.getSharedEntityResolver()).getName();
                        } catch (Exception error) {
                            continue;
                        }
                        if (serviceFileMapping.put(bindName, serviceFile) != null) {
                            logger.warn(messages.format("compatability_kit.service_duplicate_name_error", name, uri));
                        }
                    } catch (MalformedURLException e) {
                        logger.error(messages.format("compatability_kit.service_uri_error", name, uri), e);
                    }
                }
            } catch (IOException ioe) {
                logger.error("compatability_kit.service_generic_error", ioe);
            } finally {
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (Throwable ignored) {
                    }
                }
            }
        }
        return serviceFileMapping;
    }

}