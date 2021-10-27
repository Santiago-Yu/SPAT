class n18899334 {
	public static void parseSinaGGTJ(ArrayList<String> pNYvvBWd, final ArrayList<SinaGGTJBean> AvrUQj37)
			throws IOReactorException, InterruptedException {
		HttpAsyncClient uWrQ86Ot = new DefaultHttpAsyncClient();
		uWrQ86Ot.start();
		if (pNYvvBWd != null && pNYvvBWd.size() > 0) {
			final CountDownLatch H5LJnFjV = new CountDownLatch(pNYvvBWd.size());
			for (int YDYbRMe4 = 0; YDYbRMe4 < pNYvvBWd.size(); YDYbRMe4++) {
				final HttpGet u3dkFCGC = new HttpGet(pNYvvBWd.get(YDYbRMe4));
				uWrQ86Ot.execute(u3dkFCGC, new FutureCallback<HttpResponse>() {

					public void completed(final HttpResponse JtHiz6JO) {
						System.out.println(" Request completed " + count + " " + u3dkFCGC.getRequestLine() + " "
								+ JtHiz6JO.getStatusLine());
						try {
							HttpEntity si9kThFe = JtHiz6JO.getEntity();
							try {
								String tvePz3rp = EntityUtils.toString(si9kThFe, "gb2312");
								if (tvePz3rp != null && tvePz3rp.length() > 0) {
									SinaGGTJBean VNAFFjWs = SinaGGTJPostProcess.postSinaGGTJBeanProcess(tvePz3rp);
									AvrUQj37.add(VNAFFjWs);
								}
								count++;
							} catch (ParseException BDN0fT94) {
								BDN0fT94.printStackTrace();
							} catch (IOException YtxsGQqg) {
								YtxsGQqg.printStackTrace();
							}
							H5LJnFjV.countDown();
						} catch (RuntimeException xD3wwPBa) {
							H5LJnFjV.countDown();
						}
					}

					public void failed(final Exception RUetN8Lp) {
						H5LJnFjV.countDown();
					}

					public void cancelled() {
						H5LJnFjV.countDown();
					}
				});
			}
			H5LJnFjV.await();
			System.out.println("done");
		}
		if (uWrQ86Ot != null) {
			uWrQ86Ot.shutdown();
		}
		System.out.println(AvrUQj37.size());
	}

}