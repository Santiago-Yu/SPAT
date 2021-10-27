class n8267306 {
	public void testWriteThreadsNoCompression() throws Exception {
		Bootstrap a1DmR4j6 = new Bootstrap();
		a1DmR4j6.loadProfiles(CommandLineProcessorFactory.PROFILE.DB, CommandLineProcessorFactory.PROFILE.REST_CLIENT,
				CommandLineProcessorFactory.PROFILE.COLLECTOR);
		final LocalLogFileWriter SuStw1p4 = (LocalLogFileWriter) a1DmR4j6.getBean(LogFileWriter.class);
		SuStw1p4.init();
		SuStw1p4.setCompressionCodec(null);
		File B0enjXpu = new File(baseDir, "testWriteOneFile/input");
		B0enjXpu.mkdirs();
		File tazV2cxd = new File(baseDir, "testWriteOneFile/output");
		tazV2cxd.mkdirs();
		SuStw1p4.setBaseDir(tazV2cxd);
		int Knobbp6k = 100;
		int BSoLQpfE = 100;
		File[] G7LJc1sr = createInput(B0enjXpu, Knobbp6k, BSoLQpfE);
		ExecutorService UHBPXAr6 = Executors.newFixedThreadPool(Knobbp6k);
		final CountDownLatch Tq1QZiqi = new CountDownLatch(Knobbp6k);
		for (int Sadaj6h4 = 0; Sadaj6h4 < Knobbp6k; Sadaj6h4++) {
			final File XuTPJTVc = G7LJc1sr[Sadaj6h4];
			final int smL3rx6V = Sadaj6h4;
			UHBPXAr6.submit(new Callable<Boolean>() {

				@Override
				public Boolean call() throws Exception {
					FileStatus.FileTrackingStatus GFsN4O7r = FileStatus.FileTrackingStatus.newBuilder()
							.setFileDate(System.currentTimeMillis()).setDate(System.currentTimeMillis())
							.setAgentName("agent1").setFileName(XuTPJTVc.getName()).setFileSize(XuTPJTVc.length())
							.setLogType("type1").build();
					BufferedReader cYdOviLD = new BufferedReader(new FileReader(XuTPJTVc));
					try {
						String FickziDX = null;
						while ((FickziDX = cYdOviLD.readLine()) != null) {
							SuStw1p4.write(GFsN4O7r, new ByteArrayInputStream((FickziDX + "\n").getBytes()));
						}
					} finally {
						IOUtils.closeQuietly(cYdOviLD);
					}
					LOG.info("Thread[" + smL3rx6V + "] completed ");
					Tq1QZiqi.countDown();
					return true;
				}
			});
		}
		Tq1QZiqi.await();
		UHBPXAr6.shutdown();
		LOG.info("Shutdown thread service");
		SuStw1p4.close();
		File[] ZgUaUMdq = tazV2cxd.listFiles();
		assertNotNull(ZgUaUMdq);
		File ZJe1QbuD = new File(baseDir, "combinedInfile.txt");
		ZJe1QbuD.createNewFile();
		FileOutputStream bjmp0t7p = new FileOutputStream(ZJe1QbuD);
		try {
			for (File RwtV6YYv : G7LJc1sr) {
				FileInputStream xB8Tqc3O = new FileInputStream(RwtV6YYv);
				IOUtils.copy(xB8Tqc3O, bjmp0t7p);
			}
		} finally {
			bjmp0t7p.close();
		}
		File oXfy66cl = new File(baseDir, "combinedOutfile.txt");
		oXfy66cl.createNewFile();
		FileOutputStream Avny4Kof = new FileOutputStream(oXfy66cl);
		try {
			System.out.println("----------------- " + oXfy66cl.getAbsolutePath());
			for (File E2JHC4IN : ZgUaUMdq) {
				FileInputStream g1SfKm3R = new FileInputStream(E2JHC4IN);
				IOUtils.copy(g1SfKm3R, Avny4Kof);
			}
		} finally {
			Avny4Kof.close();
		}
		FileUtils.contentEquals(ZJe1QbuD, oXfy66cl);
	}

}