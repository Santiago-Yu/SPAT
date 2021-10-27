class n7875897{
    @SuppressWarnings("unchecked")
    protected void handleRequest(HttpServletRequest req, HttpServletResponse resp, boolean isPost) throws ServletException, IOException {
        HttpClient httpclient = WebReader.getHttpClient();
        try {
            StringBuffer sb = new StringBuffer();
            sb.append(targetServer);
            sb.append(req.getRequestURI());
            if (req.getQueryString() != null) {
                sb.append("?" + req.getQueryString());
            }
            HttpRequestBase targetRequest = null;
            if (isPost) {
                HttpPost post = new HttpPost(sb.toString());
                Enumeration<String> paramNames = req.getParameterNames();
                String paramName = null;
                List<NameValuePair> params = new ArrayList<NameValuePair>();
                while (paramNames.hasMoreElements()) {
                    paramName = paramNames.nextElement();
                    params.add(new BasicNameValuePair(paramName, req.getParameterValues(paramName)[0]));
                }
                post.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
                targetRequest = post;
            } else {
                System.out.println("GET");
                HttpGet get = new HttpGet(sb.toString());
                targetRequest = get;
            }
            HttpResponse targetResponse = httpclient.execute(targetRequest);
            HttpEntity entity = targetResponse.getEntity();
            InputStream input = entity.getContent();
            OutputStream output = resp.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
            String line = reader.readLine();
            while (line != null) {
                writer.write(line + "\n");
                line = reader.readLine();
            }
            reader.close();
            writer.close();
        } finally {
            WebReader.returnHttpClient(httpclient);
        }
    }

}