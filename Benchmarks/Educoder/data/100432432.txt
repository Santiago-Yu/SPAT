    String sendRequest(String[] getVars, String[] postVars, Object[] fileVars, boolean getSessionKey) throws IOException {
        String uri = wikiBaseURI;
        if (getVars != null) for (int i = 0; i + 1 < getVars.length; i += 2) uri += (i == 0 ? '?' : '&') + urlEncode(getVars[i]) + '=' + urlEncode(getVars[i + 1]);
        URL url = new URL(uri);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoInput(true);
        conn.setUseCaches(false);
        if (!getSessionKey) {
            String cookie = "";
            for (String key : cookies.keySet()) cookie += (cookie.length() == 0 ? "" : "; ") + key + "=" + cookies.get(key);
            conn.setRequestProperty("Cookie", cookie);
        }
        if (fileVars != null) {
            conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.connect();
            PrintStream ps = new PrintStream(conn.getOutputStream());
            for (int i = 0; fileVars != null && i + 2 < fileVars.length; i += 3) {
                ps.print("--" + boundary + "\r\n");
                postFile(ps, conn, (String) fileVars[i], (String) fileVars[i + 1], (byte[]) fileVars[i + 2]);
            }
            for (int i = 0; postVars != null && i + 1 < postVars.length; i += 2) ps.print("--" + boundary + "\r\n" + "Content-Disposition: " + "form-data; name=\"" + postVars[i] + "\"\r\n\r\n" + postVars[i + 1] + "\r\n");
            ps.println("--" + boundary + "--");
            ps.close();
        } else if (postVars != null) {
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.connect();
            PrintStream ps = new PrintStream(conn.getOutputStream());
            for (int i = 0; postVars != null && i + 1 < postVars.length; i += 2) ps.print((i == 0 ? "" : "&") + urlEncode(postVars[i]) + "=" + urlEncode(postVars[i + 1]));
            ps.close();
        }
        int httpCode = conn.getResponseCode();
        if (httpCode != 200) throw new IOException("HTTP code: " + httpCode);
        if (getSessionKey) getCookies(conn.getHeaderFields().get("Set-Cookie"));
        InputStream in = conn.getInputStream();
        response = "";
        byte[] buffer = new byte[1 << 16];
        for (; ; ) {
            int len = in.read(buffer);
            if (len < 0) break;
            response += new String(buffer, 0, len);
        }
        in.close();
        return response;
    }
