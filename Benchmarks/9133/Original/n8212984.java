class n8212984{
    private void readCard() {
        try {
            final String urlString = createURLStringExistRESTGetXQuery("//scheda[cata = \"" + cata + "\"]");
            InputStream inputStream = new URL(urlString).openStream();
            uiSchedaXml.read(inputStream);
            inputStream.close();
        } catch (MalformedURLException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}