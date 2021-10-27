class n23672408 {
	private void copyIconFiles(UmlClass ixd2DkXa) {
		if (ixd2DkXa.hasAnnotation("icon16")) {
			String WZsj8PBb = ixd2DkXa.annotationValue("icon16");
			String zTfoAdKb = ".png";
			if (WZsj8PBb.endsWith(".jpg"))
				zTfoAdKb = ".jpg";
			if (WZsj8PBb.endsWith(".gif"))
				zTfoAdKb = ".gif";
			String l9grC5vV = output_dir + "/../resources/images/" + ixd2DkXa.getName() + "16" + zTfoAdKb;
			try {
				FileChannel k6BDG33u = new FileInputStream(WZsj8PBb).getChannel();
				FileChannel Z5VzIg2r = new FileOutputStream(l9grC5vV).getChannel();
				Z5VzIg2r.transferFrom(k6BDG33u, 0, k6BDG33u.size());
				k6BDG33u.close();
				Z5VzIg2r.close();
			} catch (Exception vO3i7vqG) {
				vO3i7vqG.printStackTrace();
			}
		}
		if (ixd2DkXa.hasAnnotation("icon32")) {
			String Ax8GY94d = ixd2DkXa.annotationValue("icon32");
			String qWMSJFWO = ".png";
			if (Ax8GY94d.endsWith(".jpg"))
				qWMSJFWO = ".jpg";
			if (Ax8GY94d.endsWith(".gif"))
				qWMSJFWO = ".gif";
			String cjaerurS = output_dir + "/../resources/images/" + ixd2DkXa.getName() + "32" + qWMSJFWO;
			try {
				FileChannel QWuYsk4T = new FileInputStream(Ax8GY94d).getChannel();
				FileChannel hMERx5j8 = new FileOutputStream(cjaerurS).getChannel();
				hMERx5j8.transferFrom(QWuYsk4T, 0, QWuYsk4T.size());
				QWuYsk4T.close();
				hMERx5j8.close();
			} catch (Exception ltZdTXt0) {
				ltZdTXt0.printStackTrace();
			}
		}
	}

}