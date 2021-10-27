class n19861527{
    static void getGroupMember(String groupname) {
        try {
            URL url = new URL("http://www.lastfm.de/group/" + groupname + "/members");
            URLConnection con = url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            HTMLEditorKit editorKit = new HTMLEditorKit();
            HTMLDocument htmlDoc = new HTMLDocument();
            htmlDoc.putProperty("IgnoreCharsetDirective", Boolean.TRUE);
            editorKit.read(br, htmlDoc, 0);
            Vector<String> a_tags = new Vector<String>();
            HTMLDocument.Iterator iter = htmlDoc.getIterator(HTML.Tag.A);
            while (iter.isValid()) {
                a_tags.add((String) iter.getAttributes().getAttribute(HTML.Attribute.HREF));
                iter.next();
            }
            Vector<String> members = new Vector<String>();
            for (int i = 0; i < a_tags.size(); i++) {
                String element = (String) a_tags.get(i);
                if (!members.contains(element)) {
                    if (element.contains("/user/")) {
                        members.add(element);
                    }
                }
            }
            for (int a = 0; a < members.size(); a++) {
                String gruppe = members.elementAt(a).toString().substring(6);
                int b = gruppe.length() - 1;
                String membername = gruppe.toString().substring(0, b);
                DB_Groups.addGroupRelation(membername, groupname);
                User.getUserProfile_Stop(membername);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

}