package dsw.gerumap.app.message;

public enum MessageType {

    NODE_CANNOT_BE_DELETED("NODE CANNOT BE DELETED"),
    NODE_NOT_PROJECT("NODE NOT PROJECT"),
    NODE_NOT_SELECTED("NODE NOT SELECTED"),
    NODE_NOT_COMPOSITE("NODE NOT COMPOSITE"),
    NAME_CANNOT_BE_EMPTY("NAME CANNOT BE EMPTY"),
    NODE_NOT_CREATED("NODE NOT CREATED"),
    NODE_CANNOT_BE_RENAMED("NODE CANNOT BE RENAMED"),
    ELEMENT_ADDITION_EXCLUSIVE_TO_SIDE_TOOLBAR("ELEMENT ADDITION EXCLUSIVE TO SIDE TOOLBAR"),
    NO_PROJECT_VIEW_FOR_STATE("NO PROJECT VIEW FOR STATE CHANGED"),
    NO_MAP_VIEW_FOR_SETTINGS("NO MAP VIEW FOR SETTINGS"),
    ELEMENT_FOUND_AT_POINT("ELEMENT FOUND AT POINT"),
    RELATION_FOUND_BETWEEN_TERMS("RELATION FOUND BETWEEN TERMS"),
    ONLY_PROJECT_SERIALIZABLE("ONLY PROJECT SERIALIZABLE"),
    NO_MIND_MAP_TO_EXPORT("NO MIND MAP TO EXPORT"),
    ONLY_MIND_MAPS_ARE_TEMPLATES("ONLY MIND MAPS ARE TEMPLATES"),
    NO_PROJECT_SELECTED("NO PROJECT SELECTED"),
    RESOURCE_NOT_FOUND("RESOURCE NOT FOUND"),
    LOG_FILE_NOT_FOUND("LOG FILE NOT FOUND");

    private final String text;

    MessageType(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
