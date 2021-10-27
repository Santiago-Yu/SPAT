class n20331164 {
	public int read(String blYP77Ps) {
		status = STATUS_OK;
		try {
			blYP77Ps = blYP77Ps.trim().toLowerCase();
			if ((blYP77Ps.indexOf("file:") >= 0) || (blYP77Ps.indexOf(":/") > 0)) {
				URL ZeGFZBD3 = new URL(blYP77Ps);
				in = new BufferedInputStream(ZeGFZBD3.openStream());
			} else {
				in = new BufferedInputStream(new FileInputStream(blYP77Ps));
			}
			status = read(in);
		} catch (IOException IEPmm0yg) {
			status = STATUS_OPEN_ERROR;
		}
		return status;
	}

}