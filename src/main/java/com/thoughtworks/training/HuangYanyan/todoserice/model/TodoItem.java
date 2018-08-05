package com.thoughtworks.training.huangyanyan.todoserice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "todo")

@SQLDelete(sql = "UPDATE todo SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class TodoItem {
    @Id
    @GeneratedValue
    private int id;
    private String text;

    @JsonProperty(value = "visible")
    private boolean getVisible() {
        return true;
    }

    @Column(columnDefinition = "DATATIME")
    private Date time;

    @Transient
    private boolean completed;


    private boolean editable;
    private boolean visible;

    private int userid;

    @OneToMany(cascade = {CascadeType.REMOVE, CascadeType.ALL}, mappedBy = "todoItem")
    private List<TaskItem> taskItems = new ArrayList<>();


}
