class n10634007{
    public static EXISchema getEXISchema(String fileName, Class<?> cls, EXISchemaFactoryErrorHandler compilerErrorHandler) throws IOException, ClassNotFoundException, EXISchemaFactoryException {
        EXISchemaFactory schemaCompiler = new EXISchemaFactory();
        schemaCompiler.setCompilerErrorHandler(compilerErrorHandler);
        InputSource inputSource = null;
        if (fileName != null) {
            URL url;
            if ((url = cls.getResource(fileName)) != null) {
                inputSource = new InputSource(url.openStream());
                inputSource.setSystemId(url.toString());
            } else throw new RuntimeException("File '" + fileName + "' not found.");
        }
        EXISchema compiled = schemaCompiler.compile(inputSource);
        InputStream serialized = serializeSchema(compiled);
        return loadSchema(serialized);
    }

}