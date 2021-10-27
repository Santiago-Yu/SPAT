        private void downloadFile(final String downloadUrl, final String destinationFile) throws IOException {
            HttpClient client = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(downloadUrl);
            final File outputFile = new File(destinationFile);
            createParentDirectories(outputFile);
            FileOutputStream outputStream;
            outputStream = new FileOutputStream(outputFile);
            final HttpResponse response = client.execute(httpGet);
            if (isInterrupted()) {
                outputStream.close();
                return;
            }
            final HttpEntity entity = response.getEntity();
            InputStream inputStream = null;
            try {
                if (entity != null) {
                    inputStream = entity.getContent();
                    CopyStreamStatusCallback callback = new CopyStreamStatusCallback() {

                        @Override
                        public long getSkipBetweenUpdates() {
                            return entity.getContentLength() * 2 / PERCENTAGE_BASE;
                        }

                        @Override
                        public void onUpdate(final long copiedLength) {
                            int percentage = (int) (copiedLength * PERCENTAGE_BASE / entity.getContentLength());
                            handleUpdate(STATUS_DOWNLOADING, percentage);
                        }
                    };
                    copyStreams(inputStream, outputStream, callback);
                }
            } finally {
                try {
                    outputStream.close();
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (IOException e) {
                    Log.v(DictionaryForMIDs.LOG_TAG, "Exception while closing stream: " + e);
                }
            }
        }
