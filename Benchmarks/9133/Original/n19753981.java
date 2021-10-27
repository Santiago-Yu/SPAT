class n19753981{
    private void download(String address, String localFileName, String host, int porta) {
        InputStream in = null;
        URLConnection conn = null;
        OutputStream out = null;
        System.out.println("Update.download() BAIXANDO " + address);
        try {
            URL url = new URL(address);
            out = new BufferedOutputStream(new FileOutputStream(localFileName));
            if (host != "" && host != null) {
                Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(host, porta));
                conn = url.openConnection(proxy);
            } else {
                conn = url.openConnection();
            }
            in = conn.getInputStream();
            byte[] buffer = new byte[1024];
            int numRead;
            long numWritten = 0;
            while ((numRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, numRead);
                numWritten += numRead;
            }
            System.out.println(localFileName + "\t" + numWritten);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException ioe) {
            }
        }
    }

}