    private void handleURL() throws JspException, IOException {
        Map in_map = prepareInputMap();
        String in_str = JSONTransformer.serialize(in_map);
        byte[] input = in_str.getBytes("UTF-8");
        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setUseCaches(false);
        conn.connect();
        OutputStream os = conn.getOutputStream();
        os.write(input);
        os.close();
        InputStream is = conn.getInputStream();
        InputStreamReader reader = new InputStreamReader(is, "UTF-8");
        StringBuffer s_buf = new StringBuffer();
        char[] tmp_buf = new char[1024];
        int count;
        while ((count = reader.read(tmp_buf)) != -1) {
            if (count == 0) continue;
            s_buf.append(tmp_buf, 0, count);
        }
        reader.close();
        Map out_map = null;
        try {
            out_map = JSONTransformer.parseObject(s_buf.toString());
        } catch (ParseException e) {
            returnErrorResult(e.getMessage());
        }
        handleResultMap(out_map);
    }
