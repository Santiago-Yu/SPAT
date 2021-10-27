class n647224 {
	public void uploadFile(File tlR4hCkE, String hY7IW3JN) throws IOException {
		System.out.println("Uploading " + tlR4hCkE.getName() + " to " + hY7IW3JN);
		File YfluhaHJ = new File(hY7IW3JN);
		if (hY7IW3JN.endsWith("/")) {
			YfluhaHJ = new File(YfluhaHJ, tlR4hCkE.getName());
		} else if (YfluhaHJ.getParentFile().exists() == false) {
			YfluhaHJ.getParentFile().mkdirs();
		}
		if (tlR4hCkE.renameTo(YfluhaHJ) == false) {
			InputStream rxieFoEB = new FileInputStream(tlR4hCkE);
			OutputStream xjKQCzQb = new FileOutputStream(YfluhaHJ);
			byte[] XipuITcb = new byte[16384];
			int lpd5Zdp8 = -1;
			while ((lpd5Zdp8 = rxieFoEB.read(XipuITcb)) != -1)
				xjKQCzQb.write(XipuITcb, 0, lpd5Zdp8);
			rxieFoEB.close();
			xjKQCzQb.close();
		}
	}

}