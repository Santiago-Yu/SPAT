class n13041693{
    @Override
    public void vote(String urlString, Map<String, String> headData, Map<String, String> paramData) {
        HttpURLConnection httpConn = null;
        try {
            URL url = new URL(urlString);
            httpConn = (HttpURLConnection) url.openConnection();
            String cookies = getCookies(httpConn);
            System.out.println(cookies);
            BufferedReader post = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "GB2312"));
            String text = null;
            while ((text = post.readLine()) != null) {
                System.out.println(text);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new VoteBeanException("网址不正确", e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new VoteBeanException("不能打开网址", e);
        }
    }

}