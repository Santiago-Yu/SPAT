class n12844597{
        private String findTitle(URL url) {
            HTMLEditorKit.ParserCallback callback;
            try {
                URLConnection conn = url.openConnection();
                Reader rd = new InputStreamReader(conn.getInputStream());
                ParserDelegator parser = new ParserDelegator();
                callback = new Callback();
                parser.parse(rd, callback, true);
            } catch (Exception exp) {
                System.err.println(exp);
            }
            return title;
        }

}