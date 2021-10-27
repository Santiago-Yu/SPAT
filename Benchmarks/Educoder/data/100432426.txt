    private InputStream sendRequest(SequenceI seq) throws UnsupportedEncodingException, IOException {
        StringBuilder putBuf = new StringBuilder();
        processOptions(putBuf);
        putBuf.append("INPUT_SEQUENCE=");
        putBuf.append(URLEncoder.encode(">" + seq.getName() + "\n", ENCODING));
        putBuf.append(URLEncoder.encode(seq.getResidues(), ENCODING));
        URL url = new URL(PRIMER_BLAST_URL);
        URLConnection conn = url.openConnection();
        conn.setDoOutput(true);
        OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
        wr.write(putBuf.toString());
        wr.flush();
        wr.close();
        apollo.util.IOUtil.informationDialog("Primer-BLAST request sent");
        return conn.getInputStream();
    }
