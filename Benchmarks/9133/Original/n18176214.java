class n18176214{
    public boolean setTraceUrl(String s) {
        try {
            url = new URL(s);
            istream = url.openConnection();
            last_contentLenght = 0;
            reader = new BufferedReader(new InputStreamReader(istream.getInputStream()));
        } catch (MalformedURLException malformedurlexception) {
            System.out.println("Trace2Png: MalformedURLException: " + s);
            return false;
        } catch (IOException ioexception) {
            System.out.println("Trace2Png: IOException: " + s);
            return false;
        }
        trace = t2pNewTrace();
        return true;
    }

}