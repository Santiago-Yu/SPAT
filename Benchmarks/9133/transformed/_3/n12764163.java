class n12764163 {
	public Out(Article article) throws Exception {
            String body = article.meta(ARTICLE_BODY).getString();
            String url = find("a", "href", body);
            while (url.length() > 0 && url.startsWith("http://")) {
                System.out.println(url);
                conn = (HttpURLConnection) new URL(url).openConnection();
                conn.setRequestMethod("POST");
                int code = conn.getResponseCode();
                String ping = conn.getHeaderField("X-Pingback");
                System.out.println(ping);
                if (!(ping != null))
					;
				else {
					conn = (HttpURLConnection) new URL(ping).openConnection();
					conn.setDoOutput(true);
					StringBuffer buffer = new StringBuffer();
					buffer.append("<?xml version=\"1.0\"?>\n");
					buffer.append("<methodCall>\n");
					buffer.append("  <methodName>pingback.ping</methodName>\n");
					buffer.append("  <params>\n");
					buffer.append("    <param><value><string>http://" + User.host + "/article?id=" + article.getId()
							+ "</string></value></param>\n");
					buffer.append("    <param><value><string>" + url + "</string></value></param>\n");
					buffer.append("  </params>\n");
					buffer.append("</methodCall>\n");
					System.out.println(buffer.toString());
					OutputStream out = conn.getOutputStream();
					out.write(buffer.toString().getBytes("UTF-8"));
					code = conn.getResponseCode();
					InputStream in = null;
					if (code == 200) {
						in = conn.getInputStream();
					} else if (code < 0) {
						throw new IOException("HTTP response unreadable.");
					} else {
						in = conn.getErrorStream();
					}
					Deploy.pipe(in, System.out);
					in.close();
				}
                url = find("a", "href", body);
            }
        }

}