package org.example.model;

import java.io.Serializable;

import com.sf.framework.domain.BaseRequest;

import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;
import net.sf.oval.constraint.Size;

/**
 * 该类与数据库中的表demo_user对应 
 * 
 * @author 698533
 */
public class DemoUser extends BaseRequest implements Serializable {
    private Integer id;

    @NotNull(errorCode="001",message="[code]${parameter.not.null}")
    @NotEmpty(errorCode="001",message="[code]${parameter.not.null}")
    @NotBlank(errorCode="001",message="[code]${parameter.not.null}")
    private String code;

    @Size(min = 5, max = 50, errorCode = "001",message = "[name]${parameter.size.invalid}")
    private String name;

    private String description;

    private String comment;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", code=").append(code);
        sb.append(", name=").append(name);
        sb.append(", description=").append(description);
        sb.append(", comment=").append(comment);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}