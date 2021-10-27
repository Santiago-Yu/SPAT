class n21480139 {
	public FileDownloader(Context QF3Fjz6X, String NA1pr23S, File rIAp4uhz, int WmigM8vx) {
        try {
            this.context = QF3Fjz6X;
            this.downloadUrl = NA1pr23S;
            this.fileService = new FileService(QF3Fjz6X);
            this.url = new URL(NA1pr23S);
            this.threads = new DownloadThread[WmigM8vx];
            this.fileSaveDir = rIAp4uhz;
            if (!rIAp4uhz.exists()) {
                rIAp4uhz.mkdir();
            }
            HttpURLConnection xjMrcQPp = (HttpURLConnection) url.openConnection();
            xjMrcQPp.setConnectTimeout(6 * 1000);
            xjMrcQPp.setRequestMethod("GET");
            xjMrcQPp.setRequestProperty("Accept", "image/gif, image/jpeg, image/pjpeg, image/pjpeg, application/x-shockwave-flash, application/xaml+xml, application/vnd.ms-xpsdocument, application/x-ms-xbap, application/x-ms-application, application/vnd.ms-excel, application/vnd.ms-powerpoint, application/msword, */*");
            xjMrcQPp.setRequestProperty("Accept-Language", "zh-CN");
            xjMrcQPp.setRequestProperty("Referer", NA1pr23S);
            xjMrcQPp.setRequestProperty("Charset", "UTF-8");
            xjMrcQPp.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.2; Trident/4.0; .NET CLR 1.1.4322; .NET CLR 2.0.50727; .NET CLR 3.0.04506.30; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729)");
            xjMrcQPp.setRequestProperty("Connection", "Keep-Alive");
            xjMrcQPp.connect();
            printResponseHeader(xjMrcQPp);
            if (xjMrcQPp.getResponseCode() == 200) {
                this.fileSize = xjMrcQPp.getContentLength();
                if (this.fileSize <= 0) throw new RuntimeException("???????????§³");
                String I6WSiUIH = getFileName(xjMrcQPp);
                this.saveFile = new File(rIAp4uhz, I6WSiUIH);
                Map<Integer, Integer> jjlSiFvl = fileService.getData(NA1pr23S);
                if (jjlSiFvl.size() > 0) {
                    data.putAll(jjlSiFvl);
                }
                this.block = this.fileSize / this.threads.length + 1;
                if (this.data.size() == this.threads.length) {
                    for (int zTzbukt3 = 0; zTzbukt3 < this.threads.length; zTzbukt3++) {
                        this.downloadSize += this.data.get(zTzbukt3 + 1) - (this.block * zTzbukt3);
                    }
                    print("????????????" + this.downloadSize);
                }
            } else {
                print("?????????????");
                throw new RuntimeException("?????????????");
            }
        } catch (Exception PzafPo9T) {
            print("???????????¡¤??" + PzafPo9T.toString());
            throw new RuntimeException("???????????¡¤??");
        }
    }

}