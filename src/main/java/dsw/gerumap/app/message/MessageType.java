package dsw.gerumap.app.message;

public enum MessageType {

    NODE_CANNOT_BE_DELETED("NODE CANNOT BE DELETED"),
    NODE_NOT_PROJECT("NODE NOT PROJECT"),
    NODE_NOT_SELECTED("NODE NOT SELECTED"),
    NODE_NOT_COMPOSITE("NODE NOT COMPOSITE"),
    NAME_CANNOT_BE_EMPTY("NAME CANNOT BE EMPTY"),
    NODE_NOT_CREATED("NODE NOT CREATED"), FILE_NOT_FOUND("FILE NOT FOUND");

    private String text;

    private MessageType(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
