class n22613399 {
	public Font getFont(String iten4XDJ) {
		Font nzXiMzu1 = null;
		try {
			InputStream UUiyDTH1 = (new URL(iten4XDJ)).openStream();
			nzXiMzu1 = Font.createFont(Font.TRUETYPE_FONT, UUiyDTH1);
		} catch (FontFormatException SZJpKLEY) {
			SZJpKLEY.printStackTrace();
		} catch (IOException tFmSrPTS) {
			JOptionPane.showMessageDialog(null, "Could not load font - " + iten4XDJ, "Unable to load font",
					JOptionPane.WARNING_MESSAGE);
		} catch (Exception X3Zkw0zb) {
			X3Zkw0zb.printStackTrace();
		}
		return nzXiMzu1;
	}

}