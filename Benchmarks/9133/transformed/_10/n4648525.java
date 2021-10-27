class n4648525 {
	public MusicBrainzXMLParser(URL url) throws DocumentException, IOException {
        URLConnection urlConnection = url.openConnection();
        InputStream httpStream = urlConnection.getInputStream();
        SAXReader reader = new SAXReader();
        BufferedReader br = new BufferedReader(new InputStreamReader(httpStream, "ISO-8859-1"));
        doc = reader.read(br);
        br.close();
    }

}