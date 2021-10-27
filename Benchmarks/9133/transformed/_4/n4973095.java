class n4973095 {
	public Wget2(URL url, File f) throws IOException {
        System.out.println("bajando: " + url);
        by = (f == null) ? new ByteArrayOutputStream() : new FileOutputStream(f);
        URLConnection uc = url.openConnection();
        if (uc instanceof HttpURLConnection) {
            leerHttp((HttpURLConnection) uc);
        } else {
            throw new IOException("solo se pueden descargar url http");
        }
    }

}