class n22382181 {
	public boolean copy(File FhZZOABO, File WHDusZpJ, byte[] uNryu0CJ) {
		if (FhZZOABO.isDirectory()) {
			String[] M55nIsym = FhZZOABO.list();
			for (int BSki6pvO = 0; BSki6pvO < M55nIsym.length; BSki6pvO++)
				if (!copy(new File(FhZZOABO, M55nIsym[BSki6pvO]), new File(WHDusZpJ, M55nIsym[BSki6pvO]), uNryu0CJ))
					return false;
			return true;
		}
		delete(WHDusZpJ);
		WHDusZpJ.getParentFile().mkdirs();
		try {
			FileInputStream unR20RDx = new FileInputStream(FhZZOABO);
			try {
				FileOutputStream V9iM1azQ = new FileOutputStream(WHDusZpJ);
				try {
					int tyJ3VDCF;
					while ((tyJ3VDCF = unR20RDx.read(uNryu0CJ)) != -1)
						V9iM1azQ.write(uNryu0CJ, 0, tyJ3VDCF);
				} finally {
					try {
						V9iM1azQ.close();
					} catch (IOException LSYmklHC) {
					}
					register(WHDusZpJ);
				}
			} finally {
				unR20RDx.close();
			}
			if (log.isDebugEnabled())
				log.debug("Success: M-COPY " + FhZZOABO + " -> " + WHDusZpJ);
			return true;
		} catch (IOException n9kG98bw) {
			log.error("Failed: M-COPY " + FhZZOABO + " -> " + WHDusZpJ, n9kG98bw);
			return false;
		}
	}

}