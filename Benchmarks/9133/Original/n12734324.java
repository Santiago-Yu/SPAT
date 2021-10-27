class n12734324{
    public static String post(String url, Map params, String line_delimiter) {
        String response = "";
        try {
            URL _url = new URL(url);
            URLConnection conn = _url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            String postdata = "";
            int mapsize = params.size();
            Iterator keyValue = params.entrySet().iterator();
            for (int i = 0; i < mapsize; i++) {
                Map.Entry entry = (Map.Entry) keyValue.next();
                String key = (String) entry.getKey();
                String value = (String) entry.getValue();
                if (i > 0) postdata += "&";
                postdata += URLEncoder.encode(key, "UTF-8") + "=" + URLEncoder.encode(value, "UTF-8");
            }
            wr.write(postdata);
            wr.flush();
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) response += line + line_delimiter;
            wr.close();
            rd.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return response;
    }

}