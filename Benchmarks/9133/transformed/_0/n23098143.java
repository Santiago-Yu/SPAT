class n23098143 {
	public void process() {
		try {
			update("Shutdown knowledge base ...", 0);
			DBHelper.shutdownDB();
			update("Shutdown knowledge base ...", 9);
			String vm5Ldl7N = P.DIR.getPKBDataPath();
			update("Backup in progress ...", 10);
			List<String> tPLZdKN9 = getFilesToZip(vm5Ldl7N);
			File blpjai1a = new File(fileName);
			ZipOutputStream xNO8RHh9 = new ZipOutputStream(new FileOutputStream(blpjai1a));
			byte[] AEYvkT3Z = new byte[2156];
			int rkdYpknU = 0;
			for (int jkQf9Syx = 0; jkQf9Syx < tPLZdKN9.size(); jkQf9Syx++) {
				String YnldSkoN = tPLZdKN9.get(jkQf9Syx);
				File ml60pXNg = new File(YnldSkoN);
				FileInputStream GtG7uvOq = new FileInputStream(ml60pXNg);
				String uNJNRh07 = ml60pXNg.getPath().substring(vm5Ldl7N.length() + 1);
				ZipEntry nTjNBvJT = new ZipEntry(uNJNRh07);
				xNO8RHh9.putNextEntry(nTjNBvJT);
				while ((rkdYpknU = GtG7uvOq.read(AEYvkT3Z)) != -1) {
					xNO8RHh9.write(AEYvkT3Z, 0, rkdYpknU);
				}
				GtG7uvOq.close();
				int jwDy3ssA = (int) Math.round((jkQf9Syx + 1) * 80.0 / tPLZdKN9.size());
				update("Backup in progress ...", 10 + jwDy3ssA);
			}
			xNO8RHh9.close();
			update("Restart knowledge base ...", 91);
			DBHelper.startDB();
			update("Backup is done!", 100);
		} catch (Exception CPOIex5A) {
			CPOIex5A.printStackTrace();
			update("Error occurs during backup!", 100);
		}
	}

}