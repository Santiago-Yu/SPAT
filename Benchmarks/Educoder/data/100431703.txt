    public void run() {
        if (status == COMPLETE) {
            return;
        }
        waitRandom();
        RandomAccessFile file = null;
        InputStream inputStream = null;
        boolean success = false;
        URL url = null;
        try {
            BeatportAccessor beatportAccessor = new BeatportAccessor();
            if (sessionCookies == null) {
                sessionCookies = beatportAccessor.getSessionCookies(user, password);
            }
            url = new URL(new BeatportAccessor().getTrackDownloadUrl(downloadId, sessionCookies));
            log.info("Open (DownloadWorker.run): " + url);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("User-Agent", BeatportAccessor.userAgent);
            connection.setRequestProperty("Cookie", sessionCookies);
            connection.connect();
            if (connection.getResponseCode() / 100 != 2) {
                log.error("Unexpected response from server: " + connection.getResponseCode());
                error();
                return;
            }
            if (connection.getContentType().indexOf("text") >= 0) {
                log.error("Tried to request: " + url.toString());
                log.error("Unexpected file content type from server: " + connection.getContentType());
                log.error("Server replied:\n" + getContentAsString(connection));
                error();
                return;
            }
            int contentLength = connection.getContentLength();
            if (contentLength < 1) {
                log.error("Invalid content length: " + connection.getContentLength());
                error();
                return;
            }
            if (size == -1) {
                size = contentLength;
                stateChanged();
            } else if (size != contentLength) {
                changeTotal(0, contentLength - size);
            }
            if (new File(tmpFileName(fileName)).exists()) {
                if (!new File(tmpFileName(fileName)).delete()) {
                    throw new Exception("Could not delete file: " + tmpFileName(fileName));
                }
            }
            file = new RandomAccessFile(tmpFileName(fileName), "rw");
            file.seek(downloaded);
            inputStream = connection.getInputStream();
            if (started == 0) {
                started = System.currentTimeMillis();
                time = started;
            }
            statusChangedObserver.statusChanged(status);
            byte buffer[] = new byte[MAX_BUFFER_SIZE];
            while (status == DOWNLOADING) {
                if (size - downloaded < MAX_BUFFER_SIZE) {
                    buffer = new byte[(int) (size - downloaded)];
                }
                int read = inputStream.read(buffer);
                if (read == -1) break;
                file.write(buffer, 0, read);
                downloaded += read;
                changeTotal(read, 0);
                stateChanged();
            }
            if (status == DOWNLOADING) {
                stopped = System.currentTimeMillis();
                status = COMPLETE;
            }
            statusChangedObserver.statusChanged(status);
            stateChanged();
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
            error();
        } finally {
            try {
                file.close();
            } catch (Exception e) {
            }
            if (success) {
                try {
                    if (!new File(tmpFileName(fileName)).renameTo(new File(fileName))) {
                        throw new Exception("Rename Failed");
                    }
                } catch (Exception e) {
                    log.error("Error moving temp file " + tmpFileName(fileName) + " file: " + fileName, e);
                }
            } else {
                try {
                    new File(tmpFileName(fileName)).delete();
                } catch (Exception e) {
                    log.error("Error deleting erroneous temp file: " + tmpFileName(fileName), e);
                }
            }
            try {
                inputStream.close();
            } catch (Exception e) {
                log.error("Error closing input stream of: " + url + " / " + fileName, e);
            }
        }
    }
