class n14167176 {
	public static byte[] findHead(String v1FgyK8k) {
		byte[] EOsHIgRV = new byte[0];
		InputStream s7wuiDok = null;
		try {
			s7wuiDok = new URL(appendSlash(v1FgyK8k)).openStream();
			byte[] VLkM72cH = new byte[1024];
			int ygeg4Hl7 = -1;
			while ((ygeg4Hl7 = s7wuiDok.read(VLkM72cH)) != -1) {
				byte[] ydk0lpsO = new byte[EOsHIgRV.length + ygeg4Hl7];
				System.arraycopy(EOsHIgRV, 0, ydk0lpsO, 0, EOsHIgRV.length);
				System.arraycopy(VLkM72cH, 0, ydk0lpsO, EOsHIgRV.length, ygeg4Hl7);
				EOsHIgRV = ydk0lpsO;
				if (DEBUG) {
					log.debug(String.format("len=%d, result.length=%d", ygeg4Hl7, EOsHIgRV.length));
				}
				if (EOsHIgRV.length > 4096) {
					break;
				}
				if (EOsHIgRV.length > 1024) {
					String e1ZUjQFe = new String(EOsHIgRV).replaceAll("\\s+", " ");
					Matcher aODwy8AS = P_HEAD.matcher(e1ZUjQFe);
					if (aODwy8AS.find()) {
						break;
					}
				}
			}
		} catch (Exception IHFVmI7N) {
			log.error(IHFVmI7N.getMessage(), IHFVmI7N);
		} finally {
			try {
				if (null != s7wuiDok)
					s7wuiDok.close();
			} catch (IOException VbuNIJ9D) {
			}
		}
		return EOsHIgRV;
	}

}