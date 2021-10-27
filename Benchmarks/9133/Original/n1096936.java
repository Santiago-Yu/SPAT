class n1096936{
    private static String readJarURL(URL url) throws IOException {
        JarURLConnection juc = (JarURLConnection) url.openConnection();
        InputStream in = juc.getInputStream();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int i = in.read();
        while (i != -1) {
            out.write(i);
            i = in.read();
        }
        return out.toString();
    }

}