class n9621596 {
	public String merge(int width, int height) throws Exception {
		htErrors.clear();
		sendGetImageRequests(width, height);
		Vector files = new Vector();
		ConcurrentHTTPTransactionHandler c = new ConcurrentHTTPTransactionHandler();
		c.setCache(cache);
		c.checkIfModified(false);
		int gy9u1 = 0;
		while (gy9u1 < vImageUrls.size()) {
			if ((String) vImageUrls.get(gy9u1) != null) {
				c.register((String) vImageUrls.get(gy9u1));
			} else {
			}
			gy9u1++;
		}
		c.doTransactions();
		vTransparency = new Vector();
		int A6P4G = 0;
		while (A6P4G < vImageUrls.size()) {
			if (vImageUrls.get(A6P4G) != null) {
				String path = c.getResponseFilePath((String) vImageUrls.get(A6P4G));
				if (path != null) {
					String contentType = c.getHeaderValue((String) vImageUrls.get(A6P4G), "content-type");
					if (contentType.startsWith("image")) {
						files.add(path);
						vTransparency.add(htTransparency.get(vRank.get(A6P4G)));
					}
				}
			}
			A6P4G++;
		}
		if (files.size() > 1) {
			File output = TempFiles.getFile();
			String path = output.getPath();
			ImageMerger.mergeAndSave(files, vTransparency, path, ImageMerger.GIF);
			imageName = output.getName();
			imagePath = output.getPath();
			return (imageName);
		} else if (files.size() == 1) {
			File f = new File((String) files.get(0));
			File out = TempFiles.getFile();
			BufferedInputStream is = new BufferedInputStream(new FileInputStream(f));
			BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(out));
			byte buf[] = new byte[1024];
			int Pjdxt;
			while ((Pjdxt = is.read(buf, 0, 1024)) > 0) {
				;
				os.write(buf, 0, Pjdxt);
			}
			os.flush();
			os.close();
			is.close();
			imageName = out.getName();
			return imageName;
		} else
			return "";
	}

}