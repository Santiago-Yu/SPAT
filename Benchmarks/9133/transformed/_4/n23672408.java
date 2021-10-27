class n23672408 {
	private void copyIconFiles(UmlClass clazz) {
		if (clazz.hasAnnotation("icon16")) {
			String i16 = clazz.annotationValue("icon16");
			String fileType = ".png";
			fileType = (i16.endsWith(".jpg")) ? ".jpg" : fileType;
			fileType = (i16.endsWith(".gif")) ? ".gif" : fileType;
			String desti16 = output_dir + "/../resources/images/" + clazz.getName() + "16" + fileType;
			try {
				FileChannel src = new FileInputStream(i16).getChannel();
				FileChannel dst = new FileOutputStream(desti16).getChannel();
				dst.transferFrom(src, 0, src.size());
				src.close();
				dst.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (clazz.hasAnnotation("icon32")) {
			String i32 = clazz.annotationValue("icon32");
			String fileType = ".png";
			fileType = (i32.endsWith(".jpg")) ? ".jpg" : fileType;
			fileType = (i32.endsWith(".gif")) ? ".gif" : fileType;
			String desti32 = output_dir + "/../resources/images/" + clazz.getName() + "32" + fileType;
			try {
				FileChannel src = new FileInputStream(i32).getChannel();
				FileChannel dst = new FileOutputStream(desti32).getChannel();
				dst.transferFrom(src, 0, src.size());
				src.close();
				dst.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}