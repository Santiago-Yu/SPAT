class n1069284{
            @Override
            public void run() {
                String url = "http://" + resources.getString(R.string.host) + path;
                HttpUriRequest req;
                if (dataToSend == null) {
                    req = new HttpGet(url);
                } else {
                    req = new HttpPost(url);
                    try {
                        ((HttpPost) req).setEntity(new StringEntity(dataToSend));
                    } catch (UnsupportedEncodingException e) {
                        Logger.getLogger(JSBridge.class.getName()).log(Level.SEVERE, "Unsupported encoding.", e);
                    }
                }
                req.addHeader("Cookie", getAuthCookie(false));
                try {
                    HttpResponse response = httpclient.execute(req);
                    Logger.getLogger(JSBridge.class.getName()).log(Level.INFO, "Response status is '" + response.getStatusLine() + "'.");
                    HttpEntity entity = response.getEntity();
                    if (entity != null) {
                        InputStream instream = entity.getContent();
                        try {
                            BufferedReader in = new BufferedReader(new InputStreamReader(instream));
                            StringBuilder b = new StringBuilder();
                            String line;
                            boolean first = true;
                            while ((line = in.readLine()) != null) {
                                b.append(line);
                                if (first) {
                                    first = false;
                                } else {
                                    b.append("\r\n");
                                }
                            }
                            in.close();
                            callback.success(b.toString());
                            return;
                        } catch (RuntimeException ex) {
                            throw ex;
                        } finally {
                            instream.close();
                        }
                    }
                } catch (ClientProtocolException e) {
                    Logger.getLogger(JSBridge.class.getName()).log(Level.SEVERE, "HTTP protocol violated.", e);
                } catch (IOException e) {
                    Logger.getLogger(JSBridge.class.getName()).log(Level.WARNING, "Could not load '" + path + "'.", e);
                }
                Logger.getLogger(JSBridge.class.getName()).log(Level.INFO, "Calling error from JSBridge.getPage because of previous errors.");
                callback.error();
            }

}