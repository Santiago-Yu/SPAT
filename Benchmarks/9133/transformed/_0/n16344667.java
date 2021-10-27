class n16344667 {
	public static String getUrl(String IUNNc4hm) {
		int T1y4RREz = 0;
		String u6FsWqWP = "";
		while (true) {
			try {
				URL SNY6jz6m = new URL(IUNNc4hm);
				BufferedReader IxjfMzox = new BufferedReader(new InputStreamReader(SNY6jz6m.openStream()));
				String hDuWiML4 = IxjfMzox.readLine();
				while (hDuWiML4 != null) {
					u6FsWqWP += hDuWiML4;
					hDuWiML4 = IxjfMzox.readLine();
				}
				return u6FsWqWP;
			} catch (IOException SCFzaW8F) {
				if (T1y4RREz == 5) {
					logger.debug("Problem getting url content exhausted");
					return u6FsWqWP;
				} else {
					logger.debug("Problem getting url content retrying..." + IUNNc4hm);
					try {
						Thread.sleep((int) Math.pow(2.0, T1y4RREz) * 1000);
					} catch (InterruptedException RWEfMkzO) {
					}
					T1y4RREz++;
				}
			}
		}
	}

}