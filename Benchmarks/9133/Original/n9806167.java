class n9806167{
    private ArrayList<IdLocation> doGet(String identifier) throws IdLocatorException {
        String openurl = baseurl.toString() + "?url_ver=Z39.88-2004&rft_id=" + identifier;
        URL url;
        SRUSearchRetrieveResponse sru;
        try {
            url = new URL(openurl);
            HttpURLConnection huc = (HttpURLConnection) (url.openConnection());
            int code = huc.getResponseCode();
            if (code == 200) {
                sru = SRUSearchRetrieveResponse.read(huc.getInputStream());
            } else throw new IdLocatorException("cannot get " + url.toString());
        } catch (MalformedURLException e) {
            throw new IdLocatorException("A MalformedURLException occurred for " + openurl);
        } catch (IOException e) {
            throw new IdLocatorException("An IOException occurred attempting to connect to " + openurl);
        } catch (SRUException e) {
            throw new IdLocatorException("An SRUException occurred attempting to parse the response");
        }
        ArrayList<IdLocation> ids = new ArrayList<IdLocation>();
        for (SRUDC dc : sru.getRecords()) {
            IdLocation id = new IdLocation();
            id.setId(dc.getKeys(SRUDC.Key.IDENTIFIER).firstElement());
            id.setRepo(dc.getKeys(SRUDC.Key.SOURCE).firstElement());
            id.setDate(dc.getKeys(SRUDC.Key.DATE).firstElement());
            ids.add(id);
        }
        Collections.sort(ids);
        return ids;
    }

}