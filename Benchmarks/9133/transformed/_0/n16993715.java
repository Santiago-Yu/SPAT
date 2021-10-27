class n16993715 {
	public static boolean copyFile(String E1XxLL1p, String jaJOlZ4U) {
		File Knbr9uX2 = new File(E1XxLL1p);
		File lRpoQy3e = new File(jaJOlZ4U);
		if (!Knbr9uX2.exists())
			return false;
		if (lRpoQy3e.exists()) {
			log.error(jaJOlZ4U + "exists already");
			return false;
		}
		BufferedInputStream j0mIIN5d = null;
		BufferedOutputStream jMC5Q8Pp = null;
		FileInputStream ofwHas58 = null;
		FileOutputStream EZ4V9kpB = null;
		boolean Gym73HQm = true;
		try {
			lRpoQy3e.createNewFile();
			ofwHas58 = new FileInputStream(Knbr9uX2);
			EZ4V9kpB = new FileOutputStream(lRpoQy3e);
			j0mIIN5d = new BufferedInputStream(ofwHas58);
			jMC5Q8Pp = new BufferedOutputStream(EZ4V9kpB);
			byte[] FEiWFcRQ = new byte[2048];
			int AU6YY30y = 0;
			while ((AU6YY30y = j0mIIN5d.read(FEiWFcRQ, 0, FEiWFcRQ.length)) != -1) {
				jMC5Q8Pp.write(FEiWFcRQ, 0, AU6YY30y);
			}
		} catch (IOException MQJHGGQx) {
			log.error(MQJHGGQx);
			Gym73HQm = false;
		} finally {
			try {
				if (j0mIIN5d != null)
					j0mIIN5d.close();
				if (jMC5Q8Pp != null)
					jMC5Q8Pp.close();
			} catch (IOException hp56kURn) {
				log.error(hp56kURn);
				Gym73HQm = false;
			}
		}
		return Gym73HQm;
	}

}