class n5616545{
    public void issue(String licenseId, Map answers, String lang) throws IOException {
        String issueUrl = this.rest_root + "/license/" + licenseId + "/issue";
        String answer_doc = "<answers>\n<license-" + licenseId + ">";
        Iterator keys = answers.keySet().iterator();
        try {
            String current = (String) keys.next();
            while (true) {
                answer_doc += "<" + current + ">" + (String) answers.get(current) + "</" + current + ">\n";
                current = (String) keys.next();
            }
        } catch (NoSuchElementException e) {
        }
        answer_doc += "</license-" + licenseId + ">\n</answers>\n";
        String post_data;
        try {
            post_data = URLEncoder.encode("answers", "UTF-8") + "=" + URLEncoder.encode(answer_doc, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return;
        }
        URL post_url;
        try {
            post_url = new URL(issueUrl);
        } catch (MalformedURLException e) {
            return;
        }
        URLConnection conn = post_url.openConnection();
        conn.setDoOutput(true);
        OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
        wr.write(post_data);
        wr.flush();
        try {
            this.license_doc = this.parser.build(conn.getInputStream());
        } catch (JDOMException e) {
            System.out.print("Danger Will Robinson, Danger!");
        }
        return;
    }

}