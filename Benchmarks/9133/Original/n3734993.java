class n3734993{
    private void fetchAlignment() throws IOException {
        String urlString = BASE_URL + ALN_URL + DATASET_URL + "&family=" + mFamily;
        URL url = new URL(urlString);
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        processAlignment(in);
    }

}