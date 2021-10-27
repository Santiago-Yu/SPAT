class n8979065 {
	public void copyFile(File SsSy3vDo, File vvEt15Jj) {
		try {
			FileInputStream NIVBh9n4 = new FileInputStream(SsSy3vDo);
			try {
				FileOutputStream gasP2tGO = new FileOutputStream(vvEt15Jj);
				try {
					FileChannel EL7xIcv3 = NIVBh9n4.getChannel();
					EL7xIcv3.transferTo(0, EL7xIcv3.size(), gasP2tGO.getChannel());
				} finally {
					try {
						gasP2tGO.close();
					} catch (Exception pq481DoJ) {
						throw new RuntimeIoException(pq481DoJ, IoMode.CLOSE);
					}
				}
			} finally {
				try {
					NIVBh9n4.close();
				} catch (Exception FnRniTnP) {
					throw new RuntimeIoException(FnRniTnP, IoMode.CLOSE);
				}
			}
		} catch (IOException w8aZmzfK) {
			throw new RuntimeIoException(w8aZmzfK, IoMode.COPY);
		}
	}

}