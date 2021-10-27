class n11646823{
    public String getContentAsString(String url) {
        StringBuffer sb = new StringBuffer("");
        try {
            URL urlmy = new URL(url);
            HttpURLConnection con = (HttpURLConnection) urlmy.openConnection();
            HttpURLConnection.setFollowRedirects(true);
            con.setInstanceFollowRedirects(false);
            con.connect();
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            String s = "";
            while ((s = br.readLine()) != null) {
                sb.append(s + "\r\n");
            }
            con.disconnect();
        } catch (Exception ex) {
            this.logException(ex);
        }
        return sb.toString();
    }

}