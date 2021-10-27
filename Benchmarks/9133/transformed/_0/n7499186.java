class n7499186 {
	private void bootKernel(String yXS9iDAX) {
		try {
			AssetManager MQ7Q2IB7 = getResources().getAssets();
			InputStream MhDEfRqf = MQ7Q2IB7.open(yXS9iDAX + ".conf");
			Properties hFgzCUQt = new Properties();
			hFgzCUQt.load(MhDEfRqf);
			MhDEfRqf.close();
			Log.d("bootKernel", "Listing sdcard assets...");
			String[] U0FMf82L = MQ7Q2IB7.list("sdcard");
			for (String X17wUCVv : U0FMf82L) {
				Log.d("bootKernel", "Copying sdcard asset " + X17wUCVv + ".");
				AssetFileDescriptor D9NTlRQR = MQ7Q2IB7.openFd("sdcard/" + X17wUCVv);
				FileInputStream zqxmpjvf = D9NTlRQR.createInputStream();
				FileChannel nbo6fTdg = zqxmpjvf.getChannel();
				FileOutputStream MUdX0pBE = new FileOutputStream("/sdcard/" + X17wUCVv);
				FileChannel pdfrOm41 = MUdX0pBE.getChannel();
				nbo6fTdg.transferTo(0, nbo6fTdg.size(), pdfrOm41);
				nbo6fTdg.close();
				pdfrOm41.close();
			}
			Configuration u947hTGo = new JavaPropertiesConfiguration(hFgzCUQt);
			Configuration NWeWibmu = u947hTGo.subset("boot");
			String UykVWzPf = NWeWibmu.getString("kernel");
			Log.d("bootKernel", "Attempting to load kernel from class '" + UykVWzPf + "'...");
			Class<? extends Kernel> qVUWu2rQ = Class.forName(UykVWzPf).asSubclass(Kernel.class);
			Kernel TAcj8jci = qVUWu2rQ.newInstance();
			Log.d("bootKernel", "Kernel loaded, proceeding with boot...");
			BootContext JoMfiuzo = new SimpleBootContext(u947hTGo, AndroidBridgeService.class,
					AndroidBridgeServiceImpl.class);
			TAcj8jci.boot(JoMfiuzo).get();
			Log.d("bootKernel", "Kernel boot complete.");
		} catch (Exception UaDzHeYV) {
			Log.e("bootKernel", "Unable to boot kernel due to exception.", UaDzHeYV);
			finish();
		}
	}

}