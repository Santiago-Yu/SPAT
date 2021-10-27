class n5644911{
    private static long writeVMDKFile(String absoluteFile, String urlString) throws Exception {
        URL urlCon = new URL(urlString);
        HttpsURLConnection conn = (HttpsURLConnection) urlCon.openConnection();
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setAllowUserInteraction(true);
        List cookies = (List) headers.get("Set-cookie");
        cookieValue = (String) cookies.get(0);
        StringTokenizer tokenizer = new StringTokenizer(cookieValue, ";");
        cookieValue = tokenizer.nextToken();
        String path = "$" + tokenizer.nextToken();
        String cookie = "$Version=\"1\"; " + cookieValue + "; " + path;
        Map map = new HashMap();
        map.put("Cookie", Collections.singletonList(cookie));
        ((BindingProvider) vimPort).getRequestContext().put(MessageContext.HTTP_REQUEST_HEADERS, map);
        conn.setRequestProperty("Cookie", cookie);
        conn.setRequestProperty("Content-Type", "application/octet-stream");
        conn.setRequestProperty("Expect", "100-continue");
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Length", "1024");
        InputStream in = conn.getInputStream();
        String localpath = localPath + "/" + absoluteFile;
        OutputStream out = new FileOutputStream(new File(localpath));
        byte[] buf = new byte[102400];
        int len = 0;
        long written = 0;
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
            written = written + len;
        }
        System.out.println("   Exported File " + absoluteFile + " : " + written);
        in.close();
        out.close();
        return written;
    }

}