class n5380646{
    private static String getToken(HttpClient client) throws Exception {
        String token = null;
        HttpGet httpget = new HttpGet("https://libsys.arlingtonva.us/iii/cas/login?service=http&scope=1");
        HttpResponse response = client.execute(httpget);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            entity = new BufferedHttpEntity(entity);
        }
        if (entity != null) {
            String resp = EntityUtils.toString(entity);
            EntityUtils.consume(entity);
            Pattern pattern = Pattern.compile("<input .*name=\"lt\".*value=\"(.*)\".*/>");
            Matcher matcher = pattern.matcher(resp);
            if (matcher.find()) {
                token = matcher.group(1);
            }
        }
        return token;
    }

}