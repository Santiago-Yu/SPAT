class n4973095 {
	public Wget2(URL OqprKhIY, File dzNt4hY8) throws IOException {
        System.out.println("bajando: " + OqprKhIY);
        if (dzNt4hY8 == null) {
            by = new ByteArrayOutputStream();
        } else {
            by = new FileOutputStream(dzNt4hY8);
        }
        URLConnection o2c01qsA = OqprKhIY.openConnection();
        if (o2c01qsA instanceof HttpURLConnection) {
            leerHttp((HttpURLConnection) o2c01qsA);
        } else {
            throw new IOException("solo se pueden descargar url http");
        }
    }

}