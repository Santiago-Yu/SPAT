class n8014777 {
	private static void downloadImages(String fVmc3Dw0, String ZNPoyjrv, String UGZSmKDo) throws Exception {
		Properties ixqgN0S1 = new Properties();
		ixqgN0S1.load(new FileInputStream(ZNPoyjrv));
		long KeTbaXu2 = 0;
		long VOwNg6ks = System.currentTimeMillis();
		System.out.println("Downloading files from " + fVmc3Dw0 + " to " + UGZSmKDo);
		System.out.println("Total " + ixqgN0S1.size() + " files, think of 1 sec per file");
		System.out.println("Images with the same size as the 'no-image' image are ignored and not displayed");
		for (Iterator<Object> tPphXTWp = ixqgN0S1.keySet().iterator(); tPphXTWp.hasNext();) {
			String c23v75uS = tPphXTWp.next().toString().replace('\\', '/');
			if (c23v75uS.contains("="))
				throw new Exception(
						"Symbol '=' found in file names, while it is reserved for denoting '/' in flat-file names");
		}
		for (Iterator<Object> is24r8Sm = ixqgN0S1.keySet().iterator(); is24r8Sm.hasNext();) {
			String aaljKsBl = is24r8Sm.next().toString().replace('\\', '/');
			URL HCudMb4y = new URL(fVmc3Dw0 + aaljKsBl);
			File YxaTfO1Y = new File(UGZSmKDo + "/" + imageNameToFileName(aaljKsBl));
			KeTbaXu2++;
			if (!YxaTfO1Y.exists()) {
				try {
					BufferedInputStream ddzEGggK = new BufferedInputStream(HCudMb4y.openStream(), 64000);
					BufferedOutputStream dskF6UDd = new BufferedOutputStream(new FileOutputStream(YxaTfO1Y), 64000);
					int vQJ1XcJ9;
					while ((vQJ1XcJ9 = ddzEGggK.read()) != -1) {
						dskF6UDd.write(vQJ1XcJ9);
					}
					dskF6UDd.close();
					ddzEGggK.close();
					System.out.print(KeTbaXu2 + " /" + ixqgN0S1.size() + ". " + YxaTfO1Y.getName() + ", ");
					System.out.println("saved");
				} catch (Exception fAxk7bfo) {
					System.out.print(KeTbaXu2 + " /" + ixqgN0S1.size() + ". " + YxaTfO1Y.getName() + ", FAILED, error: "
							+ fAxk7bfo.getMessage());
				}
			} else {
				System.out.print(KeTbaXu2 + " /" + ixqgN0S1.size() + ". " + YxaTfO1Y.getName() + ", ");
				System.out.println("already exists");
			}
			if (KeTbaXu2 / 100 == KeTbaXu2 / 100.0) {
				long vCNDnhia = (System.currentTimeMillis() - VOwNg6ks);
				System.out.println("Total time " + vCNDnhia + " ms, " + (vCNDnhia / KeTbaXu2) + " ms/file");
			}
		}
		long qEwH67uX = (System.currentTimeMillis() - VOwNg6ks);
		System.out.println("Total time " + qEwH67uX + " ms, " + (qEwH67uX / ixqgN0S1.size()) + " ms/file");
	}

}