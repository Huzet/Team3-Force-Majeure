import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

class GameData {
    Map<String, Room> roomMap;
    Map<String, NPC> npcMap;

    public GameData() {
        loadGame();
    }

    @SuppressWarnings("unchecked")
    void loadGame() {

        try {
            roomMap =
                    (Map<String, Room>) readJsonFileAndConvertToMap(
                            "rooms.json", "room");
            npcMap =
                    (Map<String, NPC>) readJsonFileAndConvertToMap(
                            "npcs.json", "npc");
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        if (roomMap == null || npcMap == null) {
            throw new RuntimeException("Unable to load game data");
        }

        // loop thru roomMap and check for npc's
//        for (var entry : roomMap.entrySet()) {
//            System.out.println(entry.getValue().getNpc());
//            if ("npc".equals(entry.getKey())) {
//                System.out.println("got npc");
//            }
//        }
    }

    Map<String, ?> readJsonFileAndConvertToMap(String fileName, String objectType) {
        Type type = null;

        if ("room".equals(objectType)) {
            type = new TypeToken<Map<String, Room>>() {}.getType();
        } else if ("npc".equals(objectType)) {
            type = new TypeToken<Map<String, NPC>>() {}.getType();
        } else {
            throw new IllegalArgumentException("Object type does not exist");
        }

        try {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Path path = Path.of(Objects.requireNonNull(
                    Main.class.getResource(String.format("./%s", fileName))).toURI());

            Reader reader = Files.newBufferedReader(path);

            // can't close reader here

            return gson.fromJson(reader, type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}