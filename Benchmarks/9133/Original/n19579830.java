class n19579830{
    public static void copy(File toCopy, File dest) throws IOException {
        FileInputStream src = new FileInputStream(toCopy);
        FileOutputStream out = new FileOutputStream(dest);
        try {
            while (src.available() > 0) {
                out.write(src.read());
            }
        } finally {
            src.close();
            out.close();
        }
    }

}