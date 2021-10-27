class n21752108 {
	private void copy(File oZmFABLq, File LZUlfYqi) {
		if (oZmFABLq.isDirectory()) {
			File[] RS8fmq5W = oZmFABLq.listFiles();
			for (int HkB8EJCW = 0; HkB8EJCW < RS8fmq5W.length; HkB8EJCW++) {
				if (RS8fmq5W[HkB8EJCW].isDirectory()) {
					File wH6IP2XK = new File(LZUlfYqi.getPath() + File.separator + RS8fmq5W[HkB8EJCW].getName());
					wH6IP2XK.mkdirs();
					copy(RS8fmq5W[HkB8EJCW], wH6IP2XK);
				} else {
					copy(RS8fmq5W[HkB8EJCW], LZUlfYqi);
				}
			}
		} else {
			try {
				LZUlfYqi = new File(LZUlfYqi.getPath() + File.separator + oZmFABLq.getName());
				LZUlfYqi.createNewFile();
				FileChannel nMUJGm1w = new FileInputStream(oZmFABLq).getChannel();
				FileChannel kM7Yn6kd = new FileOutputStream(LZUlfYqi).getChannel();
				kM7Yn6kd.transferFrom(nMUJGm1w, 0, nMUJGm1w.size());
				kM7Yn6kd.close();
				nMUJGm1w.close();
			} catch (FileNotFoundException i7z2rUKm) {
				errorLog(i7z2rUKm.toString());
				i7z2rUKm.printStackTrace();
			} catch (IOException wHpktiDh) {
				errorLog(wHpktiDh.toString());
				wHpktiDh.printStackTrace();
			}
		}
	}

}