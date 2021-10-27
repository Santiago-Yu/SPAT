class n1939820{
    public void GetText(TextView content, String address) {
        String url = address;
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(url);
        try {
            HttpResponse response = client.execute(request);
            content.setText(TextHelper.GetText(response));
        } catch (Exception ex) {
            content.setText("Welcome to Fluo. Failed to connect to intro server.");
        }
    }

}