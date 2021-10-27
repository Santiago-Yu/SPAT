class n13068082 {
	public JobOfferPage(JobPageLink iX9ga74O) {
        this.link = iX9ga74O;
        try {
            URL FRUzf9ms = new URL(iX9ga74O.getUrl());
            URLConnection SScnlk8B = FRUzf9ms.openConnection();
            SScnlk8B.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.5; Windows NT 4.0)");
            SScnlk8B.setRequestProperty("Accept-Language", "en-us");
            this.content = (String) FRUzf9ms.getContent();
        } catch (IOException pfTv8zGa) {
            pfTv8zGa.printStackTrace();
        }
        this.jobOfferHtmlList = extractJobOfferHtmlList();
    }

}