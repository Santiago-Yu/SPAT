class n7885446 {
	public static String CreateZip(String[] LYw81xgn, String GACSBoKi) {
		byte[] ucRI4SR6 = new byte[18024];
		try {
			ZipOutputStream dr60UXdc = new ZipOutputStream(new FileOutputStream(GACSBoKi));
			dr60UXdc.setLevel(Deflater.BEST_COMPRESSION);
			for (int v3jK873t = 0; v3jK873t < LYw81xgn.length; v3jK873t++) {
				FileInputStream X4mBde27 = new FileInputStream(LYw81xgn[v3jK873t]);
				String YhwUBs33 = null;
				for (int TI9Jwm9d = LYw81xgn[v3jK873t].length() - 1; TI9Jwm9d >= 0; TI9Jwm9d--) {
					if (LYw81xgn[v3jK873t].charAt(TI9Jwm9d) == '\\' || LYw81xgn[v3jK873t].charAt(TI9Jwm9d) == '/') {
						YhwUBs33 = LYw81xgn[v3jK873t].substring(TI9Jwm9d + 1);
						break;
					} else if (TI9Jwm9d == 0)
						YhwUBs33 = LYw81xgn[v3jK873t];
				}
				dr60UXdc.putNextEntry(new ZipEntry(YhwUBs33));
				int p1m6C7ES;
				while ((p1m6C7ES = X4mBde27.read(ucRI4SR6)) > 0)
					dr60UXdc.write(ucRI4SR6, 0, p1m6C7ES);
				dr60UXdc.closeEntry();
				X4mBde27.close();
			}
			dr60UXdc.close();
		} catch (IllegalArgumentException WB2dmeE6) {
			return "Failed to create zip: " + WB2dmeE6.toString();
		} catch (FileNotFoundException uAznQLb3) {
			return "Failed to create zip: " + uAznQLb3.toString();
		} catch (IOException bwzoXxMs) {
			return "Failed to create zip: " + bwzoXxMs.toString();
		}
		return "Success";
	}

}