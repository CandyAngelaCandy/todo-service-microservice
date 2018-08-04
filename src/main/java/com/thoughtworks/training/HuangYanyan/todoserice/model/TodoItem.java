package com.thoughtworks.training.HuangYanyan.todoserice.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="todo")

@SQLDelete(sql = "UPDATE todo SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class TodoItem {
    @Id
    @GeneratedValue
    private int id;
    private String text;

    @JsonProperty(value = "visible")
    private boolean getVisible(){
        return true;
    }

    @Column(columnDefinition = "DATATIME")
    private Date time;

    @Transient
    private boolean completed;


    private boolean editable;
    private boolean visible;

    @OneToMany(cascade = {CascadeType.REMOVE,CascadeType.ALL},mappedBy = "todoItem")
    private List<TaskItem> taskItems = new ArrayList<>();

//    @ManyToOne(cascade = {CascadeType.ALL})
//    @JoinColumn(name="TODOID")
//    private TodoItem todoItem;

}
