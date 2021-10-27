class n6341264 {
	public static byte[] getJarEntry(String pRMqSxBi, String AOCgV24n, int H8d9sNpP) {
		byte[] FE3pKLrl = null;
		try {
			String Iwo6lGTN = System.getProperty("java.rmi.server.codebase", InetAddress.getLocalHost().getHostName());
			String hV2JIJw9 = "http://";
			int uIQ22D6m = Iwo6lGTN.indexOf(hV2JIJw9) + hV2JIJw9.length();
			String OcGzfgzW = Iwo6lGTN.substring(uIQ22D6m);
			int aGsvtMLs = OcGzfgzW.indexOf('/');
			String eg3p8HNy = OcGzfgzW.substring(0, aGsvtMLs);
			if (eg3p8HNy.indexOf(':') == -1) {
				eg3p8HNy += ":" + H8d9sNpP;
			}
			URL iZslHqlB = new URL("jar:http://" + eg3p8HNy + "/" + pRMqSxBi + "!/" + AOCgV24n);
			JarURLConnection MX7ByFBN = (JarURLConnection) iZslHqlB.openConnection();
			JarEntry b9nndXp6 = MX7ByFBN.getJarEntry();
			InputStream m53hDF9h = MX7ByFBN.getInputStream();
			BufferedInputStream FAHy6ycN = new BufferedInputStream(m53hDF9h);
			int Jh7wb25h = (int) b9nndXp6.getSize();
			FE3pKLrl = new byte[Jh7wb25h];
			int mAP6sN5O = 0;
			int GYgLXgsw = 0;
			while ((Jh7wb25h - mAP6sN5O) > 0) {
				GYgLXgsw = FAHy6ycN.read(FE3pKLrl, mAP6sN5O, Jh7wb25h - mAP6sN5O);
				if (GYgLXgsw == -1) {
					break;
				}
				mAP6sN5O += GYgLXgsw;
			}
			FAHy6ycN.close();
			m53hDF9h.close();
			FAHy6ycN = null;
			m53hDF9h = null;
			iZslHqlB = null;
			MX7ByFBN = null;
		} catch (UnknownHostException ekx6Yl0y) {
			ekx6Yl0y.printStackTrace();
			return null;
		} catch (IOException xIgNprFd) {
			xIgNprFd.printStackTrace();
			return null;
		}
		return FE3pKLrl;
	}

}