    public void dorequest(Map<String, String> ps, String method) throws IOException {
        StringBuffer httpResponse = new StringBuffer();
        URL ourl = new URL(url);
        HttpURLConnection httpConnection = (HttpURLConnection) ourl.openConnection();
        httpConnection.setRequestMethod(method);
        httpConnection.setDoOutput(true);
        this.setCookie(httpConnection);
        OutputStream httpOutputStream = httpConnection.getOutputStream();
        StringBuffer postParams = new StringBuffer("");
        for (Entry<String, String> entry : ps.entrySet()) {
            postParams.append(entry.getKey());
            postParams.append("=");
            postParams.append(entry.getValue());
            postParams.append("&");
        }
        httpOutputStream.write(postParams.toString().getBytes());
        BufferedReader httpBufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
        httpResponse.append(this.readBufferedContent(httpBufferedReader));
        text = httpResponse.toString();
        this.readCookie(httpConnection);
    }
