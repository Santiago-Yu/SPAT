class n12238227{
    public void doActionxxx() {
        try {
            System.out.println("app: ggc");
            String server_name = "http://192.168.4.3:8080/";
            server_name = server_name.trim();
            if (server_name.length() == 0) {
                server_name = "http://www.atech-software.com/";
            } else {
                if (!server_name.startsWith("http://")) server_name = "http://" + server_name;
                if (!server_name.endsWith("/")) server_name = server_name + "/";
            }
            URL url = new URL(server_name + "ATechUpdateGetFile?" + "" + "file_id=1" + "&" + "version_requested=1");
            InputStream is = url.openStream();
            RandomAccessFile raf = new RandomAccessFile("/home/andy/test.jpg", "rw");
            ArrayList<Integer> list = new ArrayList<Integer>();
            float size = 671200;
            long current_size = 0;
            System.out.println("File size: " + is.available());
            byte[] array = new byte[1024];
            while (is.available() > 0) {
                if (is.available() < 1024) {
                    array = new byte[is.available()];
                }
                is.read(array);
                raf.write(array);
                current_size += array.length;
                System.out.println("Progress: " + ((current_size / size) * 100));
            }
            System.out.println("Size Arr: " + list.size());
            CheckSumUtility csu = new CheckSumUtility();
            System.out.println("Checksum: " + csu.getChecksumValue("/home/andy/test.jpg"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}