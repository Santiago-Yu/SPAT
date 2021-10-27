    public String get(String url) {
        try {
            HttpGet get = new HttpGet(url);
            HttpResponse response = this.getHttpClient().execute(get);
            HttpEntity entity = response.getEntity();
            if (entity == null) {
                throw new RuntimeException("response body was empty");
            }
            return EntityUtils.toString(entity);
        } catch (RuntimeException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
