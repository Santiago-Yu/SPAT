    @Override
    public List<ProvaSolution[]> run(ProvaService prova, String agent, String key, String src) throws IOException {
        File file = new File(src);
        BufferedReader in;
        InputStream is = null;
        try {
            if (!file.exists() || !file.canRead()) {
                try {
                    is = Thread.currentThread().getContextClassLoader().getResourceAsStream(src);
                    in = new BufferedReader(new InputStreamReader(is));
                } catch (Exception ex1) {
                    try {
                        is = RuleReaderImpl.class.getResourceAsStream(src);
                        in = new BufferedReader(new InputStreamReader(is));
                    } catch (Exception ex2) {
                        try {
                            URL url = new URL(src);
                            in = new BufferedReader(new InputStreamReader(url.openStream()));
                        } catch (Exception ex3) {
                            throw new IOException("Cannot read from " + src);
                        }
                    }
                }
            } else {
                FileReader fr = new FileReader(file);
                in = new BufferedReader(fr);
            }
            List<ProvaSolution[]> results = prova.consult(agent, in, key);
            return results;
        } finally {
            if (is != null) is.close();
        }
    }
