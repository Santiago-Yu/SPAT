    public static String read(ClassLoader classLoader, String name, boolean all) throws IOException {
        if (all) {
            StringMaker sm = new StringMaker();
            Enumeration enu = classLoader.getResources(name);
            while (enu.hasMoreElements()) {
                URL url = (URL) enu.nextElement();
                InputStream is = url.openStream();
                String s = read(is);
                if (s != null) {
                    sm.append(s);
                    sm.append(StringPool.NEW_LINE);
                }
                is.close();
            }
            return sm.toString().trim();
        } else {
            InputStream is = classLoader.getResourceAsStream(name);
            String s = read(is);
            is.close();
            return s;
        }
    }
