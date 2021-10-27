class n13068082{
    public JobOfferPage(JobPageLink link) {
        this.link = link;
        try {
            URL url = new URL(link.getUrl());
            URLConnection urlConn = url.openConnection();
            urlConn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.5; Windows NT 4.0)");
            urlConn.setRequestProperty("Accept-Language", "en-us");
            this.content = (String) url.getContent();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.jobOfferHtmlList = extractJobOfferHtmlList();
    }

}