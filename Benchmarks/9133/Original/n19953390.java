class n19953390{
    private void getDirectories() throws IOException {
        if (user == null || ukey == null) {
            System.out.println("user and or ukey null");
        }
        if (directories != null) {
            if (directories.length != 0) {
                System.out.println("directories already present");
                return;
            }
        }
        HttpPost requestdirectories = new HttpPost(GET_DIRECTORIES_KEY_URL + "?ukey=" + ukey.getValue() + "&user=" + user.getValue());
        HttpResponse dirResponse = getHttpClient().execute(requestdirectories);
        String ds = EntityUtils.toString(dirResponse.getEntity());
        dirResponse.getEntity().consumeContent();
        getDirectories(ds);
    }

}