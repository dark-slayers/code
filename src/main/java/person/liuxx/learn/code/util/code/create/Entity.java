package person.liuxx.learn.code.util.code.create;

import lombok.Data;

/**
 * @author
 * 
 * @version 1.0.0<br>
 *          创建时间：2022年8月18日 下午3:43:49
 * 
 * @since 1.0.0
 */
@Data
public class Entity {
    private String entityPackage;
    private String daoPackage;
    private String servicePackage;
    private String controllerPackage;
    private String projectPath;
    private String className;
    private String smallClassName;

    public Entity(String basePackage, String projectPath, String className) {
        this.entityPackage = basePackage + ".entity";
        this.daoPackage = basePackage + ".dao";
        this.servicePackage = basePackage + ".service";
        this.controllerPackage = basePackage + ".controller";
        this.projectPath = projectPath;
        this.className = className;
        this.smallClassName = className.substring(0, 1).toLowerCase() + className.substring(1);
    }
}
