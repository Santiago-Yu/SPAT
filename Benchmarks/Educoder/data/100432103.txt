    public static boolean loadContentFromURL(String fromURL, String toFile) {
        try {
            URL url = new URL("http://bible-desktop.com/xml" + fromURL);
            File file = new File(toFile);
            URLConnection ucon = url.openConnection();
            InputStream is = ucon.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            ByteArrayBuffer baf = new ByteArrayBuffer(50);
            int current = 0;
            while ((current = bis.read()) != -1) {
                baf.append((byte) current);
            }
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(baf.toByteArray());
            fos.close();
        } catch (IOException e) {
            Log.e(TAG, e);
            return false;
        }
        return true;
    }
