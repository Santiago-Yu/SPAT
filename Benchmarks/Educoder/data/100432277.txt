    public static String sendPost(String url, String param) {
        String result = "";
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
            BufferedReader in = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            in.close();
        } catch (Exception e) {
            MsgPrint.showMsg(e.getMessage());
        }
        return result;
    }
