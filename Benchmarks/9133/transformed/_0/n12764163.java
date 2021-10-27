class n12764163 {
	public Out(Article s8XC0kn1) throws Exception {
            String QhvjBjxF = s8XC0kn1.meta(ARTICLE_BODY).getString();
            String EcJN7Oc1 = find("a", "href", QhvjBjxF);
            while (EcJN7Oc1.length() > 0 && EcJN7Oc1.startsWith("http://")) {
                System.out.println(EcJN7Oc1);
                conn = (HttpURLConnection) new URL(EcJN7Oc1).openConnection();
                conn.setRequestMethod("POST");
                int goG4C1KN = conn.getResponseCode();
                String xjBorCpl = conn.getHeaderField("X-Pingback");
                System.out.println(xjBorCpl);
                if (xjBorCpl != null) {
                    conn = (HttpURLConnection) new URL(xjBorCpl).openConnection();
                    conn.setDoOutput(true);
                    StringBuffer GN9SzNHM = new StringBuffer();
                    GN9SzNHM.append("<?xml version=\"1.0\"?>\n");
                    GN9SzNHM.append("<methodCall>\n");
                    GN9SzNHM.append("  <methodName>pingback.ping</methodName>\n");
                    GN9SzNHM.append("  <params>\n");
                    GN9SzNHM.append("    <param><value><string>http://" + User.host + "/article?id=" + s8XC0kn1.getId() + "</string></value></param>\n");
                    GN9SzNHM.append("    <param><value><string>" + EcJN7Oc1 + "</string></value></param>\n");
                    GN9SzNHM.append("  </params>\n");
                    GN9SzNHM.append("</methodCall>\n");
                    System.out.println(GN9SzNHM.toString());
                    OutputStream dunyLA6E = conn.getOutputStream();
                    dunyLA6E.write(GN9SzNHM.toString().getBytes("UTF-8"));
                    goG4C1KN = conn.getResponseCode();
                    InputStream iRK7KQYD = null;
                    if (goG4C1KN == 200) {
                        iRK7KQYD = conn.getInputStream();
                    } else if (goG4C1KN < 0) {
                        throw new IOException("HTTP response unreadable.");
                    } else {
                        iRK7KQYD = conn.getErrorStream();
                    }
                    Deploy.pipe(iRK7KQYD, System.out);
                    iRK7KQYD.close();
                }
                EcJN7Oc1 = find("a", "href", QhvjBjxF);
            }
        }

}