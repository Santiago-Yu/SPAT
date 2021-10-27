class n11358121{
        public void run() {
            try {
                putEvent(new DebugEvent("about to place HTTP request"));
                HttpGet req = new HttpGet(requestURL);
                req.addHeader("Connection", "close");
                HttpResponse httpResponse = httpClient.execute(req);
                putEvent(new DebugEvent("got response to HTTP request"));
                nonSipPort.input(new Integer(httpResponse.getStatusLine().getStatusCode()));
                HttpEntity entity = httpResponse.getEntity();
                if (entity != null) {
                    InputStream in = entity.getContent();
                    if (in != null) in.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

}