    @Override
    public File call() throws IOException {
        HttpURLConnection conn = null;
        ReadableByteChannel fileDownloading = null;
        FileChannel fileWriting = null;
        try {
            conn = (HttpURLConnection) url.openConnection();
            if (size == -1) {
                size = conn.getContentLength();
            }
            fileDownloading = Channels.newChannel(conn.getInputStream());
            fileWriting = new FileOutputStream(file).getChannel();
            long left = size;
            long chunkSize = BLOCK_SIZE;
            for (long downloaded = 0; downloaded < size; left = size - downloaded) {
                if (left < BLOCK_SIZE) {
                    chunkSize = left;
                }
                fileWriting.transferFrom(fileDownloading, downloaded, chunkSize);
                downloaded += chunkSize;
                setProgress(downloaded);
            }
        } finally {
            if (file != null) {
                file.deleteOnExit();
            }
            if (conn != null) {
                conn.disconnect();
            }
            if (fileDownloading != null) {
                try {
                    fileDownloading.close();
                } catch (IOException ioe) {
                    Helper.logger.log(Level.SEVERE, "Не удалось закрыть поток скачивания", ioe);
                }
            }
            if (fileWriting != null) {
                try {
                    fileWriting.close();
                } catch (IOException ioe) {
                    Helper.logger.log(Level.SEVERE, "Не удалось закрыть поток записи в файл", ioe);
                }
            }
        }
        return file;
    }
