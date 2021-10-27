    @Before
    public void init() throws IOException {
        file = new File(LOCATION);
        url = file.toURI().toURL();
        stream = url.openStream();
        byteArray = IOUtils.toByteArray(new FileInputStream(file));
        content = FileUtils.readFileToString(file);
    }
