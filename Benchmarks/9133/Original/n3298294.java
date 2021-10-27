class n3298294{
    public static String upload_file(String sessionid, String localFilePath, String remoteTagPath) {
        String jsonstring = "If you see this message, there is some problem inside the function:upload_file()";
        String srcPath = localFilePath;
        String uploadUrl = "https://s2.cloud.cm/rpc/json/?session_id=" + sessionid + "&c=Storage&m=upload_file&tag=" + remoteTagPath;
        String end = "\r\n";
        String twoHyphens = "--";
        String boundary = "******";
        try {
            URL url = new URL(uploadUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
            httpURLConnection.setRequestProperty("Charset", "UTF-8");
            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
            DataOutputStream dos = new DataOutputStream(httpURLConnection.getOutputStream());
            dos.writeBytes(twoHyphens + boundary + end);
            dos.writeBytes("Content-Disposition: form-data; name=\"file\"; filename=\"" + srcPath.substring(srcPath.lastIndexOf("/") + 1) + "\"" + end);
            dos.writeBytes(end);
            FileInputStream fis = new FileInputStream(srcPath);
            byte[] buffer = new byte[8192];
            int count = 0;
            while ((count = fis.read(buffer)) != -1) {
                dos.write(buffer, 0, count);
            }
            fis.close();
            dos.writeBytes(end);
            dos.writeBytes(twoHyphens + boundary + twoHyphens + end);
            dos.flush();
            InputStream is = httpURLConnection.getInputStream();
            InputStreamReader isr = new InputStreamReader(is, "utf-8");
            BufferedReader br = new BufferedReader(isr);
            jsonstring = br.readLine();
            dos.close();
            is.close();
            return jsonstring;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonstring;
    }

}