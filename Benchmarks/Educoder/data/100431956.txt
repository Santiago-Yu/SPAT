    public List<String> extractUrlList(String url) throws IOException, XPathExpressionException {
        LinkedList<String> list = new LinkedList<String>();
        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
        Tidy tidy = new Tidy();
        tidy.setErrout(new NullPrintWriter());
        Document doc = tidy.parseDOM(conn.getInputStream(), null);
        int len = conn.getContentLength();
        if (len <= 0) len = 32000;
        ByteArrayOutputStream bout = new ByteArrayOutputStream(len);
        PrintStream ps = new PrintStream(bout);
        tidy.pprint(doc, ps);
        ps.flush();
        String content = bout.toString();
        Pattern p = Pattern.compile("(http://[\\w\\\\\\./=&?;-]+)");
        Matcher m = p.matcher(content);
        while (m.find()) {
            list.add(m.group());
        }
        return list;
    }
