class n23113417{
    public TreeNode fetchArchive(TreeNode owner, int id) throws Exception {
        builder.start(owner, false);
        parser.setDocumentHandler(builder);
        String arg = server + "?todo=archive&db=" + db + "&document=" + document + "&id=" + id;
        URL url = new URL(arg);
        URLConnection con = url.openConnection();
        con.setUseCaches(false);
        con.connect();
        InputSource xmlInput = new InputSource(new InputStreamReader(con.getInputStream(), "ISO-8859-1"));
        parser.parse(xmlInput);
        return owner;
    }

}