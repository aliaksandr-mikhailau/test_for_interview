package task1;

import java.util.Map;

public class RefactorTask {
    private static final String FEATURED_COMPONENT_VIEW = "featuredView";
    private static final String DEFAULT_COMPONENT_VIEW = "defaultView";
    private static final int TWO_COLUMNS = 2;
    private static final int ONE_COLUMN = 2;

    public int getColumnsCount(Map<String, String> properties) {
        String featuredContent = properties.get("featuredContent");
        String description = properties.get("description");
        String contentView = properties.get("contentView");
        if (contentView == null) {
            contentView = DEFAULT_COMPONENT_VIEW;
        }
        return getColumnsCount(properties, featuredContent, contentView, description);
    }

    private int getColumnsCount(Map<String, String> properties, String featuredContent,
                                String contentView,
                                String description) {
        boolean featuredColumnIsPresent = ((featuredContent != null)
                || (!FEATURED_COMPONENT_VIEW.equals(contentView) || description != null));
        int columnsCount = Integer.parseInt(properties.get("columnsCount"));

        if (featuredColumnIsPresent || !FEATURED_COMPONENT_VIEW.equals(contentView)) {
            columnsCount = columnsCount > 2 ? TWO_COLUMNS : ONE_COLUMN;
        }

        return columnsCount;
    }

}