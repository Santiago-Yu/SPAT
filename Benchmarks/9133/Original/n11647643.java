class n11647643{
        public void actionPerformed(ActionEvent e) {
            try {
                URL url = new URL("http://mailsomething.sf.net/helppages.xml");
                try {
                    File file = File.createTempFile("temp", "xml");
                    InputStream in = new BufferedInputStream(url.openStream());
                    OutputStream out = new FileOutputStream(file);
                    byte[] buf = new byte[1024];
                    int n;
                    while ((n = in.read(buf)) > 0) out.write(buf, 0, n);
                    out.flush();
                    out.close();
                    module.merge(file);
                } catch (IOException f) {
                }
            } catch (MalformedURLException f) {
            }
        }

}