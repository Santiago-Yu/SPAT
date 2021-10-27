class n13733915{
    public static void contentTrans(String contents, String urlString, String urlString2, String serverIp, int port) {
        try {
            URL url = new URL(urlString);
            url.openStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Socket server = new Socket(InetAddress.getByName(serverIp), port);
            OutputStream outputStream = server.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            bufferedWriter.write(contents);
            bufferedWriter.flush();
            bufferedWriter.close();
            server.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            URL url2 = new URL(urlString2);
            url2.openStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}