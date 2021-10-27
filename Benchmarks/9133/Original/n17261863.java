class n17261863{
    @Override
    public void parse() throws IOException {
        URL url = new URL(getDataUrl());
        URLConnection con = url.openConnection();
        BufferedReader bStream = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String s = bStream.readLine();
        String[] tokens = s.split("</html>");
        tokens = tokens[1].split("<br>");
        for (String sToken : tokens) {
            String[] sTokens = sToken.split(";");
            CurrencyUnit unit = new CurrencyUnit(sTokens[4], Float.valueOf(sTokens[9]), Integer.valueOf(sTokens[5]));
            this.set.add(unit);
        }
    }

}