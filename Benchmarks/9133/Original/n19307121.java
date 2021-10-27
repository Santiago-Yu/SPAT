class n19307121{
    public static byte[] sendSmsRequest(String url, String param) {
        byte[] bytes = null;
        try {
            URL httpurl = new URL(url);
            HttpURLConnection httpConn = (HttpURLConnection) httpurl.openConnection();
            httpConn.setRequestProperty("Accept-Language", "zh-CN");
            httpConn.setDoOutput(true);
            httpConn.setDoInput(true);
            PrintWriter out = new PrintWriter(httpConn.getOutputStream());
            out.print(param);
            out.flush();
            out.close();
            InputStream ism = httpConn.getInputStream();
            bytes = new byte[httpConn.getContentLength()];
            ism.read(bytes);
            ism.close();
            MsgPrint.showByteArray("result", bytes);
        } catch (Exception e) {
            return new byte[] { 0, 0, 0, 0 };
        }
        return bytes;
    }

}