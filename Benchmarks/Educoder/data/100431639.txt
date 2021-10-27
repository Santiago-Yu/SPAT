    public Reader getGETReader_bak(URL url) {
        Reader reader = null;
        if (Navigator.isVerbose()) System.out.println("Web3DService.getGETReader caching " + url);
        int contentLength = -1;
        URLConnection urlc;
        try {
            urlc = url.openConnection();
            urlc.setReadTimeout(Navigator.TIME_OUT);
            if (getEncoding() != null) {
                urlc.setRequestProperty("Authorization", "Basic " + getEncoding());
            }
            urlc.connect();
            String content_type = urlc.getContentType();
            if (content_type == null || content_type.equalsIgnoreCase("x-world/x-vrml") || content_type.equalsIgnoreCase("model/vrml") || content_type.equalsIgnoreCase("model/vrml;charset=ISO-8859-1")) {
                InputStream is = urlc.getInputStream();
                DataInputStream d = new DataInputStream(is);
                contentLength = urlc.getContentLength();
                byte[] content = new byte[contentLength];
                if (d != null) {
                    d.readFully(content, 0, contentLength);
                }
                is.close();
                d.close();
                ByteArrayInputStream bais = new ByteArrayInputStream(content);
                reader = new InputStreamReader(bais);
            } else if (content_type.equalsIgnoreCase("model/vrml.gzip")) {
                InputStream is = urlc.getInputStream();
                BufferedInputStream bis = new BufferedInputStream(is);
                GZIPInputStream gis = new GZIPInputStream(bis);
                StringBuffer sb = new StringBuffer();
                BufferedReader zipReader = new BufferedReader(new InputStreamReader(gis));
                char chars[] = new char[10240];
                int len = 0;
                contentLength = 0;
                while ((len = zipReader.read(chars, 0, chars.length)) >= 0) {
                    sb.append(chars, 0, len);
                    contentLength += len;
                }
                chars = null;
                gis.close();
                zipReader.close();
                bis.close();
                is.close();
                reader = new StringReader(sb.toString());
            } else if (content_type.equalsIgnoreCase("model/vrml.encrypted")) {
                InputStream is = urlc.getInputStream();
                StringBuffer sb = new StringBuffer();
                Cipher pbeCipher = createCipher();
                if (pbeCipher != null) {
                    CipherInputStream cis = new CipherInputStream(is, pbeCipher);
                    BufferedReader bufReader = new BufferedReader(new InputStreamReader(cis));
                    char chars[] = new char[1024];
                    int len = 0;
                    contentLength = 0;
                    while ((len = bufReader.read(chars, 0, chars.length)) >= 0) {
                        sb.append(chars, 0, len);
                        contentLength += len;
                    }
                    chars = null;
                    cis.close();
                    bufReader.close();
                    reader = new StringReader(sb.toString());
                }
            } else if (content_type.equalsIgnoreCase("model/vrml.gzip.encrypted")) {
                InputStream is = urlc.getInputStream();
                StringBuffer sb = new StringBuffer();
                Cipher pbeCipher = createCipher();
                if (pbeCipher != null) {
                    CipherInputStream cis = new CipherInputStream(is, pbeCipher);
                    GZIPInputStream gis = new GZIPInputStream(cis);
                    BufferedReader bufReader = new BufferedReader(new InputStreamReader(gis));
                    char chars[] = new char[1024];
                    int len = 0;
                    contentLength = 0;
                    while ((len = bufReader.read(chars, 0, chars.length)) >= 0) {
                        sb.append(chars, 0, len);
                        contentLength += len;
                    }
                    chars = null;
                    bufReader.close();
                    gis.close();
                    cis.close();
                    reader = new StringReader(sb.toString());
                }
            } else if (content_type.equalsIgnoreCase("text/html;charset=utf-8")) {
                System.out.println("text/html;charset=utf-8");
            } else {
                System.err.println("ContentNegotiator.startLoading unsupported MIME type: " + content_type);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reader;
    }
