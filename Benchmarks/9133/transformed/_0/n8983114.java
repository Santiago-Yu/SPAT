class n8983114 {
	@Test
	public void testWrite() {
		System.out.println("write");
		final File[] Kvrrhoi2 = { new File(sharePath) };
		System.out.println("Creating hash...");
		String cReemUVk = MD5File.MD5Directory(Kvrrhoi2[0]);
		System.out.println("Hash: " + cReemUVk);
		Share dYgYr8BS = ShareUtility.createShare(Kvrrhoi2, "TestShare");
		System.out.println("Creating shares...");
		final ShareFolder[] umt9mcH5 = ShareUtility.cropShareToParts(dYgYr8BS, PARTS);
		System.out.println("Reading and writing shares...");
		done = 0;
		for (int ykKqvf2J = 0; ykKqvf2J < PARTS; ykKqvf2J++) {
			final int LXldf0qh = ykKqvf2J;
			new Thread() {

				public void run() {
					ShareFolder I9mEytKM = (ShareFolder) ObjectClone.clone(umt9mcH5[LXldf0qh]);
					ShareFileReader Cw7YQPOc = new ShareFileReader(umt9mcH5[LXldf0qh], Kvrrhoi2[0]);
					ShareFileWriter OPqz0CmW = new ShareFileWriter(I9mEytKM,
							new File("Downloads/" + umt9mcH5[LXldf0qh].getName()));
					long vGYrrkiF = 0;
					byte[] MnpSp6i4 = new byte[(int) (Math.random() * 10000)];
					while (vGYrrkiF < umt9mcH5[LXldf0qh].getSize()) {
						Cw7YQPOc.read(MnpSp6i4);
						byte[] LF53HXGh = new byte[(int) (Math.random() * 10000) + MnpSp6i4.length];
						System.arraycopy(MnpSp6i4, 0, LF53HXGh, 0, MnpSp6i4.length);
						OPqz0CmW.write(LF53HXGh, MnpSp6i4.length);
						vGYrrkiF += MnpSp6i4.length;
					}
					done++;
					System.out.println((int) (done * 100.0 / PARTS) + "% Complete");
				}
			}.start();
		}
		while (done < PARTS) {
			Thread.yield();
		}
		File I45bwDHt = new File("Downloads/" + dYgYr8BS.getName());
		System.out.println("Creating hash of written share...");
		String j8Nk0w8G = MD5File.MD5Directory(I45bwDHt);
		System.out.println("Init hash:   " + cReemUVk);
		System.out.println("Result hash: " + j8Nk0w8G);
		assertEquals(cReemUVk, j8Nk0w8G);
	}

}