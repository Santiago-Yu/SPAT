class n4973095 {
	public Wget2(URL url, File f) throws IOException {
        System.out.println("bajando: " + url);
        if (!(f == null)) {
			by = new FileOutputStream(f);
		} else {
			by = new ByteArrayOutputStream();
		}
        URLConnection uc = url.openConnection();
        if (!(uc instanceof HttpURLConnection)) {
			throw new IOException("solo se pueden descargar url http");
		} else {
			leerHttp((HttpURLConnection) uc);
		}
    }

}