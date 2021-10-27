class n19292394{
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://www.sohu.com");
        InputStream is = url.openStream();
        InputStreamReader isr = new InputStreamReader(is, Charset.forName("GB18030"));
        FileOutputStream fos = new FileOutputStream("gen/sohu2.html");
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        char[] b = new char[2048];
        int temp;
        while (-1 != (temp = isr.read(b, 0, b.length))) {
            osw.write(b);
        }
        osw.close();
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        String line = null;
    }

}