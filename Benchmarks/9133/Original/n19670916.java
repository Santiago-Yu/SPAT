class n19670916{
    private void pushResource(String peerId, String communityId, String resourceFilePath, List<String> attachmentFilePaths) throws IOException {
        String urlString = "http://" + peerId + "/upload";
        HttpURLConnection uploadConnection = null;
        DataOutputStream connOutput = null;
        FileInputStream fileInput = null;
        String lineEnd = "\r\n";
        String twoHyphens = "--";
        String boundary = "232404jkg4220957934FW";
        int bytesRead, bytesAvailable, bufferSize;
        byte[] buffer;
        int maxBufferSize = 1 * 1024 * 1024;
        try {
            File resourceFile = new File(resourceFilePath);
            if (!resourceFile.exists()) {
                LOG.error("JTellaAdapter: Resource file could not be found for push: " + resourceFilePath);
                return;
            }
            List<File> attachments = new ArrayList<File>();
            for (String attachmentPath : attachmentFilePaths) {
                File attachFile = new File(attachmentPath);
                if (!attachFile.exists()) {
                    LOG.error("JTellaAdapter: Attachment file could not be found for push: " + attachmentPath);
                    return;
                }
                attachments.add(attachFile);
            }
            LOG.debug("JTellaAdapter: Initiating push to: " + urlString);
            URL url = new URL(urlString);
            uploadConnection = (HttpURLConnection) url.openConnection();
            uploadConnection.setDoInput(true);
            uploadConnection.setDoOutput(true);
            uploadConnection.setUseCaches(false);
            uploadConnection.setRequestMethod("POST");
            uploadConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
            uploadConnection.setRequestProperty("Connection", "Keep-Alive");
            uploadConnection.setRequestProperty("User-Agent", "UP2P");
            uploadConnection.setRequestProperty("Accept", "[star]/[star]");
            connOutput = new DataOutputStream(uploadConnection.getOutputStream());
            connOutput.writeBytes(twoHyphens + boundary + lineEnd);
            connOutput.writeBytes("Content-Disposition: form-data; name=\"up2p:community\"" + lineEnd + lineEnd);
            connOutput.writeBytes(communityId + lineEnd);
            connOutput.writeBytes(twoHyphens + boundary + lineEnd);
            connOutput.writeBytes("Content-Disposition: form-data; name=\"up2p:pushupload\"" + lineEnd + lineEnd + "true" + lineEnd);
            connOutput.writeBytes(twoHyphens + boundary + lineEnd);
            boolean fileWriteComplete = false;
            boolean resourceFileWritten = false;
            File nextFile = null;
            while (!fileWriteComplete) {
                if (!resourceFileWritten) {
                    nextFile = resourceFile;
                } else {
                    nextFile = attachments.remove(0);
                }
                LOG.debug("JTellaAdapter: PUSHing file: " + nextFile.getAbsolutePath());
                connOutput.writeBytes("Content-Disposition: form-data; name=\"up2p:filename\";" + " filename=\"" + nextFile.getName() + "\"" + lineEnd);
                connOutput.writeBytes(lineEnd);
                fileInput = new FileInputStream(nextFile);
                bytesAvailable = fileInput.available();
                bufferSize = Math.min(bytesAvailable, maxBufferSize);
                buffer = new byte[bufferSize];
                bytesRead = fileInput.read(buffer, 0, bufferSize);
                while (bytesRead > 0) {
                    connOutput.write(buffer, 0, bufferSize);
                    bytesAvailable = fileInput.available();
                    bufferSize = Math.min(bytesAvailable, maxBufferSize);
                    bytesRead = fileInput.read(buffer, 0, bufferSize);
                }
                connOutput.writeBytes(lineEnd);
                if (attachments.isEmpty()) {
                    connOutput.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);
                } else {
                    connOutput.writeBytes(twoHyphens + boundary + lineEnd);
                }
                resourceFileWritten = true;
                if (attachments.isEmpty()) {
                    fileWriteComplete = true;
                }
            }
            BufferedReader inStream = new BufferedReader(new InputStreamReader(uploadConnection.getInputStream()));
            while (inStream.readLine() != null) ;
            inStream.close();
            LOG.debug("JTellaAdapter: Push upload was succesful.");
        } catch (MalformedURLException ex) {
            LOG.error("JTellaAdapter: pushResource Malformed URL: " + ex);
            throw new IOException("pushResource failed for URL: " + urlString);
        } catch (IOException ioe) {
            LOG.error("JTellaAdapter: pushResource IOException: " + ioe);
            throw new IOException("pushResource failed for URL: " + urlString);
        } finally {
            try {
                if (fileInput != null) {
                    fileInput.close();
                }
                if (connOutput != null) {
                    connOutput.flush();
                }
                if (connOutput != null) {
                    connOutput.close();
                }
                if (uploadConnection != null) {
                    uploadConnection.disconnect();
                }
            } catch (IOException e) {
                LOG.error("JTellaAdapter: pushResource failed to close connection streams.");
            }
        }
    }

}