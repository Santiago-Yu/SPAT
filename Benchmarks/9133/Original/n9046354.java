class n9046354{
    public static String downloadWebVersionString(String address) {
        StringBuffer stb = new StringBuffer();
        URLConnection conn = null;
        InputStream in = null;
        try {
            URL url = new URL(address);
            conn = url.openConnection();
            in = conn.getInputStream();
            byte[] buffer = new byte[1024];
            int numRead;
            long numWritten = 0;
            while ((numRead = in.read(buffer)) != -1) {
                for (int i = 0; i < numRead; i++) {
                    stb.append((char) buffer[i]);
                }
                numWritten += numRead;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            return stb.toString();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ioe) {
            }
        }
        return stb.toString();
    }

}