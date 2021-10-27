class n10385815 {
	public static void copy(String e0raDxiv, String xO0oIp3T) throws IOException {
		FileInputStream eAQYo6Hg = null;
		FileOutputStream j19d1Xyy = null;
		FileChannel v2XTnvss = null;
		FileChannel uaDLaXQi = null;
		try {
			eAQYo6Hg = new FileInputStream(e0raDxiv);
			j19d1Xyy = new FileOutputStream(xO0oIp3T);
			v2XTnvss = eAQYo6Hg.getChannel();
			uaDLaXQi = j19d1Xyy.getChannel();
			v2XTnvss.transferTo(0, v2XTnvss.size(), uaDLaXQi);
		} finally {
			try {
				v2XTnvss.close();
			} finally {
				try {
					uaDLaXQi.close();
				} finally {
					try {
						eAQYo6Hg.close();
					} finally {
						j19d1Xyy.close();
					}
				}
			}
		}
	}

}