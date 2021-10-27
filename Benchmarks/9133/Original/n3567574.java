class n3567574{
    @Override
    protected String doInBackground(String... params) {
        Bitmap bm = null;
        if (params.length == 0) return null;
        String urlStr = params[0];
        url = urlStr;
        String md5 = "";
        try {
            md5 = md5(urlStr);
            File f = context.getFileStreamPath(md5 + FILE_EXT);
            if (f.exists()) {
                return f.getAbsolutePath();
            }
        } catch (FileNotFoundException fnf) {
        } catch (Exception e1) {
        }
        InputStream is = null;
        try {
            if (urlStr != null && url.indexOf("http://{HOST}:{PORT}") != -1) {
                urlStr = urlStr.replace("{HOST}", ConnectionHandler.host);
                urlStr = urlStr.replace("{PORT}", ConnectionHandler.port + "");
            }
            URL url = new URL(urlStr);
            URLConnection conn = url.openConnection();
            conn.connect();
            is = conn.getInputStream();
            bm = BitmapFactory.decodeStream(is);
        } catch (IOException e) {
            Log.i(TAG, "Download of image failed: " + e.getMessage());
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                }
            }
        }
        if (bm != null) {
            FileOutputStream fos = null;
            try {
                fos = context.openFileOutput(md5 + FILE_EXT, Context.MODE_WORLD_READABLE);
                bm.compress(CompressFormat.JPEG, 90, fos);
            } catch (Exception e) {
                Log.e(TAG, "Storage of image failed: " + e.getMessage());
            } finally {
                if (fos != null) {
                    try {
                        fos.flush();
                        fos.close();
                    } catch (IOException e) {
                    }
                }
                if (bm != null) {
                    bm.recycle();
                }
            }
        }
        File f = context.getFileStreamPath(md5 + FILE_EXT);
        if (f.exists()) {
            return f.getAbsolutePath();
        }
        return null;
    }

}