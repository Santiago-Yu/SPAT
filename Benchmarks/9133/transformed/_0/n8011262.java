class n8011262 {
	private void uploadFile() {
		String Y5OxDbTC = "\r\n";
		String zE9FvXt9 = "--";
		String wXXfek7j = "*****";
		try {
			URL KshB7O3n = new URL(actionUrl);
			HttpURLConnection am4cPVdq = (HttpURLConnection) KshB7O3n.openConnection();
			am4cPVdq.setDoInput(true);
			am4cPVdq.setDoOutput(true);
			am4cPVdq.setUseCaches(false);
			am4cPVdq.setRequestMethod("POST");
			am4cPVdq.setRequestProperty("Connection", "Keep-Alive");
			am4cPVdq.setRequestProperty("Charset", "UTF-8");
			am4cPVdq.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + wXXfek7j);
			DataOutputStream MgoE7tt6 = new DataOutputStream(am4cPVdq.getOutputStream());
			MgoE7tt6.writeBytes(zE9FvXt9 + wXXfek7j + Y5OxDbTC);
			MgoE7tt6.writeBytes(
					"Content-Disposition: form-data; " + "name=\"file1\";filename=\"" + newName + "\"" + Y5OxDbTC);
			MgoE7tt6.writeBytes(Y5OxDbTC);
			FileInputStream s3OzSbpk = new FileInputStream(uploadFile);
			int YhNQCzL5 = 1024;
			byte[] b5Ykxvmi = new byte[YhNQCzL5];
			int oG4bdm2s = -1;
			while ((oG4bdm2s = s3OzSbpk.read(b5Ykxvmi)) != -1) {
				MgoE7tt6.write(b5Ykxvmi, 0, oG4bdm2s);
			}
			MgoE7tt6.writeBytes(Y5OxDbTC);
			MgoE7tt6.writeBytes(zE9FvXt9 + wXXfek7j + zE9FvXt9 + Y5OxDbTC);
			s3OzSbpk.close();
			MgoE7tt6.flush();
			InputStream ONincHRl = am4cPVdq.getInputStream();
			int vPsQx3zZ;
			StringBuffer KWwtNImE = new StringBuffer();
			while ((vPsQx3zZ = ONincHRl.read()) != -1) {
				KWwtNImE.append((char) vPsQx3zZ);
			}
			showDialog(KWwtNImE.toString().trim());
			MgoE7tt6.close();
		} catch (Exception FGAeBS8v) {
			showDialog("" + FGAeBS8v);
		}
	}

}