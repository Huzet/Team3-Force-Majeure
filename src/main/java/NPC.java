import java.util.Map;

public class NPC {
    public String name;
    public String description;
    public Map<String,String> dialogue;
    public Map<String,String> endings;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, String> getDialogue() {
        return dialogue;
    }

    public void setDialogue(Map<String, String> dialogue) {
        this.dialogue = dialogue;
    }

    public Map<String, String> getEndings() {
        return endings;
    }

    public void setEndings(Map<String, String> endings) {
        this.endings = endings;
    }
}