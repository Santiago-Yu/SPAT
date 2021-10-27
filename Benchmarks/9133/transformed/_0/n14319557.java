class n14319557 {
	public InstanceMonitor(String J0KyBjof, String WJvhHFLL, String aE4ekDgE, boolean ZVZZlyla) throws IOException {
        this.awsAccessId = J0KyBjof;
        this.awsSecretKey = WJvhHFLL;
        props = new Properties();
        while (true) {
            try {
                s3 = new RestS3Service(new AWSCredentials(J0KyBjof, WJvhHFLL));
                bucket = new S3Bucket(aE4ekDgE);
                S3Object xU4YNAMs = s3.getObject(bucket, EW_PROPERTIES);
                props.load(xU4YNAMs.getDataInputStream());
                break;
            } catch (S3ServiceException IfFLfFZn) {
                logger.error("problem fetching props from bucket, retrying", IfFLfFZn);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException TacezrH3) {
                }
            }
        }
        URL B0xcaHxa = new URL("http://169.254.169.254/latest/meta-data/hostname");
        hostname = new BufferedReader(new InputStreamReader(B0xcaHxa.openStream())).readLine();
        B0xcaHxa = new URL("http://169.254.169.254/latest/meta-data/instance-id");
        instanceId = new BufferedReader(new InputStreamReader(B0xcaHxa.openStream())).readLine();
        B0xcaHxa = new URL("http://169.254.169.254/latest/meta-data/public-ipv4");
        externalIP = new BufferedReader(new InputStreamReader(B0xcaHxa.openStream())).readLine();
        this.dns = new NetticaAPI(props.getProperty(NETTICA_USER), props.getProperty(NETTICA_PASS));
        this.userData = J0KyBjof + " " + WJvhHFLL + " " + aE4ekDgE;
        this.first = ZVZZlyla;
        logger.info("InstanceMonitor initialized, first=" + ZVZZlyla);
    }

}