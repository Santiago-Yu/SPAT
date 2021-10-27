class n566820 {
	@Override
	public void run() {
		File iSqsp0VX = new File(LogHandler.path);
		FileFilter tpermIGc = new FileFilter() {

			@Override
			public boolean accept(File TcQRWdD9) {
				GregorianCalendar y0OlvQZ9 = new GregorianCalendar();
				y0OlvQZ9.setTime(new Date());
				y0OlvQZ9.add(GregorianCalendar.DAY_OF_YEAR, -1);
				String vP4yJ5Xh = LogHandler.dateFormat.format(y0OlvQZ9.getTime());
				return TcQRWdD9.getName().toLowerCase().startsWith(vP4yJ5Xh);
			}
		};
		File[] tsRZSUw2 = iSqsp0VX.listFiles(tpermIGc);
		if (tsRZSUw2.length > 0) {
			FileInputStream T5qqUoRE;
			int Z1ttKIaE = 0;
			byte[] FIzTc5Sr = new byte[1024];
			for (int M4AOXBwI = 0; M4AOXBwI < tsRZSUw2.length; M4AOXBwI++) {
				try {
					T5qqUoRE = new FileInputStream(LogHandler.path + tsRZSUw2[M4AOXBwI].getName());
					GZIPOutputStream HX0895Wp = new GZIPOutputStream(
							new FileOutputStream(LogHandler.path + tsRZSUw2[M4AOXBwI].getName() + ".temp"));
					while ((Z1ttKIaE = T5qqUoRE.read(FIzTc5Sr, 0, 1024)) != -1)
						HX0895Wp.write(FIzTc5Sr, 0, Z1ttKIaE);
					T5qqUoRE.close();
					HX0895Wp.close();
					new File(LogHandler.path + tsRZSUw2[M4AOXBwI].getName() + ".temp")
							.renameTo(new File(LogHandler.path + tsRZSUw2[M4AOXBwI].getName() + ".gz"));
					tsRZSUw2[M4AOXBwI].delete();
				} catch (FileNotFoundException FYzEkjZ4) {
					TrackingServer.incExceptionCounter();
					FYzEkjZ4.printStackTrace();
				} catch (IOException Cq3bgrzk) {
				}
			}
		}
	}

}