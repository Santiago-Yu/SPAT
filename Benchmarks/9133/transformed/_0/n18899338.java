class n18899338 {
	public static void parseSohuStock(ArrayList<String> XSB8EZgl, final ArrayList<SohuStockBean> ZcafryWM)
			throws IOReactorException, InterruptedException {
		HttpAsyncClient kWtQb84U = new DefaultHttpAsyncClient();
		kWtQb84U.start();
		if (XSB8EZgl != null && XSB8EZgl.size() > 0) {
			final CountDownLatch CfFuCSA3 = new CountDownLatch(XSB8EZgl.size());
			for (int V7Jfx3d9 = 0; V7Jfx3d9 < XSB8EZgl.size(); V7Jfx3d9++) {
				final HttpGet lb6VLEq6 = new HttpGet(XSB8EZgl.get(V7Jfx3d9));
				kWtQb84U.execute(lb6VLEq6, new FutureCallback<HttpResponse>() {

					public void completed(final HttpResponse BDVQS63b) {
						System.out.println(" Request completed " + count + " " + lb6VLEq6.getRequestLine() + " "
								+ BDVQS63b.getStatusLine());
						try {
							HttpEntity VrXLmVUZ = BDVQS63b.getEntity();
							try {
								String SCOYhjZe = EntityUtils.toString(VrXLmVUZ, "gb2312");
								if (SCOYhjZe != null && SCOYhjZe.length() > 0) {
									SohuStockBean q45xne8k = SohuStockPostProcess.postSohuStockBeanProcess(SCOYhjZe);
									ZcafryWM.add(q45xne8k);
								}
								count++;
							} catch (ParseException xdUCLuEM) {
								xdUCLuEM.printStackTrace();
							} catch (IOException CodeHyvf) {
								CodeHyvf.printStackTrace();
							}
							CfFuCSA3.countDown();
						} catch (RuntimeException ttU85kjY) {
							CfFuCSA3.countDown();
						}
					}

					public void failed(final Exception dvpJxO3P) {
						CfFuCSA3.countDown();
					}

					public void cancelled() {
						CfFuCSA3.countDown();
					}
				});
			}
			CfFuCSA3.await();
			System.out.println("done");
		}
		if (kWtQb84U != null) {
			kWtQb84U.shutdown();
		}
		System.out.println(ZcafryWM.size());
	}

}