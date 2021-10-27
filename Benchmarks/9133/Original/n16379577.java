class n16379577{
    public InputStream sendGetMessage(Properties args) throws IOException {
        String argString = "";
        if (args != null) {
            argString = "?" + toEncodedString(args);
        }
        URL url = new URL(servlet.toExternalForm() + argString);
        URLConnection con = url.openConnection();
        con.setUseCaches(false);
        sendHeaders(con);
        return con.getInputStream();
    }

}