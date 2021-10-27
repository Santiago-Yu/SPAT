    public void get() {
        try {
            int cnt;
            URL url = new URL(urlStr);
            URLConnection conn = url.openConnection();
            conn.setDoInput(true);
            conn.setDoOutput(false);
            InputStream is = conn.getInputStream();
            String filename = new File(url.getFile()).getName();
            FileOutputStream fos = new FileOutputStream(dstDir + File.separator + filename);
            byte[] buffer = new byte[4096];
            while ((cnt = is.read(buffer, 0, buffer.length)) != -1) fos.write(buffer, 0, cnt);
            fos.close();
            is.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
