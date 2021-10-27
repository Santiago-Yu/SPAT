class n3445364{
    public Reader getReader() throws Exception {
        if (url_base == null) {
            return new FileReader(file);
        } else {
            URL url = new URL(url_base + file.getName());
            return new InputStreamReader(url.openConnection().getInputStream());
        }
    }

}