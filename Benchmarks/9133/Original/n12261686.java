class n12261686{
    @Override
    protected byte[] fetch0() throws IOException {
        if (sourceFile.getProtocol().equalsIgnoreCase("jar")) {
            throw new IOException("Jar protocol unsupported!");
        } else {
            URL url;
            if (sourceFile.getFile().endsWith(CLASS_FILE_EXTENSION)) {
                url = sourceFile;
            } else {
                url = new URL(sourceFile, className.replace(PACKAGE_SEPARATOR, URL_DIRECTORY_SEPARATOR) + CLASS_FILE_EXTENSION);
            }
            InputStream stream = url.openStream();
            try {
                ByteArrayOutputStream output = new ByteArrayOutputStream();
                byte[] buffer = new byte[PACKET_SIZE];
                int bytesRead;
                while ((bytesRead = stream.read(buffer, 0, buffer.length)) != -1) {
                    output.write(buffer, 0, bytesRead);
                }
                return output.toByteArray();
            } finally {
                stream.close();
            }
        }
    }

}