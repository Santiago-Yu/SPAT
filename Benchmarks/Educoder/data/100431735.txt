    public void load(String url) throws IOException {
        this.url = url;
        int col = url.indexOf(':');
        if (col > 1 && col < 5) {
            load(new URL(url).openStream());
        } else {
            if (new File(url).exists()) {
                System.out.println("Loading JAD from file : " + url);
                FileInputStream fin = new FileInputStream(url);
                try {
                    load(fin);
                } finally {
                    fin.close();
                }
            } else {
                InputStream in = getClass().getResourceAsStream(url);
                if (in != null) {
                    System.out.println("Loading JAD from classpath : " + url);
                    load(in);
                } else {
                    throw new IOException("\"" + url + "\" was found in file system or classpath");
                }
            }
        }
    }
