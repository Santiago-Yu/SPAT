class n7254343{
    public void manageRequest(Transformer transformer) throws ServletException {
        try {
            this.parser.reset();
            String encodedQuery = URLEncoder.encode(this.query, "ISO-8859-1");
            URL url = new URL(EXIST_SERVER + "?_query=" + encodedQuery);
            InputStream in = url.openStream();
            Document doc = this.parser.parse(in);
            Source source = new DOMSource(doc);
            transformer.transform(source, new StreamResult(this.getOut()));
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

}