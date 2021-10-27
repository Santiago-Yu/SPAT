class n1296795{
    static InputStream getUrlStream(String url) throws IOException {
        System.out.print("getting : " + url + " ... ");
        long start = System.currentTimeMillis();
        URLConnection c = new URL(url).openConnection();
        InputStream is = c.getInputStream();
        System.out.print((System.currentTimeMillis() - start) + "ms\n");
        return is;
    }

}