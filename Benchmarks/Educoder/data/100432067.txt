    private String copyImageFile(String urlString, String filePath) {
        FileOutputStream destination = null;
        File destination_file = null;
        String inLine;
        String dest_name = "";
        byte[] buffer;
        int bytes_read;
        int last_offset = 0;
        int offset = 0;
        InputStream imageFile = null;
        try {
            URL url = new URL(urlString);
            imageFile = url.openStream();
            dest_name = url.getFile();
            offset = 0;
            last_offset = 0;
            offset = dest_name.indexOf('/', offset + 1);
            while (offset > -1) {
                last_offset = offset + 1;
                offset = dest_name.indexOf('/', offset + 1);
            }
            dest_name = filePath + File.separator + dest_name.substring(last_offset);
            destination_file = new File(dest_name);
            if (destination_file.exists()) {
                if (destination_file.isFile()) {
                    if (!destination_file.canWrite()) {
                        System.out.println("FileCopy: destination " + "file is unwriteable: " + dest_name);
                    }
                    System.out.println("File " + dest_name + " already exists. File will be overwritten.");
                } else {
                    System.out.println("FileCopy: destination " + "is not a file: " + dest_name);
                }
            } else {
                File parentdir = parent(destination_file);
                if (!parentdir.exists()) {
                    System.out.println("FileCopy: destination " + "directory doesn't exist: " + dest_name);
                }
                if (!parentdir.canWrite()) {
                    System.out.println("FileCopy: destination " + "directory is unwriteable: " + dest_name);
                }
            }
            destination = new FileOutputStream(dest_name);
            buffer = new byte[1024];
            while (true) {
                bytes_read = imageFile.read(buffer);
                if (bytes_read == -1) break;
                destination.write(buffer, 0, bytes_read);
            }
        } catch (MalformedURLException ex) {
            System.out.println("Bad URL " + urlString);
        } catch (IOException ex) {
            System.out.println(" IO error: " + ex.getMessage());
        } finally {
            if (imageFile != null) {
                try {
                    imageFile.close();
                } catch (IOException e) {
                }
            }
            if (destination != null) {
                try {
                    destination.close();
                } catch (IOException e) {
                }
            }
        }
        return (dest_name);
    }
