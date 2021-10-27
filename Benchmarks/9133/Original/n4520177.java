class n4520177{
    public void fetchKey() throws IOException {
        String strurl = MessageFormat.format(keyurl, new Object[] { username, secret, login, session });
        StringBuffer result = new StringBuffer();
        BufferedReader reader = null;
        URL url = null;
        try {
            url = new URL(strurl);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = null;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
        } finally {
            try {
                if (reader != null) reader.close();
            } catch (Exception e) {
            }
        }
        Pattern p = Pattern.compile("<key>(.*)</key>");
        Matcher m = p.matcher(result.toString());
        if (m.matches()) {
            this.key = m.group(1);
        }
    }

}