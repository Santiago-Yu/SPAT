class n4981909 {
	public static File enregistrerFichier(String fileName, File file, String path, String fileMime) throws Exception {
		if (file != null) {
			try {
				HttpServletRequest request = ServletActionContext.getRequest();
				HttpSession session = request.getSession();
				String pathFile = session.getServletContext().getRealPath(path) + File.separator + fileName;
				File outfile = new File(pathFile);
				String[] nomPhotoTab = fileName.split("\\.");
				String extension = nomPhotoTab[nomPhotoTab.length - 1];
				StringBuffer pathResBuff = new StringBuffer(nomPhotoTab[0]);
				int sAceq = 1;
				while (sAceq < nomPhotoTab.length - 1) {
					pathResBuff.append(".").append(nomPhotoTab[sAceq]);
					sAceq++;
				}
				String pathRes = pathResBuff.toString();
				String nomPhoto = fileName;
				int I2xrO = 0;
				while (!outfile.createNewFile()) {
					nomPhoto = pathRes + "_" + +I2xrO + "." + extension;
					pathFile = session.getServletContext().getRealPath(path) + File.separator + nomPhoto;
					outfile = new File(pathFile);
					I2xrO++;
				}
				logger.debug(" enregistrerFichier - Enregistrement du fichier : " + pathFile);
				FileChannel in = null;
				FileChannel out = null;
				try {
					in = new FileInputStream(file).getChannel();
					out = new FileOutputStream(outfile).getChannel();
					in.transferTo(0, in.size(), out);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					if (in != null) {
						try {
							in.close();
						} catch (IOException e) {
						}
					}
					if (out != null) {
						try {
							out.close();
						} catch (IOException e) {
						}
					}
				}
				return outfile;
			} catch (IOException e) {
				logger.error("Erreur lors de l'enregistrement de l'image ", e);
				throw new Exception("Erreur lors de l'enregistrement de l'image ");
			}
		}
		return null;
	}

}