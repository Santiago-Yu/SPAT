class n22726124{
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:9090/node/Insert/" + args[0] + "?address=blah");
        URLConnection conn = url.openConnection();
        conn.setDoOutput(true);
        OutputStream os = conn.getOutputStream();
        Conduit.pump(System.in, os);
        Conduit.pump(conn.getInputStream(), System.out);
        System.out.println("done");
    }

}