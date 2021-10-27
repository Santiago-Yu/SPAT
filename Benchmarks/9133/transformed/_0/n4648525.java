class n4648525 {
	public MusicBrainzXMLParser(URL RCeuSvOW) throws DocumentException, IOException {
        URLConnection vTogighY = RCeuSvOW.openConnection();
        InputStream GN1z7d4f = vTogighY.getInputStream();
        BufferedReader Mk4kT6Do = new BufferedReader(new InputStreamReader(GN1z7d4f, "ISO-8859-1"));
        SAXReader EyoOjHzq = new SAXReader();
        doc = EyoOjHzq.read(Mk4kT6Do);
        Mk4kT6Do.close();
    }

}