class n15903468{
    private String[] getHersheyFontNames() {
        String[] fontNames = null;
        URL url = HersheyFont.class.getResource("futural.jhf");
        String protocol = url.getProtocol();
        if (protocol.equals("file")) {
            File f = new File(url.getFile());
            f = f.getParentFile();
            FilenameFilter filter = new FilenameFilter() {

                public boolean accept(File dir, String name) {
                    return name.endsWith(".jhf");
                }
            };
            String[] children = f.list(filter);
            if (children == null) {
                return null;
            }
            fontNames = new String[children.length];
            for (int i = 0; i < children.length; i++) {
                fontNames[i] = children[i].substring(0, children[i].length() - 4);
            }
        } else if (protocol.equals("jar")) {
            try {
                JarURLConnection jarURL = (JarURLConnection) url.openConnection();
                ZipFile zf = new ZipFile(jarURL.getJarFile().getName());
                Enumeration e = zf.entries();
                Vector namesVector = new Vector();
                while (e.hasMoreElements()) {
                    ZipEntry ze = (ZipEntry) e.nextElement();
                    String name = ze.getName();
                    if (name.startsWith("visad/util/") && name.endsWith(".jhf")) {
                        namesVector.add(name.substring(11));
                    }
                }
                zf.close();
                if (namesVector.size() == 0) {
                    return null;
                }
                fontNames = new String[namesVector.size()];
                for (int i = 0; i < fontNames.length; i++) {
                    String name = (String) namesVector.elementAt(i);
                    fontNames[i] = name.substring(0, name.length() - 4);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            System.out.println("Cannot locate the HersheyFonts.");
        }
        return fontNames;
    }

}