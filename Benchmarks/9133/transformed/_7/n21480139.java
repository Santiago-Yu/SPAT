class n21480139 {
	public FileDownloader(Context context, String downloadUrl, File fileSaveDir, int threadNum) {
        try {
            this.context = context;
            this.downloadUrl = downloadUrl;
            this.fileService = new FileService(context);
            this.url = new URL(downloadUrl);
            this.threads = new DownloadThread[threadNum];
            this.fileSaveDir = fileSaveDir;
            if (!fileSaveDir.exists()) {
                fileSaveDir.mkdir();
            }
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(6 * 1000);
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "image/gif, image/jpeg, image/pjpeg, image/pjpeg, application/x-shockwave-flash, application/xaml+xml, application/vnd.ms-xpsdocument, application/x-ms-xbap, application/x-ms-application, application/vnd.ms-excel, application/vnd.ms-powerpoint, application/msword, */*");
            conn.setRequestProperty("Accept-Language", "zh-CN");
            conn.setRequestProperty("Referer", downloadUrl);
            conn.setRequestProperty("Charset", "UTF-8");
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.2; Trident/4.0; .NET CLR 1.1.4322; .NET CLR 2.0.50727; .NET CLR 3.0.04506.30; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729)");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.connect();
            printResponseHeader(conn);
            if (conn.getResponseCode() == 200) {
                this.fileSize = conn.getContentLength();
                if (this.fileSize <= 0) throw new RuntimeException("???????????§³");
                String fileName = getFileName(conn);
                this.saveFile = new File(fileSaveDir, fileName);
                Map<Integer, Integer> logdata = fileService.getData(downloadUrl);
                if (logdata.size() > 0) {
                    data.putAll(logdata);
                }
                this.block = this.fileSize / this.threads.length + 1;
                if (this.data.size() == this.threads.length) {
                    for (int i = 0; i < this.threads.length; i++) {
                        this.downloadSize = this.downloadSize + (this.data.get(i + 1) - (this.block * i));
                    }
                    print("????????????" + this.downloadSize);
                }
            } else {
                print("?????????????");
                throw new RuntimeException("?????????????");
            }
        } catch (Exception e) {
            print("???????????¡¤??" + e.toString());
            throw new RuntimeException("???????????¡¤??");
        }
    }

}