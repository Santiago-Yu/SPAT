class n6354595{
    public static void getURLData(String url, String savePath) throws MalformedURLException, FileNotFoundException, IOException {
        if (DEBUG) begin(LOG, url, savePath);
        InputStream inputSream = null;
        InputStream bufferedInputStrem = null;
        OutputStream fileOutputStream = null;
        try {
            URL urlObj = new URL(url);
            inputSream = urlObj.openStream();
            bufferedInputStrem = new BufferedInputStream(inputSream);
            File file = new File(savePath);
            fileOutputStream = new FileOutputStream(file);
            byte[] buffer = new byte[0xFFFF];
            for (int len; (len = bufferedInputStrem.read(buffer)) != -1; ) {
                fileOutputStream.write(buffer, 0, len);
            }
        } finally {
            try {
                if (fileOutputStream != null) fileOutputStream.close();
                if (bufferedInputStrem != null) bufferedInputStrem.close();
                if (inputSream != null) inputSream.close();
            } catch (Exception e) {
                if (WARN) endWarn(LOG, e);
                e.printStackTrace();
            }
        }
        if (DEBUG) end(LOG);
    }

}