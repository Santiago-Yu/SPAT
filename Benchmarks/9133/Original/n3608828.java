class n3608828{
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String req1xml = jTextArea1.getText();
            java.net.URL url = new java.net.URL("http://217.34.8.235:8080/newgenlibctxt/PatronServlet");
            java.net.URLConnection urlconn = (java.net.URLConnection) url.openConnection();
            urlconn.setDoOutput(true);
            urlconn.setRequestProperty("Content-type", "text/xml; charset=UTF-8");
            java.io.OutputStream os = urlconn.getOutputStream();
            java.util.zip.CheckedOutputStream cos = new java.util.zip.CheckedOutputStream(os, new java.util.zip.Adler32());
            java.util.zip.GZIPOutputStream gop = new java.util.zip.GZIPOutputStream(cos);
            java.io.OutputStreamWriter dos = new java.io.OutputStreamWriter(gop, "UTF-8");
            System.out.println(req1xml);
            try {
                java.io.FileOutputStream pw = new java.io.FileOutputStream("C:/log.txt");
                pw.write(req1xml.getBytes());
                pw.flush();
                pw.close();
            } catch (Exception exp) {
                exp.printStackTrace();
            }
            dos.write(req1xml);
            dos.flush();
            dos.close();
            System.out.println("url conn: " + urlconn.getContentEncoding() + "  " + urlconn.getContentType());
            java.io.InputStream ios = urlconn.getInputStream();
            java.util.zip.CheckedInputStream cis = new java.util.zip.CheckedInputStream(ios, new java.util.zip.Adler32());
            java.util.zip.GZIPInputStream gip = new java.util.zip.GZIPInputStream(cis);
            java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(gip));
            String reqxml = "";
            while (br.ready()) {
                String line = br.readLine();
                reqxml += line;
            }
            try {
                java.io.FileOutputStream pw = new java.io.FileOutputStream("C:/log3.txt");
                pw.write(reqxml.getBytes());
                pw.flush();
                pw.close();
            } catch (Exception exp) {
                exp.printStackTrace();
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

}