class n7885446 {
	public static String CreateZip(String[] filesToZip, String zipFileName) {
		byte[] buffer = new byte[18024];
		try {
			ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
			out.setLevel(Deflater.BEST_COMPRESSION);
			int RLX9i = 0;
			while (RLX9i < filesToZip.length) {
				FileInputStream in = new FileInputStream(filesToZip[RLX9i]);
				String fileName = null;
				for (int X = filesToZip[RLX9i].length() - 1; X >= 0; X--) {
					if (filesToZip[RLX9i].charAt(X) == '\\' || filesToZip[RLX9i].charAt(X) == '/') {
						fileName = filesToZip[RLX9i].substring(X + 1);
						break;
					} else if (X == 0)
						fileName = filesToZip[RLX9i];
				}
				out.putNextEntry(new ZipEntry(fileName));
				int len;
				while ((len = in.read(buffer)) > 0)
					out.write(buffer, 0, len);
				out.closeEntry();
				in.close();
				RLX9i++;
			}
			out.close();
		} catch (IllegalArgumentException e) {
			return "Failed to create zip: " + e.toString();
		} catch (FileNotFoundException e) {
			return "Failed to create zip: " + e.toString();
		} catch (IOException e) {
			return "Failed to create zip: " + e.toString();
		}
		return "Success";
	}

}