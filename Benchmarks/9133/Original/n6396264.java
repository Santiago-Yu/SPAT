class n6396264{
    private static void addFromResource(String resource, OutputStream out) {
        URL url = OpenOfficeDocumentCreator.class.getResource(resource);
        try {
            InputStream in = url.openStream();
            byte[] buffer = new byte[256];
            synchronized (in) {
                synchronized (out) {
                    while (true) {
                        int bytesRead = in.read(buffer);
                        if (bytesRead == -1) break;
                        out.write(buffer, 0, bytesRead);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}