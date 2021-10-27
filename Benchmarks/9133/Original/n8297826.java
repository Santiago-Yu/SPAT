class n8297826{
    public void download(String ftpServer, String user, String password, String fileName, File destination) throws MalformedURLException, IOException {
        if (ftpServer != null && fileName != null && destination != null) {
            StringBuffer sb = new StringBuffer("ftp://");
            if (user != null && password != null) {
                sb.append(user);
                sb.append(':');
                sb.append(password);
                sb.append('@');
            }
            sb.append(ftpServer);
            sb.append('/');
            sb.append(fileName);
            sb.append(";type=i");
            BufferedInputStream bis = null;
            BufferedOutputStream bos = null;
            try {
                URL url = new URL(sb.toString());
                URLConnection urlc = url.openConnection();
                bis = new BufferedInputStream(urlc.getInputStream());
                bos = new BufferedOutputStream(new FileOutputStream(destination));
                int i;
                while ((i = bis.read()) != -1) {
                    bos.write(i);
                }
            } finally {
                if (bis != null) try {
                    bis.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
                if (bos != null) try {
                    bos.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        } else {
            System.out.println("Input not available");
        }
    }

}