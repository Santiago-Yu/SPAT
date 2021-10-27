class n14959920{
                public void run() {
                    try {
                        exists_ = true;
                        URL url = getContentURL();
                        URLConnection cnx = url.openConnection();
                        cnx.connect();
                        lastModified_ = cnx.getLastModified();
                        length_ = cnx.getContentLength();
                        type_ = cnx.getContentType();
                        if (isDirectory()) {
                            InputStream in = cnx.getInputStream();
                            BufferedReader nr = new BufferedReader(new InputStreamReader(in));
                            FuVectorString v = readList(nr);
                            nr.close();
                            v.sort();
                            v.uniq();
                            list_ = v.toArray();
                        }
                    } catch (Exception ex) {
                        exists_ = false;
                    }
                    done[0] = true;
                }

}