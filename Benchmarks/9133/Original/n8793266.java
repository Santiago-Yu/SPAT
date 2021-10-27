class n8793266{
    public static void readDefault() {
        ClassLoader l = Skeleton.class.getClassLoader();
        URL url = l.getResource("weka/core/parser/JFlex/skeleton.default");
        if (url == null) {
            Out.error(ErrorMessages.SKEL_IO_ERROR_DEFAULT);
            throw new GeneratorException();
        }
        try {
            InputStreamReader reader = new InputStreamReader(url.openStream());
            readSkel(new BufferedReader(reader));
        } catch (IOException e) {
            Out.error(ErrorMessages.SKEL_IO_ERROR_DEFAULT);
            throw new GeneratorException();
        }
    }

}