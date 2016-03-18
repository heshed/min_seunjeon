import com.google.common.base.Joiner;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.List;

public class Main {
    private static void analyze_text(String from, String to) throws IOException {
        AnalysisKorean ak = new AnalysisKorean();
        Synonyms syns = null;
        try {
            syns = new Synonyms();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File f = new File(from);
        File[] file_list = f.listFiles();
        for (File tf: file_list) {
            List<String> all_lines = Files.readAllLines(Paths.get(tf.getPath()), Charset.defaultCharset());
            // create file
            String new_path = to + "/" + tf.getName();
            File wfile = new File(new_path);
            if (!wfile.exists()) {
                wfile.createNewFile();
            }

            FileWriter fw = new FileWriter(wfile.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            for (String line: all_lines) {
                String result = "";
                List noun_list = ak.getNouns(line);
                for (Object noun : noun_list) {
                    String synWord = syns.get(noun.toString());
                    result += " " + synWord;
                }
                result += "\n";
                bw.write(result);
            }
            bw.close();
            System.out.println(new_path);
        }
    }

    public static void main(String[] args) throws IOException {
        // analyze_text("text_selected", "text_selected_noun");

        // work-2016-03-18
        analyze_text("work-4-utf8", "work-4-utf8-noun");
    }
}
