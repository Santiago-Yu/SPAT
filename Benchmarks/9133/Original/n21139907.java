class n21139907{
    public void fetchPublicContent(int id) throws IOException {
        String fileName = FILE_NAME_PREFIX + id + ".xml";
        File file = new File(fileName);
        if (file.exists()) {
            System.out.println("user: " + id + " not fetched because it already exists");
            return;
        }
        OutputStream out = new FileOutputStream(file, false);
        URL url = new URL("http://twitter.com/statuses/followers.xml?id=" + id);
        URLConnection conn = url.openConnection();
        InputStream in = conn.getInputStream();
        int i = 0;
        while ((i = in.read()) != -1) {
            out.write(i);
        }
        in.close();
        out.close();
    }

}