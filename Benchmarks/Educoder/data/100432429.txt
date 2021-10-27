    ClassFile getClassFile(String name) throws IOException, ConstantPoolException {
        URL url = getClass().getResource(name);
        InputStream in = url.openStream();
        try {
            return ClassFile.read(in);
        } finally {
            in.close();
        }
    }
