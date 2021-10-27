class n12462567 {
	public ViewProperties(String pJBkok3b, String B7LVt0Sz) throws Exception {
            FileInputStream OOEATi5U = null;
            String pthjIQ3D = pJBkok3b + "/" + B7LVt0Sz + ".properties";
            properties = new Properties();
            try {
                URL AyFH5Tf4 = MapViewer.class.getResource(pthjIQ3D);
                properties.load(AyFH5Tf4.openStream());
                viewName = (String) properties.get("view.name");
                viewShape = (String) properties.get("view.shape");
                path = pJBkok3b + "/" + (String) properties.get("icon.path");
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
            } catch (Exception PU3dXMj8) {
                error("Cannot load properties from file [" + pthjIQ3D + "]");
                throw PU3dXMj8;
            }
        }

}