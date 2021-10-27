class n11738613{
    public String move(Integer param) {
        LOG.debug("move " + param);
        StringBuffer ret = new StringBuffer();
        try {
            URL url = new URL("http://" + host + "/decoder_control.cgi?command=" + param + "&user=" + user + "&pwd=" + password);
            URLConnection con = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                ret.append(inputLine);
            }
            in.close();
        } catch (Exception e) {
            logException(e);
            connect(host, user, password);
        }
        return ret.toString();
    }

}