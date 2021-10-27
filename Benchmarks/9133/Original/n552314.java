class n552314{
    public void refreshFileItem(YahooInfo legroup) throws Exception {
        String lapage = new String("");
        String ledir = new String("");
        Pattern pat;
        Matcher mat;
        Pattern pat2;
        Matcher mat2;
        int data;
        URL myurl = new URL("http://groups.yahoo.com/mygroups");
        URLConnection conn;
        URI myuri = new URI("http://groups.yahoo.com/mygroups");
        YahooInfo yi;
        clearItem(legroup);
        for (int i = 0; i < UrlList.size(); i++) {
            if (UrlList.get(i).getGroup().equals(legroup.getGroup()) && UrlList.get(i).getDir().startsWith(legroup.getDir())) {
                if (UrlList.get(i).isGroup()) {
                    System.out.print(UrlList.get(i).getGroup() + " : ");
                    myuri = new URI(UrlList.get(i).getUrl());
                    myurl = new URL(UrlList.get(i).getUrl());
                    conn = myurl.openConnection();
                    conn.connect();
                    System.out.println(conn.getHeaderField(0).toString());
                    if (!Pattern.matches("HTTP/... 2.. .*", conn.getHeaderField(0).toString())) {
                        System.out.println(conn.getHeaderField(0).toString());
                        return;
                    }
                    InputStream in = conn.getInputStream();
                    lapage = "";
                    for (data = in.read(); data != -1; data = in.read()) lapage += (char) data;
                    pat = Pattern.compile("<li> <a href=\"(.+?)\".*?>Files</a></li>");
                    mat = pat.matcher(lapage);
                    if (mat.find()) {
                        yi = new YahooInfo(UrlList.get(i).getGroup(), "/", "", myuri.resolve(HTMLDecoder.decode(mat.group(1))).toURL().toString());
                        UrlList.add(yi);
                    }
                }
                if (UrlList.get(i).isDir()) {
                    System.out.println(UrlList.get(i).getGroup() + UrlList.get(i).getDir());
                    myuri = new URI(UrlList.get(i).getUrl());
                    myurl = new URL(UrlList.get(i).getUrl());
                    do {
                        myurl = new URL(myurl.toString());
                        conn = myurl.openConnection();
                        conn.connect();
                        if (!Pattern.matches("HTTP/... 2.. .*", conn.getHeaderField(0).toString())) {
                            System.out.println(conn.getHeaderField(0).toString());
                            return;
                        }
                        System.out.print("p");
                        InputStream in = conn.getInputStream();
                        lapage = "";
                        for (data = in.read(); data != -1; data = in.read()) lapage += (char) data;
                        pat = Pattern.compile("<span class=\"title\">\n<a href=\"(.+?/)\">(.+?)</a>");
                        mat = pat.matcher(lapage);
                        while (mat.find()) {
                            ledir = new String(UrlList.get(i).getDir());
                            pat2 = Pattern.compile("([A-Za-z0-9]+)");
                            mat2 = pat2.matcher(mat.group(2));
                            while (mat2.find()) {
                                ledir += mat2.group(1);
                            }
                            ledir += "/";
                            yi = new YahooInfo(UrlList.get(i).getGroup(), ledir, "", myuri.resolve(HTMLDecoder.decode(mat.group(1))).toURL().toString());
                            UrlList.add(yi);
                        }
                        pat = Pattern.compile("<span class=\"title\">\n<a href=\"(.+?yahoofs.+?)\".*?>(.+?)</a>");
                        mat = pat.matcher(lapage);
                        while (mat.find()) {
                            yi = new YahooInfo(UrlList.get(i).getGroup(), UrlList.get(i).getDir(), mat.group(2), myuri.resolve(HTMLDecoder.decode(mat.group(1))).toURL().toString());
                            UrlList.add(yi);
                        }
                        System.out.println("");
                        pat = Pattern.compile("<a href=\"(.+?)\">Next");
                        mat = pat.matcher(lapage);
                        myurl = null;
                        if (mat.find()) {
                            myurl = myuri.resolve(HTMLDecoder.decode(mat.group(1))).toURL();
                        }
                    } while (myurl != null);
                }
            }
        }
    }

}