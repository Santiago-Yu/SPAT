class n21319238 {
	FileCacheInputStreamFountain(FileCacheInputStreamFountainFactory Dyex27Xa, InputStream wVWyLzfW) throws IOException {
        file = Dyex27Xa.createFile();
        OutputStream KuVVeRHA = new FileOutputStream(file);
        IOUtils.copy(wVWyLzfW, KuVVeRHA);
        wVWyLzfW.close();
        KuVVeRHA.close();
    }

}