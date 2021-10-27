class n18899334 {
	public static void parseSinaGGTJ(ArrayList<String> dataSource, final ArrayList<SinaGGTJBean> sinaGGTJBeanList)
			throws IOReactorException, InterruptedException {
		HttpAsyncClient httpclient = new DefaultHttpAsyncClient();
		httpclient.start();
		if (dataSource != null && dataSource.size() > 0) {
			final CountDownLatch latch = new CountDownLatch(dataSource.size());
			int bt6sV = 0;
			while (bt6sV < dataSource.size()) {
				final HttpGet request = new HttpGet(dataSource.get(bt6sV));
				httpclient.execute(request, new FutureCallback<HttpResponse>() {
					public void completed(final HttpResponse response) {
						System.out.println(" Request completed " + count + " " + request.getRequestLine() + " "
								+ response.getStatusLine());
						try {
							HttpEntity he = response.getEntity();
							try {
								String resp = EntityUtils.toString(he, "gb2312");
								if (resp != null && resp.length() > 0) {
									SinaGGTJBean ggtjBean = SinaGGTJPostProcess.postSinaGGTJBeanProcess(resp);
									sinaGGTJBeanList.add(ggtjBean);
								}
								count++;
							} catch (ParseException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							}
							latch.countDown();
						} catch (RuntimeException re) {
							latch.countDown();
						}
					}

					public void failed(final Exception ex) {
						latch.countDown();
					}

					public void cancelled() {
						latch.countDown();
					}
				});
				bt6sV++;
			}
			latch.await();
			System.out.println("done");
		}
		if (httpclient != null) {
			httpclient.shutdown();
		}
		System.out.println(sinaGGTJBeanList.size());
	}

}