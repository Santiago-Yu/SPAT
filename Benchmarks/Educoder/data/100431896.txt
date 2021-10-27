    public static Vector[] getLinksFromURLFast(String p_url) throws Exception {
        timeCheck("getLinksFromURLFast ");
        URL x_url = new URL(p_url);
        URLConnection x_conn = x_url.openConnection();
        InputStreamReader x_is_reader = new InputStreamReader(x_conn.getInputStream());
        BufferedReader x_reader = new BufferedReader(x_is_reader);
        String x_line = null;
        RE e = new RE("(.*/)", RE.REG_ICASE);
        System.out.println("RE: " + e.toString());
        REMatch x_match = e.getMatch(p_url);
        String x_dir = p_url.substring(x_match.getSubStartIndex(1), x_match.getSubEndIndex(1));
        e = new RE("(http://.*?)/?", RE.REG_ICASE);
        x_match = e.getMatch(p_url);
        String x_root = p_url.substring(x_match.getSubStartIndex(1), x_match.getSubEndIndex(1));
        e = new RE("<a href=\"?(.*?)\"?>(.*?)</a>", RE.REG_ICASE);
        System.out.println("RE: " + e.toString());
        Vector x_links = new Vector(100);
        Vector x_texts = new Vector(100);
        StringBuffer x_buf = new StringBuffer(10000);
        REMatch[] x_matches = null;
        timeCheck("starting parsing ");
        while ((x_line = x_reader.readLine()) != null) {
            x_buf.append(x_line);
        }
        String x_page = x_buf.toString();
        String x_link = null;
        x_matches = e.getAllMatches(x_page);
        for (int i = 0; i < x_matches.length; i++) {
            x_link = x_page.substring(x_matches[i].getSubStartIndex(1), x_matches[i].getSubEndIndex(1));
            if (x_link.indexOf("mailto:") != -1) continue;
            x_link = toAbsolute(x_root, x_dir, x_link);
            x_links.addElement(x_link);
            x_texts.addElement(x_page.substring(x_matches[i].getSubStartIndex(2), x_matches[i].getSubEndIndex(2)));
        }
        Vector[] x_result = new Vector[2];
        x_result[0] = x_links;
        x_result[1] = x_texts;
        timeCheck("end parsing ");
        return x_result;
    }
