    protected String readUrl(String svnUrl) throws IOException {
        URL url = new URL(svnUrl);
        URLConnection uc = url.openConnection();
        if (url.getProtocol().equals("https")) {
            String userPassword = user + ":" + password;
            String encoding = new sun.misc.BASE64Encoder().encode(userPassword.getBytes());
            uc.setRequestProperty("Authorization", "Basic " + encoding);
        }
        InputStream is = null;
        String in = null;
        try {
            is = uc.getInputStream();
            in = read(is);
        } finally {
            try {
                is.close();
            } catch (Exception e) {
            }
        }
        return in;
    }
