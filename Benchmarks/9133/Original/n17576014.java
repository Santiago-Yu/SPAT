class n17576014{
    public static String post(String actionUrl, Map<String, String> params, FormFile[] files) {
        try {
            String BOUNDARY = "---------7d4a6d158c9";
            String MULTIPART_FORM_DATA = "multipart/form-data";
            URL url = new URL(actionUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(6 * 1000);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("Charset", "UTF-8");
            conn.setRequestProperty("Content-Type", MULTIPART_FORM_DATA + "; boundary=" + BOUNDARY);
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                sb.append("--");
                sb.append(BOUNDARY);
                sb.append("\r\n");
                sb.append("Content-Disposition: form-data; name=\"" + entry.getKey() + "\"\r\n\r\n");
                sb.append(entry.getValue());
                sb.append("\r\n");
            }
            DataOutputStream outStream = new DataOutputStream(conn.getOutputStream());
            outStream.write(sb.toString().getBytes());
            for (FormFile file : files) {
                StringBuilder split = new StringBuilder();
                split.append("--");
                split.append(BOUNDARY);
                split.append("\r\n");
                split.append("Content-Disposition: form-data;name=\"" + file.getFileName() + "\";filename=\"" + file.getFileName() + "\"\r\n");
                split.append("Content-Type: " + file.getContentType() + "\r\n\r\n");
                outStream.write(split.toString().getBytes());
                outStream.write(file.getFileData(), 0, file.getFileData().length);
                outStream.write("\r\n".getBytes());
            }
            byte[] end_data = ("--" + BOUNDARY + "--\r\n").getBytes();
            outStream.write(end_data);
            outStream.flush();
            int cah = conn.getResponseCode();
            if (cah != 200) throw new RuntimeException("request URL failed");
            InputStream is = conn.getInputStream();
            int ch;
            StringBuilder b = new StringBuilder();
            while ((ch = is.read()) != -1) {
                b.append((char) ch);
            }
            Log.i("ItcastHttpPost", b.toString());
            outStream.close();
            conn.disconnect();
            return b.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}