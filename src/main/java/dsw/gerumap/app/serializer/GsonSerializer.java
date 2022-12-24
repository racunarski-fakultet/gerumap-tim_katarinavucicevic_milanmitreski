package dsw.gerumap.app.serializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dsw.gerumap.app.core.Serializer;
import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.composite.MapNodeComposite;
import dsw.gerumap.app.mapRepository.implementation.MindMap;
import dsw.gerumap.app.mapRepository.implementation.Project;
import dsw.gerumap.app.mapRepository.implementation.Relation;
import dsw.gerumap.app.mapRepository.implementation.Term;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class GsonSerializer implements Serializer {
    private final Gson gson = new GsonBuilder().registerTypeAdapter(MapNode.class, new ProjectDeserializer()).create();


    @Override
    public Project loadProject(File file) {
        try (FileReader fileReader = new FileReader(file)) {
            Project project = gson.fromJson(fileReader, Project.class);
            for(MapNode child : project.getChildren()) {
                child.setParent(project);
                MapNodeComposite childComposite = (MapNodeComposite) child;
                for(MapNode grandchild : childComposite.getChildren()) {
                    if(grandchild instanceof Relation) {
                        Relation relation = (Relation) grandchild;
                        relation.setTermFrom((Term)childComposite.getChildByName(relation.getTermFrom().getName()));
                        relation.setTermTo((Term)childComposite.getChildByName(relation.getTermTo().getName()));
                        System.out.println(relation.getTermFrom() + " " + relation.getTermTo());
                    } else {
                        System.out.println(grandchild);
                    }
                    grandchild.setParent(childComposite);
                }
            }
            return project;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void saveProject(Project project) {
        try (FileWriter writer = new FileWriter(project.getFilePath())) {
            gson.toJson(project, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public MindMap loadTemplate(File file) {
        try (FileReader fileReader = new FileReader(file)) {
            MindMap map = gson.fromJson(fileReader, MindMap.class);
            for(MapNode child : map.getChildren()) {
                if(child instanceof Relation) {
                    Relation relation = (Relation) child;
                    relation.setTermFrom((Term)map.getChildByName(relation.getTermFrom().getName()));
                    relation.setTermTo((Term)map.getChildByName(relation.getTermTo().getName()));
                    System.out.println(relation.getTermFrom() + " " + relation.getTermTo());
                } else {
                    System.out.println(map);
                }
                child.setParent(map);
            }
            return map;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void saveTemplate(MindMap mindMap) {
        System.out.println(getClass().getResource(MindMap.getTemplatePath()));
        try (FileWriter writer = new FileWriter(Objects.requireNonNull(getClass().getResource(MindMap.getTemplatePath())).getPath()+ System.getProperty("file.separator") + mindMap.getName() + ".json")) {
            gson.toJson(mindMap, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
