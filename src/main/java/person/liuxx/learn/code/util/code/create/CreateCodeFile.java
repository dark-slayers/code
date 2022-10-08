package person.liuxx.learn.code.util.code.create;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import person.liuxx.util.file.FileUtil;

/**
 * @author
 * 
 * @version 1.0.0<br>
 *          创建时间：2022年8月8日 下午3:26:26
 * 
 * @since 1.0.0
 */
public class CreateCodeFile {
    private Entity entity;

    public CreateCodeFile(Entity entity) {
        this.entity = entity;
    }

    public void createDao() {
        readTemplateAndWrite("dao.txt", "dao/", "Repository.java");
    }

    public void createService() {
        readTemplateAndWrite("service.txt", "service/", "Service.java");
        readTemplateAndWrite("serviceImpl.txt", "service/impl/", "ServiceImpl.java");
    }

    public void createController() {
        readTemplateAndWrite("controller.txt", "controller/", "Controller.java");
    }

    private Path getTemplatePath() {
        String thisPath = CreateCodeFile.class.getProtectionDomain()
                .getCodeSource()
                .getLocation()
                .toString()
                .substring(6);
        System.out.println(thisPath);
        return Paths.get(thisPath + "template/");
    }

    private void writeFile(Path path, List<String> lines) {
        System.out.println("写入文件：" + path);
        if (Files.exists(path)) {
            System.out.println("文件" + path + "已经存在");
        } else {
            try {
                FileUtil.createEmptyFileIfNotExists(path);
                Files.write(path, lines);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void readTemplateAndWrite(String fileName, String dir, String fileEnd) {
        try {
            System.out.println("读取文件：" + getTemplatePath().resolve(fileName));
            List<String> lines = Files.lines(getTemplatePath().resolve(fileName))
                    .map(t -> replace(t))
                    .collect(Collectors.toList());
            System.out.println("------");
            System.out.println(lines);
            System.out.println("======");
            writeFile(Paths.get(entity.getProjectPath() + dir + entity.getClassName() + fileEnd),
                    lines);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private String replace(String text) {
        text = text.replaceAll("\\$\\{daoPackage\\}", entity.getDaoPackage());
        text = text.replaceAll("\\$\\{className\\}", entity.getClassName());
        text = text.replaceAll("\\$\\{entityPackage\\}", entity.getEntityPackage());
        text = text.replaceAll("\\$\\{servicePackage\\}", entity.getServicePackage());
        text = text.replaceAll("\\$\\{serviceImplPackage\\}", entity.getServicePackage() + ".impl");
        text = text.replaceAll("\\$\\{controllerPackage\\}", entity.getControllerPackage());
        text = text.replaceAll("\\$\\{smallClassName\\}", entity.getSmallClassName());
        return text;
    }

    public static void main(String[] args) {
        Entity entity = new Entity("cn.hnbala.wx",
                "D:/DK/GitProject/bala-wx-service/src/main/java/cn/hnbala/wx/", "WxConstructionUserSign");
        CreateCodeFile createCodeFile = new CreateCodeFile(entity);
        createCodeFile.createDao();
        createCodeFile.createService();
//        createCodeFile.createController();
    }
}
