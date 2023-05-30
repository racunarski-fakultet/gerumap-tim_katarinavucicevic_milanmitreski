package dsw.gerumap.app.core;

import dsw.gerumap.app.mapRepository.implementation.MindMap;
import dsw.gerumap.app.mapRepository.implementation.Project;

import java.io.File;

public interface Serializer {

    Project loadProject(File file);
    void saveProject(Project project);

    MindMap loadTemplate(File file);
    void saveTemplate(MindMap mindMap);
}
