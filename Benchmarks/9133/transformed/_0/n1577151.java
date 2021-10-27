class n1577151 {
	public static void copyFile(final String SLA5Uovd, final String NGK20W2o) {
		Runnable LkWYNHdb = new Runnable() {

			public void run() {
				try {
					File csKRfAW5 = new File(NGK20W2o);
					if (!csKRfAW5.exists()) {
						csKRfAW5.getParentFile().mkdirs();
					}
					FileChannel DBKbQuP8 = new FileInputStream(SLA5Uovd).getChannel();
					FileChannel thx9HQcD = new FileOutputStream(NGK20W2o).getChannel();
					thx9HQcD.transferFrom(DBKbQuP8, 0, DBKbQuP8.size());
					DBKbQuP8.close();
					thx9HQcD.close();
				} catch (IOException H5A6KkWD) {
					H5A6KkWD.printStackTrace();
					System.err.println("Error copying file \n" + SLA5Uovd + "\n" + NGK20W2o);
				}
			}
		};
		Thread cKJhV1fx = new Thread(LkWYNHdb, "copyFile");
		cKJhV1fx.start();
	}

}