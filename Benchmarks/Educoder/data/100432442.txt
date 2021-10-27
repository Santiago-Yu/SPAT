    public static Model tryLoadURL(String url, RDFFormat format) throws MalformedURLException, IOException {
        URLConnection c = new URL(url).openConnection();
        c.addRequestProperty("Accept", format.getKey());
        String data = StreamUtil.toString(c.getInputStream());
        Model model = ModelFactory.createDefaultModel();
        model.read(new ByteArrayInputStream(data.getBytes()), "", format.getValue());
        return model;
    }
