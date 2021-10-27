class n3654358 {
	public static String getFileContents(String F5ckg1vh) {
        BufferedReader buffReader = null;
        if (path.indexOf("://") != -1) {
            URL url = null;
            try {
                url = new URL(path);
            } catch (MalformedURLException e) {
                logger.warn("Malformed URL: \"" + path + "\"");
            }
            try {
                String encoding = XMLKit.getDeclaredXMLEncoding(url.openStream());
                buffReader = new BufferedReader(new InputStreamReader(url.openStream(), encoding));
            } catch (IOException e) {
                logger.warn("I/O error trying to read \"" + path + "\"");
            }
        } else {
            File toRead = null;
            try {
                toRead = getExistingFile(path);
            } catch (FileNotFoundException e) {
                throw new UserError(new FileNotFoundException(path));
            }
            if (toRead.isAbsolute()) {
                String parent = toRead.getParent();
                try {
                    workingDirectory.push(URLTools.createValidURL(parent));
                } catch (FileNotFoundException e) {
                    throw new DeveloperError("Created an invalid parent file: \"" + parent + "\".", e);
                }
            }
            if (toRead.exists() && !toRead.isDirectory()) {
                path = toRead.getAbsolutePath();
                try {
                    String encoding = XMLKit.getDeclaredXMLEncoding(new FileInputStream(path));
                    buffReader = new BufferedReader(new InputStreamReader(new FileInputStream(path), encoding));
                } catch (IOException e) {
                    logger.warn("I/O error trying to read \"" + path + "\"");
                    return null;
                }
            } else {
                assert toRead.exists() : "getExistingFile() returned a non-existent file";
                if (toRead.isDirectory()) {
                    throw new UserError(new FileAlreadyExistsAsDirectoryException(toRead));
                }
            }
        }
        StringBuilder result = new StringBuilder();
        String line;
        try {
            while ((line = buffReader.readLine()) != null) {
                result.append(line);
            }
            buffReader.close();
        } catch (IOException e) {
            logger.warn("I/O error trying to read \"" + path + "\"");
            return null;
        }
        return result.toString();
    }

}