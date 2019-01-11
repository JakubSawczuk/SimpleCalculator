import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;

@Component
public class Run {

    public static void main(String[] args) throws IOException, URISyntaxException {

        FileReader fileReader = new FileReader();
        fileReader.readFileData();
    }
}
