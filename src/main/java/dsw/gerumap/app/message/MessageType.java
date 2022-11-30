package dsw.gerumap.app.message;

public enum MessageType {

    NODE_CANNOT_BE_DELETED("NODE CANNOT BE DELETED"),
    NODE_NOT_PROJECT("NODE NOT PROJECT"),
    NODE_NOT_SELECTED("NODE NOT SELECTED"),
    NODE_NOT_COMPOSITE("NODE NOT COMPOSITE"),
    NAME_CANNOT_BE_EMPTY("NAME CANNOT BE EMPTY"),
    NODE_NOT_CREATED("NODE NOT CREATED"),
    NODE_CANNOT_BE_RENAMED("NODE CANNOT BE RENAMED"), ELEMENT_ADDITON_EXCLUSIVE_TO_SIDETOOLBAR("ELEMENT ADDTION EXCLUSIVE TO SIDETOOLBAR");

    private final String text;

    MessageType(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
