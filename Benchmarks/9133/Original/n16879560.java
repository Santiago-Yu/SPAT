class n16879560{
            public void onClick(View v) {
                try {
                    HttpClient httpclient = new DefaultHttpClient();
                    HttpPost httppost = new HttpPost("https://mt0-app.cloud.cm/rpc/json");
                    List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
                    nameValuePairs.add(new BasicNameValuePair("m", "login"));
                    nameValuePairs.add(new BasicNameValuePair("c", "User"));
                    nameValuePairs.add(new BasicNameValuePair("password", "cloudisgreat"));
                    nameValuePairs.add(new BasicNameValuePair("alias", "cs588"));
                    httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                    String result = "";
                    try {
                        HttpResponse response = httpclient.execute(httppost);
                        result = EntityUtils.toString(response.getEntity());
                    } catch (Exception e) {
                        result = e.getMessage();
                    }
                    LayoutInflater inflater = (LayoutInflater) WebTest.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    final View layout = inflater.inflate(R.layout.window1, null);
                    final PopupWindow popup = new PopupWindowTest(layout, 100, 100);
                    Button b = (Button) layout.findViewById(R.id.test_button);
                    b.setOnTouchListener(new OnTouchListener() {

                        @Override
                        public boolean onTouch(View v, MotionEvent event) {
                            Log.d("Debug", "Button activate");
                            popup.dismiss();
                            return false;
                        }
                    });
                    popup.showAtLocation(layout, Gravity.CENTER, 0, 0);
                    View layout2 = inflater.inflate(R.layout.window1, null);
                    final PopupWindow popup2 = new PopupWindowTest(layout2, 100, 100);
                    TextView tview = (TextView) layout2.findViewById(R.id.pagetext);
                    tview.setText(result);
                    popup2.showAtLocation(layout, Gravity.CENTER, 50, -90);
                } catch (Exception e) {
                    Log.d("Debug", e.toString());
                }
            }

}