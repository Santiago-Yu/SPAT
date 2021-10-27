class n5186187{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        URL url;
        URLConnection urlConn;
        DataOutputStream cgiInput;
        url = new URL("http://localhost:8080/ListeOnLine/Target");
        urlConn = url.openConnection();
        urlConn.setDoInput(true);
        urlConn.setDoOutput(true);
        urlConn.setUseCaches(false);
        urlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        cgiInput = new DataOutputStream(urlConn.getOutputStream());
        String content = "param1=" + URLEncoder.encode("first parameter") + "&param2=" + URLEncoder.encode("the second one...");
        cgiInput.writeBytes(content);
        cgiInput.flush();
        cgiInput.close();
        BufferedReader cgiOutput = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
        PrintWriter servletOutput = response.getWriter();
        servletOutput.print("<html><body><h1>This is the Source Servlet</h1><p />");
        String line = null;
        while (null != (line = cgiOutput.readLine())) {
            servletOutput.println(line);
        }
        cgiOutput.close();
        servletOutput.print("</body></html>");
        servletOutput.close();
    }

}