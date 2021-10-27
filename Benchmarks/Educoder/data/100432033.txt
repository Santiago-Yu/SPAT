    @Override
    public EntrySet read(EntrySet set) throws ReadFailedException {
        if (!SourceCache.contains(url)) {
            SSL.certify(url);
            try {
                super.setParser(Parser.detectParser(url.openStream()));
                final PipedInputStream in = new PipedInputStream();
                final PipedOutputStream forParser = new PipedOutputStream(in);
                new Thread(new Runnable() {

                    public void run() {
                        try {
                            OutputStream out = SourceCache.startCaching(url);
                            InputStream is = url.openStream();
                            byte[] buffer = new byte[100000];
                            while (true) {
                                int amountRead = is.read(buffer);
                                if (amountRead == -1) {
                                    break;
                                }
                                forParser.write(buffer, 0, amountRead);
                                out.write(buffer, 0, amountRead);
                            }
                            forParser.close();
                            out.close();
                            SourceCache.finish(url);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                super.setIos(in);
            } catch (Exception e) {
                throw new ReadFailedException(e);
            }
            return super.read(set);
        } else {
            try {
                return SourceCache.get(url).read(set);
            } catch (IOException e) {
                throw new ReadFailedException(e);
            }
        }
    }
