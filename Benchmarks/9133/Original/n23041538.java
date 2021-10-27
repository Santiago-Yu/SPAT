class n23041538{
        private Properties getProperties(URL url) throws java.io.IOException {
            Properties cdrList = new Properties();
            java.io.InputStream stream = url.openStream();
            cdrList.load(stream);
            stream.close();
            return cdrList;
        }

}