package de.battlesucht.api.utils.files;

import de.battlesucht.api.utils.server.Console;
import de.battlesucht.api.utils.server.ConsoleClassType;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class FileBuilder {

    private File file;
    private YamlConfiguration yml;

    public FileBuilder(String path) {
        String s = path;
        if(!s.contains("plugins/")){
            s = "plugins/API/"+path;
        }
        file = new File(s);
        yml = YamlConfiguration.loadConfiguration(file);
    }

    public YamlConfiguration getYaml() {
        return yml;
    }

    public File getFile() {
        return file;
    }

    public void save() {
        try {
            yml.save(file);
        } catch (IOException e) {
            new Console(e.getMessage(), ConsoleClassType.FileBuilder);
        }
    }

}
