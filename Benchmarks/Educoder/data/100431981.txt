    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mButton1 = (Button) findViewById(R.id.myButton1);
        mButton2 = (Button) findViewById(R.id.myButton2);
        mTextView1 = (TextView) findViewById(R.id.myTextView1);
        mButton1.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                String uriAPI = "http://www.sina.com";
                HttpPost httpRequest = new HttpPost(uriAPI);
                List<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("str", "post string"));
                try {
                    httpRequest.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
                    HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
                    if (httpResponse.getStatusLine().getStatusCode() == 200) {
                        String strResult = EntityUtils.toString(httpResponse.getEntity());
                        mTextView1.setText(strResult);
                    } else {
                        mTextView1.setText("Error Response: " + httpResponse.getStatusLine().toString());
                    }
                } catch (ClientProtocolException e) {
                    mTextView1.setText(e.getMessage().toString());
                    e.printStackTrace();
                } catch (IOException e) {
                    mTextView1.setText(e.getMessage().toString());
                    e.printStackTrace();
                } catch (Exception e) {
                    mTextView1.setText(e.getMessage().toString());
                    e.printStackTrace();
                }
            }
        });
        mButton2.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                String uriAPI = "http://www.sina.com";
                HttpGet httpRequest = new HttpGet(uriAPI);
                try {
                    HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
                    if (httpResponse.getStatusLine().getStatusCode() == 200) {
                        String strResult = EntityUtils.toString(httpResponse.getEntity());
                        strResult = eregi_replace("(\r\n|\r|\n|\n\r)", "", strResult);
                        mTextView1.setText(strResult);
                    } else {
                        mTextView1.setText("Error Response: " + httpResponse.getStatusLine().toString());
                    }
                } catch (ClientProtocolException e) {
                    mTextView1.setText(e.getMessage().toString());
                    e.printStackTrace();
                } catch (IOException e) {
                    mTextView1.setText(e.getMessage().toString());
                    e.printStackTrace();
                } catch (Exception e) {
                    mTextView1.setText(e.getMessage().toString());
                    e.printStackTrace();
                }
            }
        });
    }
