        @Override
        protected String doInBackground(Void... params) {
            HttpClient httpClient = new DefaultHttpClient();
            HttpContext localContext = new BasicHttpContext();
            HttpPost httpPost = new HttpPost(urlFormated);
            try {
                MultipartEntity entity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
                for (int index = 0; index < POSTparamList.size(); index++) {
                    if (POSTparamList.get(index).getName().equalsIgnoreCase("image")) {
                        entity.addPart(POSTparamList.get(index).getName(), new FileBody(new File(POSTparamList.get(index).getValue())));
                    } else {
                        entity.addPart(POSTparamList.get(index).getName(), new StringBody(POSTparamList.get(index).getValue()));
                    }
                }
                httpPost.setEntity(entity);
                HttpResponse response = httpClient.execute(httpPost, localContext);
                return processAnswer(response);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
