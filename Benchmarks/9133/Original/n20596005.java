class n20596005{
    public APIResponse delete(String id) throws Exception {
        APIResponse response = new APIResponse();
        connection = (HttpURLConnection) new URL(url + "/api/item/delete/" + id).openConnection();
        connection.setRequestMethod("DELETE");
        connection.setConnectTimeout(TIMEOUT);
        connection.connect();
        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            response.setDone(true);
            response.setMessage("Item Deleted!");
        } else {
            response.setDone(false);
            response.setMessage("Delete Item Error Code: Http (" + connection.getResponseCode() + ")");
        }
        connection.disconnect();
        return response;
    }

}