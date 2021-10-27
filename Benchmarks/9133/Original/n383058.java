class n383058{
    public static boolean getFile(String s, String name) {
        try {
            File f = new File("D:\\buttons\\data\\sounds\\" + name);
            URL url = new URL(s);
            URLConnection conn = url.openConnection();
            BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
            int ch;
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(f));
            while ((ch = bis.read()) != -1) {
                bos.write(ch);
            }
            System.out.println("wrote audio url: " + s + " \nto file " + f);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}