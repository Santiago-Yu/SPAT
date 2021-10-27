class n6573748{
    public static void main(String[] args) {
        Stopwatch.start("");
        HtmlParser parser = new HtmlParser();
        try {
            Stopwatch.printTimeReset("", "> ParserDelegator");
            ParserDelegator del = new ParserDelegator();
            Stopwatch.printTimeReset("", "> url");
            URL url = new URL(args[0]);
            Stopwatch.printTimeReset("", "> openStrem");
            InputStream is = url.openStream();
            Stopwatch.printTimeReset("", "< parse");
            del.parse(new InputStreamReader(is), parser, true);
            Stopwatch.printTimeReset("", "< parse");
        } catch (Throwable t) {
            t.printStackTrace();
        }
        Stopwatch.printTimeReset("", "> traversal");
        TreeTraversal.traverse(parser.startTag, "eachChild", new Function() {

            String lastPath = null;

            public void apply(Object obj) {
                if (obj instanceof String) {
                    System.out.print(lastPath + ":");
                    System.out.println(obj);
                    return;
                }
                Tag t = (Tag) obj;
                lastPath = Utils.tagPath(t);
                System.out.println(lastPath);
            }
        });
        Stopwatch.printTimeReset("", "< traversal");
    }

}