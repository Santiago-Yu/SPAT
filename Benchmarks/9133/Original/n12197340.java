class n12197340{
    private void initBanner() {
        for (int k = 0; k < 3; k++) {
            if (bannerImg == null) {
                int i = getRandomId();
                imageURL = NbBundle.getMessage(BottomContent.class, "URL_BannerImageLink", Integer.toString(i));
                bannerURL = NbBundle.getMessage(BottomContent.class, "URL_BannerLink", Integer.toString(i));
                HttpContext context = new BasicHttpContext();
                context.setAttribute(ClientContext.COOKIE_STORE, cookieStore);
                HttpGet method = new HttpGet(imageURL);
                try {
                    HttpResponse response = ProxyManager.httpClient.execute(method, context);
                    HttpEntity entity = response.getEntity();
                    if (entity != null) {
                        bannerImg = new ImageIcon(ImageIO.read(entity.getContent()));
                        EntityUtils.consume(entity);
                    }
                } catch (IOException ex) {
                    bannerImg = null;
                } finally {
                    method.abort();
                }
            } else {
                break;
            }
        }
        if (bannerImg == null) {
            NotifyUtil.error("Banner Error", "Application could not get banner image. Please check your internet connection.", false);
        }
    }

}