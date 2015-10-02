import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by md on 15. 10. 2..
 */
public class Synonyms {
    String dic_path;
    HashMap<String, String> synmap;

    public Synonyms() throws IOException {
        synmap = new HashMap<String, String>();

        dic_path = "dic/synonyms.txt";
        File f = new File(dic_path);
        List<String> all_lines = Files.readAllLines(Paths.get(dic_path), Charset.defaultCharset());
        for (String line : all_lines) {
            String[] tokens = line.split(",");
            String leader = tokens[0];
            String[] subs = Arrays.copyOfRange(tokens, 1, tokens.length);
            for (String tok : subs) {
                synmap.put(tok, leader);
            }
        }
    }

    public String get(String word) {
        if (synmap.containsKey(word)) {
            return synmap.get(word).toString();
        }
        return word;
    }

    public void dump() {
        for (Object key : synmap.keySet()) {
            System.out.print(key.toString());
            System.out.println(": " + synmap.get(key.toString()));
        }
    }
}
