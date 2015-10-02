import com.google.common.base.Joiner;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        AnalysisKorean ak = new AnalysisKorean();

        File f = new File("text_selected");
        File[] file_list = f.listFiles();
        for (File tf: file_list) {
            List<String> all_lines = Files.readAllLines(Paths.get(tf.getPath()), Charset.defaultCharset());
            // create file
            String new_path = "text_selected_noun/" + tf.getName();
            File wfile = new File(new_path);
            if (!wfile.exists()) {
                wfile.createNewFile();
            }

            FileWriter fw = new FileWriter(wfile.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            for (String line: all_lines) {
                List noun_list = ak.getNouns(line);
                String result = Joiner.on(" ").join(noun_list) + "\n";
                bw.write(result);
            }
            bw.close();
            System.out.println(new_path);
        }

    }
}
