class n12462567 {
	public ViewProperties(String basePath, String baseFile) throws Exception {
            String file = basePath + "/" + baseFile + ".properties";
            FileInputStream input = null;
            properties = new Properties();
            try {
                URL url = MapViewer.class.getResource(file);
                properties.load(url.openStream());
                viewName = (String) properties.get("view.name");
                viewShape = (String) properties.get("view.shape");
                path = basePath + "/" + (String) properties.get("icon.path");
                iconHeight = getIntProperty("icon.height", 96);
                iconWidth = getIntProperty("icon.width", 96);
                fontSizeSmall = getIntProperty("font.small.size", 10);
                fontSizeMedium = getIntProperty("font.medium.size", 12);
                fontSizeLarge = getIntProperty("font.large.size", 16);
                fontSizeHuge = getIntProperty("font.huge.size", 20);
                if (viewShape.equals("Hexagonal")) {
                    tileHeight = (int) (Math.sqrt(3.0) / 2.0 * iconWidth);
                    tileWidth = (int) (iconWidth * 3.0 / 4.0);
                    tileOffset = (int) (tileHeight / 2.0);
                } else {
                    tileHeight = iconHeight;
                    tileWidth = iconWidth;
                    tileOffset = 0;
                }
            } catch (Exception e) {
                error("Cannot load properties from file [" + file + "]");
                throw e;
            }
        }

}