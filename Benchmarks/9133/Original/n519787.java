class n519787{
    public InputStream unZip(URL url) throws Exception {
        ZipInputStream zipped = new ZipInputStream(url.openStream());
        System.out.println("unzipping: " + url.getFile());
        ZipEntry zip = zipped.getNextEntry();
        byte[] b = new byte[4096];
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
        for (int iRead = zipped.read(b); iRead != -1; iRead = zipped.read(b)) {
            bOut.write(b, 0, iRead);
        }
        zipped.close();
        ByteArrayInputStream bIn = new ByteArrayInputStream(bOut.toByteArray());
        return (InputStream) bIn;
    }

}