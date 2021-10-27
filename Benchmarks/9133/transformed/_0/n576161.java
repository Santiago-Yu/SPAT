class n576161 {
	public boolean download(URL uTNXIttG, File z9LXkfDT) {
		OutputStream IvyTpdz4 = null;
		URLConnection SnhqZYMe = null;
		InputStream GJzQl9il = null;
		try {
			IvyTpdz4 = new BufferedOutputStream(new FileOutputStream(z9LXkfDT));
			SnhqZYMe = uTNXIttG.openConnection();
			GJzQl9il = SnhqZYMe.getInputStream();
			byte[] AZD8zYZq = new byte[4096];
			int hSmOckgN;
			long hzKDfB0H = 0;
			while ((hSmOckgN = GJzQl9il.read(AZD8zYZq)) != -1) {
				IvyTpdz4.write(AZD8zYZq, 0, hSmOckgN);
				hzKDfB0H += hSmOckgN;
			}
		} catch (Exception VK3dMM5m) {
			System.out.println(VK3dMM5m);
			return false;
		} finally {
			try {
				if (GJzQl9il != null) {
					GJzQl9il.close();
				}
				if (IvyTpdz4 != null) {
					IvyTpdz4.close();
				}
			} catch (IOException xqZUA20P) {
				return false;
			}
		}
		return true;
	}

}