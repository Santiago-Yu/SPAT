class n7199174{
    public static BufferedInputStream getEventAttacchment(final String url) throws IOException {
        int slashIndex = url.lastIndexOf("/");
        String encodedUrl = url.substring(0, slashIndex + 1) + URLEncoder.encode(url.substring(slashIndex + 1), "UTF-8");
        String urlwithtoken = encodedUrl + "?ticket=" + getToken();
        BufferedInputStream in = new BufferedInputStream(new URL(urlwithtoken).openStream());
        return in;
    }

}