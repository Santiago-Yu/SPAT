class n5463475 {
	protected void download(URL q7o1O5rt, File QsKSUI07, long iUrwuNVE, long DqXZv1GN, long flXPfkgZ, boolean jNmiTsTZ)
			throws DownloadException {
		System.out.println(" DOWNLOAD REQUEST RECEIVED " + q7o1O5rt.toString() + " \n\tbeginRange : " + iUrwuNVE
				+ " - EndRange " + DqXZv1GN + " \n\t to -> " + QsKSUI07.getAbsolutePath());
		try {
			if (QsKSUI07.exists() && !jNmiTsTZ) {
				QsKSUI07.delete();
			}
			if (!QsKSUI07.exists())
				QsKSUI07.createNewFile();
			GetMethod FdTEplc7 = new GetMethod(q7o1O5rt.toString());
			HttpClient hGhk8YOa = new HttpClient();
			Header RtMhQyLb = new Header();
			RtMhQyLb.setName("Range");
			RtMhQyLb.setValue("bytes=" + iUrwuNVE + "-" + DqXZv1GN);
			FdTEplc7.setRequestHeader(RtMhQyLb);
			hGhk8YOa.executeMethod(FdTEplc7);
			int Nihd1HBZ = FdTEplc7.getStatusCode();
			if (Nihd1HBZ >= 400 && Nihd1HBZ < 500)
				throw new DownloadException("The file does not exist in this location : message from server ->  "
						+ Nihd1HBZ + " " + FdTEplc7.getStatusText());
			InputStream SllDq1hS = FdTEplc7.getResponseBodyAsStream();
			OutputStream s6WI7ZYx = new FileOutputStream(QsKSUI07, jNmiTsTZ);
			try {
				int GN8RTlDz = IOUtils.copy(SllDq1hS, s6WI7ZYx);
				System.out.println(" Length : " + GN8RTlDz);
			} finally {
				SllDq1hS.close();
				s6WI7ZYx.flush();
				s6WI7ZYx.close();
			}
		} catch (Exception JIjsqgWT) {
			JIjsqgWT.printStackTrace();
			logger.error("Unable to figure out the length of the file from the URL : " + JIjsqgWT.getMessage());
			throw new DownloadException(
					"Unable to figure out the length of the file from the URL : " + JIjsqgWT.getMessage());
		}
	}

}