    public static String ReadURL(URL url, boolean textonly) {
        try {
            URLConnection uconn = url.openConnection();
            Object ucont = uconn.getContent();
            if (ucont instanceof InputStream) return ReadInputStream((java.io.InputStream) ucont, textonly); else return "" + ucont;
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return null;
    }
